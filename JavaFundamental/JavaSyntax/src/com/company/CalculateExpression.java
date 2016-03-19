package com.company;

import java.util.Locale;
import java.util.Scanner;

public class CalculateExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ROOT);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double F1 = Math.pow(((Math.pow(a,2) + Math.pow(b,2)) / (Math.pow(a,2) - Math.pow(b,2))), ((a + b + c) / Math.sqrt(c)));
        double F2 = Math.pow((Math.pow(a,2) + Math.pow(b,2) - Math.pow(c,3)),(a - b));

        double numsAvarage = calcAvarage(a,b,c);
        double formAvarage = calcAvarage(F1,F2);

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f",F1,F2,Math.abs(numsAvarage - formAvarage));

    }

    private static double calcAvarage(double a, double b) {
        return (a + b) / 2;
    }

    private static double calcAvarage(double a, double b, double c) {
        return (a + b + c) / 3;
    }

}
