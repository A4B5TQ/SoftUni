import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicMarkUpLanguage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Pattern pat = Pattern.compile("\"(?<tvaDetTrqqSeMachne>[\\s]*?([^\"]+)[\\s]*?)\"");

        LinkedList<String> output = new LinkedList<>();

        while (!input.contains("stop")) {
            //input = input.replaceAll("\\s+"," ");
            Matcher match = pat.matcher(input);
            StringBuilder sb = new StringBuilder();
            if (input.contains("inverse")) {
                if (match.find()) {
                    for (Character ch : match.group("tvaDetTrqqSeMachne").toCharArray()) {
                        if (Character.isUpperCase(ch)) {
                            sb.append(Character.toLowerCase(ch));
                        } else {
                            sb.append(Character.toUpperCase(ch));
                        }
                    }
                    output.add(sb.toString());
                }

            } else if (input.contains("reverse")) {
                if (match.find()) {
                    sb.append(match.group("tvaDetTrqqSeMachne"));
                    output.add(sb.reverse().toString());
                }
            } else if (input.contains("repeat")) {
                int count = 0;
                if (match.find()){

                count = Integer.parseInt(match.group("tvaDetTrqqSeMachne").trim());
                }
                if (match.find()){
                    for (int i = 0; i < count; i++) {
                        output.add(match.group("tvaDetTrqqSeMachne"));
                    }
                }
            }
            input = sc.nextLine();
        }
        final int[] count = {1};
        output.stream().forEach(e -> {
            System.out.println(count[0] + ". " + e);
            count[0]++;
        });
    }
}
