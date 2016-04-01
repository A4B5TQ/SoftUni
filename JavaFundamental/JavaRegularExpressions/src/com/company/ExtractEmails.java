package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        Pattern pat = Pattern.compile("((?<!-)([A-Za-z0-9]\\.?\\-?\\_?)+@([A-Za-z]+\\-?\\.?)+)\\b");
        Matcher match = pat.matcher(text);

        while (match.find()) {
            System.out.println(match.group());
        }
    }
}
