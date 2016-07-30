package main.bg.softuni.io;

import main.bg.softuni.interfaces.Interpreter;
import main.bg.softuni.interfaces.Reader;
import main.bg.softuni.staticData.SessionData;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputReader implements Reader {

    private static final String END_COMMAND = "quit";

    private Interpreter commandInterpreter;

    public InputReader(Interpreter commandInterpreter) {
        this.commandInterpreter = commandInterpreter;
    }

    public void readCommands() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                OutputWriter.writeMessage(String.format("%s>", SessionData.currentPath));
                String input = reader.readLine().trim();
                if (input.equals(END_COMMAND)) {
                    break;
                }

                this.commandInterpreter.interpretCommand(input);
            }

            for (Thread thread : SessionData.threadPool) {
                thread.join();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
