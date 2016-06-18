package IO;

import StaticData.SessionData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputReader {

    private static final String END_COMMAND = "quit";

//    public static void readCommands() {
//
//        OutputWriter.writeMessage(String.format("%s>", SessionData.currentPath));
//
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine().trim();
//
//        while (!endCommand.equals(input)) {
//            CommandInterpreter.interpretCommand(input);
//            OutputWriter.writeMessage(String.format("%s>", SessionData.currentPath));
//
//            input = scanner.nextLine().trim();
//        }
//    }

    public static void readCommands() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                OutputWriter.writeMessage(String.format("%s>", SessionData.currentPath));
                String input = reader.readLine().trim();
                if (input.equals(END_COMMAND)) {
                    break;
                }

                CommandInterpreter.interpretCommand(input);
            }

            Thread[] threads = new Thread[Thread.activeCount()];
            Thread.enumerate(threads);
            for (Thread thread : threads) {
                try {
                    if (!thread.getName().equals("main") && !thread.isDaemon()) {
                        thread.join();
                    }
                } catch (InterruptedException e) {
                    OutputWriter.displayException(e.getMessage());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
