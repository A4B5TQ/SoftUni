package main.bg.softuni.interfaces;

public interface DirectoryChanger {
    void changeCurrentDirRelativePath(String relativePath);

    void changeCurrentDirAbsolute(String absolutePath);
}
