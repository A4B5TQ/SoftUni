package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split("\\s+");

        LinkedHashSet<Character> firstWord = new LinkedHashSet();
        for (char c : words[0].toCharArray()) {
            firstWord.add(c);
        }

        LinkedHashSet<Character> secondWord = new LinkedHashSet();

        for (char c : words[1].toCharArray()) {
            secondWord.add(c);
        }

        if (firstWord.size() == secondWord.size()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
