package main.bg.softuni.interfaces;

import java.io.IOException;

public interface Interpreter {
    void interpretCommand(String input) throws IOException;
}
