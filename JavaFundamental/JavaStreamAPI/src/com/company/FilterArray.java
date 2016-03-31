package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class FilterArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] stringArr = sc.nextLine().split("\\s+");

        Arrays.stream(stringArr).filter(e -> e.length() > 3).forEach(e -> System.out.printf("%s ", e));
    }
}
