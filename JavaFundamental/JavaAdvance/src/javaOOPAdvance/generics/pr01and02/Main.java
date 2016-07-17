package javaOOPAdvance.generics.pr01and02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            Integer input = Integer.valueOf(reader.readLine());
            Box<Integer> box = new Box<>(input);
            System.out.println(box);
        }
    }
}
