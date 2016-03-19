
import java.util.Scanner;

public class SumNumbersFrom1ToN {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());

        long sum = 0;

        for (int i = 1; i <= num; i++) {

            sum += i;
        }

        System.out.println(sum);
    }
}
