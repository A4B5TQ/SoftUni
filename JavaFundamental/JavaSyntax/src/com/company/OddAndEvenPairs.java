package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OddAndEvenPairs {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        if (numbers.size() % 2 == 0) {
            for (int i = 0; i < numbers.size() - 1; i += 2) {
                if (areDifferent(numbers.get(i), numbers.get(i + 1))) {
                    System.out.printf("%d, %d -> different\n", numbers.get(i), numbers.get(i + 1));
                } else if (isEvenPair(numbers.get(i), numbers.get(i + 1))) {
                    System.out.printf("%d, %d -> both are even\n", numbers.get(i), numbers.get(i + 1));
                } else {
                    System.out.printf("%d, %d -> both are odd\n", numbers.get(i), numbers.get(i + 1));
                }
            }
        } else {
            System.out.println("Invalid length");
        }
    }
    private static boolean isEvenPair(int a, int b) {
        return a % 2 == 0 && b % 2 == 0;
    }
    private static boolean areDifferent(int a, int b) {
        return (a % 2 == 0 && b % 2 != 0) || (a % 2 != 0 && b % 2 == 0);
    }
}
