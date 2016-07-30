package main.bg.softuni.io.commands;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.annotations.Inject;
import main.bg.softuni.exceptions.InvalidInputException;
import main.bg.softuni.interfaces.Executable;
import main.bg.softuni.io.OutputWriter;
import main.bg.softuni.interfaces.Database;

@Alias(value = "dropdb")
public class DropDatabaseCommand extends Command implements Executable {

    @Inject
    private Database studentRepository;

    public DropDatabaseCommand(String input,
                               String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {

        String[] data = this.getData();
        if (data.length != 1) {
            throw new InvalidInputException(this.getInput());
        }

        this.studentRepository.unloadData();
        OutputWriter.writeMessageOnNewLine("Database dropped!");
    }
}
