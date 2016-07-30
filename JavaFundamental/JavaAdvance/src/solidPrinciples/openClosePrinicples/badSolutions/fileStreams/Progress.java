package solidPrinciples.openClosePrinicples.badSolutions.fileStreams;

public class Progress {
    private File file;

    public Progress(File file) {
        this.file = file;
    }

    public int calcCurrentPercent(){
        return this.file.getBytesSent() * 100 / this.file.getLength();
    }
}
