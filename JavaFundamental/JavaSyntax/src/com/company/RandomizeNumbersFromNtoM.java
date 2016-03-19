package com.company;

import java.util.*;

public class RandomizeNumbersFromNtoM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer> numArray = new ArrayList<>();

        for (int i = Math.min(N, M); i <= Math.max(N, M); i++) {
            numArray.add(i);
        }
        Collections.shuffle(numArray);
        System.out.println(numArray);
    }
}
