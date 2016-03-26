import java.util.Scanner;

public class SequencesOfEqualStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split("\\s+");
        for (int i = 1; i <= arr.length - 1; i++) {
            System.out.print(arr[i - 1]);
            if (!arr[i - 1].equals(arr[i])) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
        System.out.println(arr[arr.length - 1]);
    }
}
