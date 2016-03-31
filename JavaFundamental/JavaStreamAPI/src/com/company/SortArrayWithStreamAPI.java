package com.company;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Arrays;
import java.util.Scanner;

public class SortArrayWithStreamAPI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] intArr = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        String command = sc.nextLine().toLowerCase();

        switch (command) {
            case "ascending":
                Arrays.stream(intArr).sorted((e1, e2) -> e1.compareTo(e2)).forEach(e -> System.out.printf("%d ", e));
                break;
            case "descending":
                Arrays.stream(intArr).sorted((e1, e2) -> e2.compareTo(e1)).forEach(e -> System.out.printf("%d ", e));
                break;
            default:
                break;
        }
    }
}
