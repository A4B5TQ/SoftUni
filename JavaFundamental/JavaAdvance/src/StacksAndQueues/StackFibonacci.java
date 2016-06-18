package stacksAndQueues;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class StackFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Stack<BigInteger> fib = new Stack<>();

        fib.push(BigInteger.ONE);
        fib.push(BigInteger.ONE);

        for (int i = 1; i < n; i++) {

            BigInteger tmp = fib.pop();
            BigInteger num = fib.peek().add(tmp);
            fib.push(tmp);
            fib.push(num);
        }

        System.out.println(fib.peek());
    }
}
