package javaOOPAdvance.generics.pr07and08and09;

import javaOOPAdvance.generics.pr07and08and09.models.MyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        MyList<String> myList = new MyList<>();

        String[] commandTokens = reader.readLine().split("\\s+");

        String command = commandTokens[0];

        while (!command.equals("END")) {
            switch (command) {
                case "Add":
                    myList.add(commandTokens[1]);
                    break;
                case "Remove":
                    myList.remove(Integer.valueOf(commandTokens[1]));
                    break;
                case "Contains":
                    System.out.println(myList.contains(commandTokens[1]));
                    break;
                case "Swap":
                    int firstIndex = Integer.valueOf(commandTokens[1]);
                    int secondIndex = Integer.valueOf(commandTokens[2]);
                    myList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    System.out.println(myList.countGreaterThan(commandTokens[1]));
                    break;
                case "Max":
                    System.out.println(myList.getMax());
                    break;
                case "Min":
                    System.out.println(myList.getMin());
                    break;
                case "Sort":
                    myList.sort();
                    break;
                case "Print":
                    myList.forEach(System.out::println);
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }

            commandTokens = reader.readLine().split("\\s+");
            command = commandTokens[0];
        }

    }
}
