package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartsAndEndsWithCapitalLetter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        Pattern pat = Pattern.compile("\\b\\p{Lu}\\p{L}*\\p{Lu}\\b");
        Matcher match = pat.matcher(text);
        while (match.find()) {
            System.out.printf("%s ", match.group());
        }
    }
}
