package javaOOPBasics.methods.fibonacciNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Fibonacci {
    private List<Long> fibonacciNums;

    public Fibonacci(Integer n) {
        this.fibonacciNums = new ArrayList<>(n + 1);
        this.fibonacciNums.add(0L);
        this.fibonacciNums.add(1L);
        this.fibonacciNums.add(1L);
        fibonacci(n);
    }

    private Long fibonacci(int n) {
        Long fibValue = 1L;

        if (n == 2) {
            return 1L;
        } else if (n < this.fibonacciNums.size()) {
            return fibonacciNums.get(n);
        } else {
            fibValue = fibonacci(n - 1) + fibonacci(n - 2);
            fibonacciNums.add(fibValue);
            return fibValue;
        }
    }

    public List<Long> getNumbersInRange(Integer start, Integer end) {
        return this.fibonacciNums.subList(start, end);
    }
}

public class FibonacciNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int start = Integer.parseInt(sc.readLine());
        int end = Integer.parseInt(sc.readLine());

        Fibonacci fibonacci = new Fibonacci(end);

        System.out.println(String.join(", ", fibonacci.getNumbersInRange(start, end)
                .stream().map(e -> String.valueOf(e)).toArray(String[]::new)));
    }
}
