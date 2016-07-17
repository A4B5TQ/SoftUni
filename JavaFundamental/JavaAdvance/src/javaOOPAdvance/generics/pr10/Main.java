package javaOOPAdvance.generics.pr10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstData = reader.readLine().split("\\s+",2);
        System.out.println(firstData.length);
    }
}
