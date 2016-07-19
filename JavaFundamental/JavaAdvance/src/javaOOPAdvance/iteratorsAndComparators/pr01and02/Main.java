package javaOOPAdvance.iteratorsAndComparators.pr01and02;

import javaOOPAdvance.iteratorsAndComparators.pr01and02.commandInterpreter.CommandInterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CommandInterpreter commandInterpreter = new CommandInterpreter();

        String line;
        while (!(line = reader.readLine()).equals("END")) {
           commandInterpreter.execute(line);
        }
    }
}
