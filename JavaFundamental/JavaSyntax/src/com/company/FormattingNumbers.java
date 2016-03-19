package com.company;

import java.util.Locale;
import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Locale.setDefault(Locale.ROOT);

        int a = sc.nextInt();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        System.out.printf("|%1$-10x|%4$10s|%2$10.2f|%3$-10.3f",a,b,c,toBinaryPadLeft(a));
    }
    static String toBinaryPadLeft(int a){

        StringBuilder sb = new StringBuilder();
        String binaryNumber = Integer.toBinaryString(a);
        for (int i = 0; i < 10 - binaryNumber.length(); i++) {
             sb.append(0);
        }
        sb.append(binaryNumber);
        return sb.toString();
    }
}
