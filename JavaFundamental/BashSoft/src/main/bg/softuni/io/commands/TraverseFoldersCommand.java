package main.bg.softuni.io.commands;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.annotations.Inject;
import main.bg.softuni.exceptions.InvalidInputException;
import main.bg.softuni.interfaces.DirectoryManager;
import main.bg.softuni.interfaces.Executable;

@Alias(value = "ls")
public class TraverseFoldersCommand extends Command implements Executable {

    @Inject
    private DirectoryManager ioManager;

    public TraverseFoldersCommand(String input,
                                  String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 1 && data.length != 2) {
            throw new InvalidInputException(this.getInput());

        }

        if (data.length == 1) {
            this.ioManager.traverseDirectory(0);
            return;
        }

        int depth = Integer.parseInt(data[1]);
        this.ioManager.traverseDirectory(depth);

    }
}
