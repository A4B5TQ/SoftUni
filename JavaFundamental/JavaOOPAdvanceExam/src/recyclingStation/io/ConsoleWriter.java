package recyclingStation.io;

import recyclingStation.io.interfaces.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }
}
