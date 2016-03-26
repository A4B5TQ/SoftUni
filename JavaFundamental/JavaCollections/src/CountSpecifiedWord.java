import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSpecifiedWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String words = sc.nextLine();
        String wordToSearch = sc.nextLine();
        Pattern pat = Pattern.compile("\\b" + wordToSearch + "\\b", Pattern.CASE_INSENSITIVE);
        Matcher match = pat.matcher(words);
        int count = 0;
        while (match.find()) {
            count++;
        }
        System.out.println(count);
    }
}
