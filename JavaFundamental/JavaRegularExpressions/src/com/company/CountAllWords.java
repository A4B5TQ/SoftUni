package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountAllWords {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        Pattern pat = Pattern.compile("\\p{L}+"); // Works with all characters include Unicode
        Matcher mactch = pat.matcher(text);
        long counter = 0L;

        while (mactch.find()) {
            counter++;
        }
        System.out.println(counter);
    }
}
