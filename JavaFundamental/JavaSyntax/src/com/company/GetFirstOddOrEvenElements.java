package com.company;

import java.util.*;

public class GetFirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        String[] input = sc.nextLine().split("\\s+");

        int count = Integer.parseInt(input[1]);
        String oddOrEven = input[2];

        List<Integer> outputNumbers = new ArrayList<>();

        outputNumbers.addAll(getFirstOddOrEven(numbers, count, oddOrEven));

        for (Integer outputNumber : outputNumbers) {
            System.out.printf("%d ", outputNumber);
        }
    }

    private static Collection<? extends Integer> getFirstOddOrEven(Integer[] numbers, int count, String oddOrEven) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        int oddCount = 0;
        int evenCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                odd.add(numbers[i]);
                oddCount++;
            } else {
                even.add(numbers[i]);
                evenCount++;
            }
        }
        if (oddOrEven.toLowerCase().equals("odd")) {
            return odd.subList(0, Math.min(oddCount,count));
        } else {
            return even.subList(0, Math.min(evenCount,count));
        }
    }
}
