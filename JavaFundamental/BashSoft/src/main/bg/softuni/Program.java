package main.bg.softuni;


import main.bg.softuni.io.CommandInterpreter;
import main.bg.softuni.io.IOManager;
import main.bg.softuni.io.InputReader;
import main.bg.softuni.io.OutputWriter;
import main.bg.softuni.judge.Tester;
import main.bg.softuni.network.DownloadManager;
import main.bg.softuni.repository.RepositoryFilter;
import main.bg.softuni.repository.RepositorySorter;
import main.bg.softuni.repository.StudentRepository;
import main.bg.softuni.interfaces.*;

public class Program {

    public static void main(String[] args) {

        ContentComparer tester = new Tester();
        AsynchDownloader downloadManager = new DownloadManager();
        DirectoryManager ioManager = new IOManager();
        DataFilter repositoryFilter = new RepositoryFilter();
        DataSorter repositorySorter = new RepositorySorter();
        Database studentRepository = new StudentRepository(repositoryFilter,repositorySorter);
        Interpreter commandInterpreter = new CommandInterpreter(
                tester,studentRepository,downloadManager,ioManager);
        Reader reader = new InputReader(commandInterpreter);

        try {
            reader.readCommands();
        } catch (Exception e) {
            OutputWriter.displayException(e.getMessage());
        }
    }
}
