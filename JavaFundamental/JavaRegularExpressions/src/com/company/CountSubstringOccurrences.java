package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String substring = sc.nextLine();

        Pattern pat = Pattern.compile(substring, Pattern.CASE_INSENSITIVE);
        Matcher match = pat.matcher(input);
        int counter = 0;
        int matchposition = 0;
        while (match.find(matchposition)) {
            counter++;
            matchposition = match.start() + 1;
        }
        System.out.println(counter);
    }
}
