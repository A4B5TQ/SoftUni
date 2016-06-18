package IO;

import Judge.Tester;
import Network.DowloadManager;
import Repository.StudentRepository;
import StaticData.ExceptionMessages;
import StaticData.SessionData;

import java.awt.*;
import java.io.*;

public class CommandInterpreter {

    public static void interpretCommand(String input) {

        String[] data = input.split("\\s+");
        String command = data[0];

        switch (command) {

            case "mkdir":
                tryCreateDirectory(input, data);
                break;

            case "ls":
                tryTraverseFolders(input, data);
                break;

            case "cmp":
                tryCompareFiles(input, data);
                break;

            case "changeDirRel":
                tryChangeRelativePath(input, data);
                break;

            case "changeDirAbs":
                tryChangeAbsolutePath(input, data);
                break;

            case "readDb":
                tryReadDatabaseFromFile(input, data);
                break;

            case "filter":
                tryPrintFilteredStudents(input, data);
                break;

            case "order":
                tryPrintOrderedStudents(input, data);
                break;

            case "download":
                tryDownloadFile(input, data);
                break;

            case "downloadAsynch":
                tryDownloadFileOnNewThread(input, data);
                break;

            case "help":
                getHelp();
                break;

            case "open":
                tryOpenData(input, data);
                break;

            case "show":
                tryShowWantedCourse(input, data);
                break;

            default:
                displayInvalidCommandMessage(input);
                break;
        }

    }

    private static void tryDownloadFileOnNewThread(String input, String[] data) {
        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }

        String url = data[1];
        DowloadManager.downloadOnNewThread(url);
    }

    private static void tryDownloadFile(String input, String[] data) {
        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }

        String url = data[1];
        DowloadManager.download(url);
    }

    private static void tryPrintFilteredStudents(String input, String[] data) {

        if (data.length != 3 && data.length != 4) {
            displayInvalidCommandMessage(input);
            return;
        }

        String course = data[1];
        String filter = data[2];

        if (data.length == 3) {
            StudentRepository.printFilteredStudents(course, filter, null);
            return;
        }

        if (data.length == 4) {
            Integer numberOfStudent = Integer.valueOf(data[3]);
            StudentRepository.printFilteredStudents(course, filter, numberOfStudent);
        }


    }

    private static void tryPrintOrderedStudents(String input, String[] data) {

        if (data.length != 3 && data.length != 4) {
            displayInvalidCommandMessage(input);
            return;
        }

        String course = data[1];
        String compareType = data[2];

        if (data.length == 3) {
            StudentRepository.printOrderedStudents(course, compareType, null);
        }

        if (data.length == 4) {
            Integer numberOfStudent = Integer.valueOf(data[3]);
            StudentRepository.printOrderedStudents(course, compareType, numberOfStudent);
        }
    }

    private static void tryShowWantedCourse(String input, String[] data) {

        if (data.length != 2 && data.length != 3) {
            displayInvalidCommandMessage(input);
            return;
        }

        if (data.length == 2) {

            String courseName = data[1];
            StudentRepository.getStudentsByCourse(courseName);
        }

        if (data.length == 3) {

            String courseName = data[1];
            String userName = data[2];
            StudentRepository.getStudentMarksInCourse(courseName, userName);
        }
    }

    private static void tryReadDatabaseFromFile(String input, String[] data) {

        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }

        String fileName = data[1];
        StudentRepository.initializeData(fileName);

    }

    private static void tryChangeAbsolutePath(String input, String[] data) {

        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }

        String absolutePath = data[1];
        IOManager.changeCurrentDirAbsolute(absolutePath);
    }

    private static void tryChangeRelativePath(String input, String[] data) {

        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }

        String relativePath = data[1];
        IOManager.changeCurrentDirRelativePath(relativePath);

    }

    private static void tryCompareFiles(String input, String[] data) {

        if (data.length != 3) {
            displayInvalidCommandMessage(input);
            return;
        }

        String firstPath = data[1];
        String secondPath = data[2];
        Tester.compareContent(firstPath, secondPath);
    }

    private static void tryTraverseFolders(String input, String[] data) {

        if (data.length != 1 && data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }

        if (data.length == 1) {
            IOManager.traverseDirectory(0);
        }

        if (data.length == 2) {

            int depth = Integer.parseInt(data[1]);
            IOManager.traverseDirectory(depth);
        }
    }

    private static void tryCreateDirectory(String input, String[] data) {

        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }

        String folderName = data[1];
        IOManager.createDirectoryInCurrentFolder(folderName);
    }

    private static void tryOpenData(String input, String[] data) {

        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }

        try {
            String fileName = data[1];
            String filePath = SessionData.currentPath + "\\" + fileName;
            File file = new File(filePath);
            Desktop.getDesktop().open(file);
        } catch (IOException ioe) {
            OutputWriter.displayException(ExceptionMessages.FILE_NOT_FOUND);
        }
    }

    private static void displayInvalidCommandMessage(String input) {

        String output = String.format("The command %s is invalid", input);
        OutputWriter.writeMessageOnNewLine(output);
    }

    private static void getHelp() {

        try (BufferedReader reader = new BufferedReader(new FileReader(new File("resources/getHelp.txt")))) {

            String line = reader.readLine();
            while (line != null) {
                OutputWriter.writeMessageOnNewLine(line);
                line = reader.readLine();
            }

        } catch (IOException ioe) {
            OutputWriter.displayException(ExceptionMessages.FILE_NOT_FOUND);
        }
        OutputWriter.writeEmptyLine();
    }
}
