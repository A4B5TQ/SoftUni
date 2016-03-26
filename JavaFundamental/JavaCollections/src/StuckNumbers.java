import java.util.Arrays;
import java.util.Scanner;

public class StuckNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        sc.nextLine();
        Integer[] sequence = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        count = 0;
        for (int num1 = 0; num1 < sequence.length; num1++) {
            for (int num2 = 0; num2 < sequence.length; num2++) {
                for (int num3 = 0; num3 < sequence.length; num3++) {
                    for (int num4 = 0; num4 < sequence.length; num4++) {
                        int a = sequence[num1];
                        int b = sequence[num2];
                        int c = sequence[num3];
                        int d = sequence[num4];
                        if (a != b && a != c & a != d && b != c && b != d && c != d) {
                            String first = "" + a + b;
                            String second = "" + c + d;
                            if (first.equals(second)) {
                                System.out.printf("%d|%d==%d|%d\n", a, b, c, d);
                                count++;
                            }
                        }
                    }
                }
            }
        }

        if (count == 0) {
            System.out.println("No");
        }
    }
}
