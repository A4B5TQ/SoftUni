package main.bg.softuni.io;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.annotations.Inject;
import main.bg.softuni.interfaces.*;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CommandInterpreter implements Interpreter {

    private static String COMMANDS_LOCATION = "src/main/bg/softuni/io/commands";
    private static String COMMANDS_PACKAGE = "main.bg.softuni.io.commands.";

    private ContentComparer tester;
    private Database repository;
    private AsynchDownloader downloadManager;
    private DirectoryManager inputOutputManager;

    public CommandInterpreter(ContentComparer tester, Database repository, AsynchDownloader downloadManager, DirectoryManager inputOutputManager) {
        this.tester = tester;
        this.repository = repository;
        this.downloadManager = downloadManager;
        this.inputOutputManager = inputOutputManager;
    }

    public void interpretCommand(String input) throws IOException {
        String[] data = input.split("\\s+");
        String commandName = data[0].toLowerCase();
        try {
            Executable command = parseCommand(input, data, commandName);
            command.execute();
        } catch (Exception t) {
            OutputWriter.displayException(t.getMessage());
        }

    }

    private Executable parseCommand(String input, String[] data, String commandName) throws IOException {
        File commandsFolder = new File(COMMANDS_LOCATION);
        Executable executable = null;

        for (File file : commandsFolder.listFiles()) {

            if (!file.isFile() || !file.getName().endsWith(".java")) {
                continue;
            }

            try {
                String className = file.getName().substring(0, file.getName().lastIndexOf("."));
                Class<Executable> exeClass = (Class<Executable>) Class.forName(COMMANDS_PACKAGE + className);
                if (!exeClass.isAnnotationPresent(Alias.class)) {
                    continue;
                }

                Alias aliasAnnotation = exeClass.getAnnotation(Alias.class);
                String value = aliasAnnotation.value();
                if (!value.equalsIgnoreCase(commandName)) {
                    continue;
                }

                Constructor constructor = exeClass.getConstructor(String.class, String[].class);
                executable = (Executable) constructor.newInstance(input, data);
                this.injectDependencies(executable, exeClass);

            } catch (ReflectiveOperationException rfe) {
                rfe.printStackTrace();
            }
        }
//        switch (commandName) {
//            case "mkdir":
//                return new MakeDirectoryCommand(input, data);
//
//            case "ls":
//                return new TraverseFoldersCommand(input, data);
//
//            case "cmp":
//                return new CompareFilesCommand(input, data);
//
//            case "cdrel":
//                return new ChangeRelativePathCommand(input, data);
//
//            case "cdabs":
//                return new ChangeAbsolutePathCommand(input, data);
//
//            case "readdb":
//                return new ReadDatabaseCommand(input, data);
//
//            case "filter":
//                return new PrintFilteredStudentsCommand(input, data);
//
//            case "order":
//                return new PrintOrderedStudentsCommand(input, data);
//
//            case "download":
//                return new DownloadFileCommand(input, data);
//
//            case "downloadasynch":
//                return new DownloadAsynchCommand(input, data);
//
//            case "help":
//                return new GetHelpCommand(input, data);
//
//            case "open":
//                return new OpenFileCommand(input, data);
//
//            case "show":
//                return new ShowCourseCommand(input, data);
//
//            case "dropdb":
//                return new DropDatabaseCommand(input, data);
//
//            case "display":
//                return new DisplayCommand(input, data);
//
//            default:
//                throw new InvalidInputException(input);

//        }

        return executable;
    }

    private void injectDependencies(Executable executable, Class<Executable> exeClass) throws IllegalAccessException {
        Field[] fieldsToSet = exeClass.getDeclaredFields();
        for (Field field : fieldsToSet) {
            if (!field.isAnnotationPresent(Inject.class)){
                continue;
            }

            field.setAccessible(true);
            Field[] theseFields = CommandInterpreter.class.getDeclaredFields();
            for (Field thisField : theseFields) {
                if (!thisField.getType().equals(field.getType())){
                    continue;
                }
                thisField.setAccessible(true);
                field.set(executable, thisField.get(this));
            }
        }
    }


    private void displayInvalidCommandMessage(String input) {

        String output = String.format("The command %s is invalid", input);
        OutputWriter.writeMessageOnNewLine(output);
    }


}
