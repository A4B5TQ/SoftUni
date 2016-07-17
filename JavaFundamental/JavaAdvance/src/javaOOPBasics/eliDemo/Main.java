package javaOOPBasics.eliDemo;

import javaOOPBasics.eliDemo.commandDispatcher.DispatchCommand;
import javaOOPBasics.eliDemo.commandDispatcher.SecondDispatcher;
import javaOOPBasics.eliDemo.core.CurrentEngine;
import javaOOPBasics.eliDemo.core.Engine;
import javaOOPBasics.eliDemo.io.FileReader;
import javaOOPBasics.eliDemo.io.FileWriter;
import javaOOPBasics.eliDemo.io.Reader;
import javaOOPBasics.eliDemo.io.Writer;

public class Main {

    public static void main(String[] args) {

        Writer writer = new FileWriter();
        Reader reader = new FileReader();
        DispatchCommand dispatchCommand = new SecondDispatcher();


        Engine engine = new CurrentEngine(reader,writer, dispatchCommand);
        engine.run();


    }
}
