package solidPrinciples.openClosePrinicples.googSolutions.fileStreams;

public class Music implements StreamResult{
    private int bytesSent;
    private int length;
    private String artist;
    private String album;


    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public void setLength(int length) {

    }

    @Override
    public int getBytesSent() {
        return 0;
    }

    @Override
    public void setBytesSent(int bytes) {

    }
}
