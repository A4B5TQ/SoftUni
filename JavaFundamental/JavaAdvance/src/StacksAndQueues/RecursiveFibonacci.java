package StacksAndQueues;

import java.math.BigInteger;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static BigInteger[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fibNumber = sc.nextInt();

        arr = new BigInteger[fibNumber + 1];
        arr[0] = BigInteger.ONE;
        arr[1] = BigInteger.ONE;
        System.out.println(fibonacci(fibNumber));
    }

    public static BigInteger fibonacci(int n) {
        BigInteger fibValue = BigInteger.ONE;

        if (n == 1) {
            return BigInteger.ONE;
        } else if (arr[n] != null) {
            return arr[n];
        } else {
            fibValue = new BigInteger((fibonacci(n - 1).add(fibonacci(n - 2))).toString());
            arr[n] = fibValue;
            return fibValue;
        }
    }
}
