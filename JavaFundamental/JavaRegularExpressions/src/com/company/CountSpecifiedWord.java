package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSpecifiedWord {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String inputText = sc.nextLine();
        String specWord = sc.nextLine();

        Pattern pat = Pattern.compile("\\b" + specWord + "(?=[[:punct:]]?)\\b", Pattern.CASE_INSENSITIVE);
        Matcher match = pat.matcher(inputText);

        int counter = 0;

        while (match.find()) {
            counter++;
        }
        System.out.println(counter);
    }
}
