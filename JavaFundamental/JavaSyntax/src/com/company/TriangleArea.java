package com.company;

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        
        Integer[] cordA = readNextInts();
        Integer[] cordB = readNextInts();
        Integer[] cordC = readNextInts();

        double area = cordA[0] * (cordB[1] - cordC[1]);
        area += cordB[0] * (cordC[1] - cordA[1]);
        area += cordC[0] * (cordA[1] - cordB[1]);

        System.out.printf("%d", (int) Math.abs(area / 2));
    }

    public static Integer[] readNextInts() {

        Scanner s = new Scanner(System.in);

        String[] nums = s.nextLine().split("\\s+");

        Integer[] numbers = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numbers[i] = Integer.parseInt(nums[i]);
        }
        return numbers;
    }
}
