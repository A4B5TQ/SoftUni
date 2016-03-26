import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arrNums = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        int startIndex = 0;
        int length = 1;
        int currLength = 1;
        for (int i = 0; i < arrNums.length - 1; i++) {

            System.out.printf("%d", arrNums[i]);
            if (arrNums[i] < arrNums[i + 1]) {
                currLength++;
                System.out.printf(" ");
            } else {
                currLength = 1;
                System.out.println();
            }

            if (currLength > length){
                length = currLength;
                startIndex = i - length + 2;
            }
        }
        System.out.println(arrNums[arrNums.length-1]);

        System.out.printf("Longest: ");
        for (int i = 0; i < length; i++) {
            System.out.printf("%d ", arrNums[startIndex++]);
        }
    }
}
