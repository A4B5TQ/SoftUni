import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountAllWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String words = sc.nextLine();
        Pattern pat = Pattern.compile("[\\p{L}]+");
        Matcher match = pat.matcher(words);

        long counter = 0;
        while (match.find()) {
            counter++;
        }
        System.out.println(counter);
    }
}
