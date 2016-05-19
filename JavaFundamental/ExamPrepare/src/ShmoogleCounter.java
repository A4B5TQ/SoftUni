import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShmoogleCounter { // 100/100
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pattern intPat = Pattern.compile("(?<=int)\\s+(?<int>[a-z][A-Za-z]*)");
        Pattern doublePat = Pattern.compile("(?<=double)\\s+(?<double>[a-z][A-Za-z]*)");

        String input = sc.nextLine();

        List<String> ints = new ArrayList<>();
        List<String> doubles = new ArrayList<>();

        while (!input.contains("//END_OF_CODE")) {
            Matcher intMatch = intPat.matcher(input);
            Matcher doubleMatch = doublePat.matcher(input);

            while (intMatch.find()) {
                ints.add(intMatch.group("int"));
            }
            while (doubleMatch.find()) {
                doubles.add(doubleMatch.group("double"));
            }
            input = sc.nextLine();
        }

        System.out.print("Doubles: ");

        if (doubles.isEmpty()) {
            System.out.println("None");
        } else {

            System.out.println(String.join(", ", doubles.stream().sorted(String::compareTo).toArray(String[]::new)));
        }

        System.out.print("Ints: ");

        if (ints.isEmpty()) {
            System.out.println("None");
        } else {

            System.out.println(String.join(", ", ints.stream().sorted(String::compareTo).toArray(String[]::new)));
        }
    }
}
