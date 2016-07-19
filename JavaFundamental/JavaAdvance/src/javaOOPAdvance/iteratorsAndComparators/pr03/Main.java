package javaOOPAdvance.iteratorsAndComparators.pr03;

import javaOOPAdvance.iteratorsAndComparators.pr03.stack.CustomStack;
import javaOOPAdvance.iteratorsAndComparators.pr03.stack.CustomStackImpl;

import javax.naming.OperationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomStack stack = new CustomStackImpl();

        String line = reader.readLine();
        String[] inputTokens = line.split("[\\s,]+");
        String command = inputTokens[0];

        while (!command.equalsIgnoreCase("end")) {
            switch (command) {
                case "Push":
                    final int[] counter = {0};
                    Integer[] integers = Arrays.stream(inputTokens).filter(e -> {
                        try {
                            Integer.parseInt(e);
                        } catch (NumberFormatException ex) {
                            return false;
                        }

                        return true;
                    })
                            .map(Integer::valueOf)
                            .toArray(Integer[]::new);

                    for (Integer integer : integers) {
                        stack.push(integer);
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (OperationNotSupportedException exception) {
                        System.out.printf("No elements%n");
                    }
                    break;
            }

            line = reader.readLine();
            inputTokens = line.split("[\\s,]+");
            command = inputTokens[0];
        }

        stack.forEach(System.out::println);


        stack.forEach(System.out::println);
    }
}
