package solidPrinciples.openClosePrinicples.googSolutions.fileStreams;

public interface StreamResult {
    int getLength();
    void setLength(int length);

    int getBytesSent();
    void setBytesSent(int bytes);

}
