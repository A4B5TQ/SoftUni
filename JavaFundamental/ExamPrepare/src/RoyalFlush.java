import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoyalFlush {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();

        StringBuilder sb = new StringBuilder(count);

        while (count > 0) {
            sb.append(sc.nextLine());
            count--;
        }
        List<String> spades = new ArrayList<>();
        List<String> hearts = new ArrayList<>();
        List<String> diamonds = new ArrayList<>();
        List<String> clubs = new ArrayList<>();


    }
}
