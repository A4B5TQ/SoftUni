package main.bg.softuni.io.commands;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.exceptions.InvalidInputException;
import main.bg.softuni.interfaces.Executable;
import main.bg.softuni.io.OutputWriter;

import java.io.*;

@Alias(value = "help")
public class GetHelpCommand extends Command implements Executable {

    public GetHelpCommand(String input,
                          String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 1) {
            throw new InvalidInputException(this.getInput());
        }
        displayHelp();
    }

    //TODO outputWriter
    private void displayHelp() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(new File("resources/getHelp.txt")));
        String line = reader.readLine();
        while (line != null) {
            OutputWriter.writeMessageOnNewLine(line);
            line = reader.readLine();
        }
    }
}
