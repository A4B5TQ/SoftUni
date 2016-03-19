package com.company;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        int minStringLength = Math.min(str1.length(), str2.length());
        
        long charMultiply = 0;
        
        for (int i = 0; i < minStringLength; i++) {
            charMultiply += str1.charAt(i) * str2.charAt(i);
            if (str1.length()!= str2.length()){
            String longestString = str1.length() > str2.length() ? str1 : str2;
            for (int j = minStringLength; j < longestString.length(); j++) {
                charMultiply += longestString.charAt(j);
            }
            }
        }
        System.out.println(charMultiply);
    }
}
