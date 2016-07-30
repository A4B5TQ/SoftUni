package solidPrinciples.openClosePrinicples.googSolutions.fileStreams;

public class File  implements StreamResult{
    private String name;
    private int length;
    private int bytesSent;

    public int getLength() {
        return length;
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
