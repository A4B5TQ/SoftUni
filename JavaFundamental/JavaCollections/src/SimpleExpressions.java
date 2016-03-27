import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SimpleExpressions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] expressions = sc.nextLine().split("\\s+");
        StringBuilder stb = new StringBuilder();
        for (String s : expressions) {
            stb.append(s);
        }

        String newExpression = stb.toString();

        Pattern pat = Pattern.compile("(?<=\\-)\\d*\\.?\\d*");
        Matcher match = pat.matcher(newExpression);

        List<String> toSubtract = new ArrayList<>();

        while (match.find()) {
            toSubtract.add(match.group());
        }

        List<String> toAdd = Arrays.stream(newExpression.split("((?<=\\-)\\d*\\.?\\d*|-|\\+)")).collect(Collectors.toList());
        toAdd.removeAll(Arrays.asList(""));

        BigDecimal sum = new BigDecimal("0");


        for (String s : toAdd) {
            sum = sum.add(new BigDecimal(s));
        }
        for (String s : toSubtract) {
            sum = sum.subtract(new BigDecimal(s));
        }

        System.out.println((sum = sum.setScale(7,BigDecimal.ROUND_HALF_UP)).toString());
    }
}
