import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextTransformer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String text = sc.nextLine();
        while(!text.equals("burp")){
            sb.append(text);
            text = sc.nextLine();
        }
        text = sb.toString();
        text = text.replaceAll("\\s+"," ");
        Pattern pat = Pattern.compile("(?<weight>[$%&'])(?<string>[^$%&']+)\\1");
        Matcher match = pat.matcher(text);
        while (match.find()){
            switch (match.group("weight").charAt(0)){
                case '$': String txt = getWord(match.group("string"),1);
                    System.out.printf("%s ",txt);
                    break;
                case '%': txt = getWord(match.group("string"),2);
                    System.out.printf("%s ",txt);
                    break;
                case '&': txt = getWord(match.group("string"),3);
                    System.out.printf("%s ",txt);
                    break;
                case '\'': txt = getWord(match.group("string"),4);
                    System.out.printf("%s ",txt);
                    break;
            }
        }
    }
    private static String getWord(String match,int weight){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < match.length(); i++) {
            if (i % 2 == 0){
                sb.append((char) (match.charAt(i) + weight));
            } else {
                sb.append((char) (match.charAt(i) - weight));
            }
        }
        return sb.toString();
    }
}
