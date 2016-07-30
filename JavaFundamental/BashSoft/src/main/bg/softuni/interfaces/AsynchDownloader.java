package main.bg.softuni.interfaces;

public interface AsynchDownloader extends Downloader{
    void downloadOnNewThread(String fileUrl);
}
