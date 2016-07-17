package javaOOPBasics.eliDemo.core;

import javaOOPBasics.eliDemo.commandDispatcher.DispatchCommand;
import javaOOPBasics.eliDemo.exceptions.MyException;
import javaOOPBasics.eliDemo.io.Reader;
import javaOOPBasics.eliDemo.io.Writer;

public class CurrentEngine implements Engine {
    private Writer writer;
    private Reader reader;
    private DispatchCommand dispatchCommand;

    public CurrentEngine(Reader reader, Writer writer, DispatchCommand dispatchCommand) {
        this.reader = reader;
        this.writer = writer;
        this.dispatchCommand = dispatchCommand;
    }

    @Override
    public void run() {

        String str = this.reader.read();
        String[] input = str.split("\\s+");

        try {
            this.dispatchCommand.dipatch();
        }catch (MyException ex){
            System.out.println(ex.getMessage());
        }




        this.writer.write(input[0]);
    }
}
