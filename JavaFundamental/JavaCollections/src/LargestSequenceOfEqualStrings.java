import java.util.Scanner;

public class LargestSequenceOfEqualStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int startIndex = 0;
        int longestSequence = 1;
        int currentLength = 1;
        String[] sequence = sc.nextLine().split("\\s+");
        for (int i = 1; i <= sequence.length - 1; i++) {

            if (sequence[i].equals(sequence[i - 1])) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            if (currentLength > longestSequence) {
                longestSequence = currentLength;
                startIndex = i - longestSequence + 1;
            }
        }

        for (int i = 0; i < longestSequence; i++) {
            System.out.printf("%s ", sequence[startIndex]);

        }
    }
}
