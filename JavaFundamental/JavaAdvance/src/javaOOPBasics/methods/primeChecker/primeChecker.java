package javaOOPBasics.methods.primeChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Number {
    private Integer number;
    private Boolean isPrime;

    public Number(Integer number) {
        this.number = number;
        this.isPrime = isPrime(number);
    }

    private boolean isPrime(Integer number) {

        if (number == 0 || number == 1 || number == 2) return this.isPrime = true;

        if (number % 2 == 0) return this.isPrime = false;

        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0)
                return this.isPrime = false;
        }
        return this.isPrime = true;
    }

    public void primeCheck() {
        int p = this.number + 1;
        int y = 0;
        for (p = this.number + 1; p > 0; p++) {
            y = 0;
            for (int i = 2; i <= p / 2; i++) {
                if (p % i == 0) {
                    y++;
                    break;
                }
            }
            if (y == 0) {
                break;
            }
        }
        if (y == 0) {
            System.out.println(p + ", " + this.isPrime);
        }
    }
}

public class primeChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(sc.readLine());

        Number number = new Number(num);

        number.primeCheck();
    }
}
