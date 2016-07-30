package main.bg.softuni.io.commands;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.annotations.Inject;
import main.bg.softuni.exceptions.InvalidInputException;
import main.bg.softuni.interfaces.Executable;
import main.bg.softuni.interfaces.Database;

@Alias(value = "readdb")
public class ReadDatabaseCommand extends Command implements Executable {

    @Inject
    private Database studentRepository;

    public ReadDatabaseCommand(String input,
                               String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {

        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        String fileName = data[1];
        this.studentRepository.loadData(fileName);
    }
}
