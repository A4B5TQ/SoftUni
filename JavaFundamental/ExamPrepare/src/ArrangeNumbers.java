import java.util.*;

public class ArrangeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nums = sc.nextLine().split(", ");

        String[] convertedToText = getConvertToText(nums);

        Arrays.sort(convertedToText);

        nums = getConvertToNumbers(convertedToText);

        System.out.println(String.join(", ",nums));
    }

    private static String[] getConvertToNumbers(String[] textNums) {
        List<String> output = new ArrayList<>();
        for (String s : textNums) {
            String out = "";
            for (String s1 : s.split("-")) {
                switch (s1) {
                    case "zero":
                        out += "0";
                        break;
                    case "one":
                        out += "1";
                        break;
                    case "two":
                        out += "2";
                        break;
                    case "three":
                        out += "3";
                        break;
                    case "four":
                        out += "4";
                        break;
                    case "five":
                        out += "5";
                        break;
                    case "six":
                        out += "6";
                        break;
                    case "seven":
                        out += "7";
                        break;
                    case "eight":
                        out += "8";
                        break;
                    case "nine":
                        out += "9";
                        break;
                }
            }
            output.add(out);
        }
        return output.stream().toArray(String[]::new);
    }

    private static String[] getConvertToText(String[] numbers) {
        List<String> output = new ArrayList<>();

        for (String num : numbers) {
            List<String> tmp = new ArrayList<>();
            for (Character ch : num.toCharArray()) {
                String out = "";
                switch (ch) {
                    case '0':
                        out = "zero";
                        break;
                    case '1':
                        out = "one";
                        break;
                    case '2':
                        out = "two";
                        break;
                    case '3':
                        out = "three";
                        break;
                    case '4':
                        out = "four";
                        break;
                    case '5':
                        out = "five";
                        break;
                    case '6':
                        out = "six";
                        break;
                    case '7':
                        out = "seven";
                        break;
                    case '8':
                        out = "eight";
                        break;
                    case '9':
                        out = "nine";
                        break;
                }
                tmp.add(out);
            }
            output.add(String.join("-", tmp));
        }

        return output.stream().toArray(String[]::new);
    }
}
