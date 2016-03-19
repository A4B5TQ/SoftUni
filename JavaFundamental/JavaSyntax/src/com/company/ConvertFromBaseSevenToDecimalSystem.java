package com.company;

import java.util.Scanner;

public class ConvertFromBaseSevenToDecimalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int baseSevenNumber = sc.nextInt();
        int decimalNumber = convertToDecimal(Integer.toString(baseSevenNumber),7);

        System.out.println(decimalNumber);
    }

    public static int convertToDecimal(String number, int fromBase) {
        int v = 0;
        int total = 0;
        int pow = 0;
        number = number.toUpperCase();
        for (int i = number.length() - 1; i >= 0; i--) {
            char c = number.charAt(i);
            if (c >= '0' && c <= '9') {
                v = Character.getNumericValue(c);

            } else if (c >= 'A' && c <= 'Z') {

                v = 10 + (c - 'A');
            }
            total += v * Math.pow(fromBase, pow);
            pow++;
        }
        return total;
    }
}
