import java.math.BigInteger;
import java.util.Scanner;

public class CalculateNFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fact = sc.nextInt();

        BigInteger Factorial = getCalcFactorial(fact);
        System.out.println(Factorial.toString());
    }

    private static BigInteger getCalcFactorial(int fact) {
        BigInteger num = new BigInteger(String.valueOf(fact));

        if (num.equals(BigInteger.ONE) || num.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }

        return num.multiply(getCalcFactorial(fact - 1));
    }
}
