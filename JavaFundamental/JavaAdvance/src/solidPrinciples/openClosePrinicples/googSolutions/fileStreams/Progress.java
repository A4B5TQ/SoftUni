package solidPrinciples.openClosePrinicples.googSolutions.fileStreams;

public class Progress {
    private StreamResult result;

    public Progress(StreamResult result) {
        this.result = result;
    }

    public int calcCurrentPercent(){
        return this.result.getBytesSent() * 100 / this.result.getLength();
    }
}
