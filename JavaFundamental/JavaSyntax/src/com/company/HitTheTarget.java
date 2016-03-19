package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HitTheTarget {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();
        List<String> added = new ArrayList<>();
        List<String> substracted = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            for (int j = 20; j > 0; j--) {
                if (i + j == target) {
                    added.add(String.format("%d + %d = %d", i, j, target));
                } else if (j - i == target) {
                    substracted.add(String.format("%d - %d = %d", j, i, target));
                }
            }
        }

        for (String s : added) {
            System.out.println(s);
        }
        for (String s : substracted) {
            System.out.println(s);
        }
    }
}
