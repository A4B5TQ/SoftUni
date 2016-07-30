package main.bg.softuni.io.commands;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.annotations.Inject;
import main.bg.softuni.exceptions.InvalidInputException;
import main.bg.softuni.interfaces.AsynchDownloader;
import main.bg.softuni.interfaces.Executable;

@Alias(value = "download")
public class DownloadFileCommand extends Command implements Executable {

    @Inject
    private AsynchDownloader downloadManager;

    public DownloadFileCommand(String input,
                               String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {

        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        String url = data[1];
        this.downloadManager.download(url);
    }
}
