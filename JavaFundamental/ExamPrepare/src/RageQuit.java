import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RageQuit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Pattern pat = Pattern.compile("(?<symbols>\\D+)(?<num>\\d*)");
        Matcher match = pat.matcher(input);

        StringBuilder output = new StringBuilder();

        while (match.find()){
            int count = Integer.parseInt(match.group("num"));
            String string = match.group("symbols");

            for (int i = 0; i < count; i++) {
                output.append(string.toUpperCase());
            }
        }
        Set<Character> uniq = output.toString().chars().mapToObj(e -> (char)e).collect(Collectors.toSet());
        System.out.println("Unique symbols used: " + uniq.size());
        System.out.println(output.toString());
    }
}
