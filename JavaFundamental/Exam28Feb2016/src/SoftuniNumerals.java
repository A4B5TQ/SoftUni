import java.math.BigInteger;
import java.util.Scanner;

public class SoftuniNumerals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String numeralString = sc.nextLine();

        //Replace using String.ReplaceAll

        numeralString = numeralString.replaceAll("aba","1");
        numeralString = numeralString.replaceAll("bcc","2");
        numeralString = numeralString.replaceAll("cdc","4");
        numeralString = numeralString.replaceAll("aa","0");
        numeralString = numeralString.replaceAll("cc","3");

        StringBuilder sb = new StringBuilder();
        sb.append(numeralString);

        //Replace using StringBuilder - See Method Below / "replaceString" /

        /*replaceString(sb,"aba","1");
        replaceString(sb,"bcc","2");
        replaceString(sb,"cdc","4");
        replaceString(sb,"aa","0");
        replaceString(sb,"cc","3");*/

        BigInteger numberBaseFive = new BigInteger(sb.toString(), 5);
        System.out.println(numberBaseFive.toString(10));

    }
    public static void replaceString(StringBuilder sb, String toReplace,String replacement) {
        int index = -1;
        while ((index = sb.lastIndexOf(toReplace)) != -1) {
            sb.replace(index, index + toReplace.length(), replacement);
        }
    }
}

