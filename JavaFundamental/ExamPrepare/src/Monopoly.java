import java.util.Arrays;
import java.util.Scanner;

public class Monopoly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] dimm = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        //int[] dimm = Stream.of(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        char[][] monopolyField = new char [dimm[0]][dimm[1]];


    }
}
