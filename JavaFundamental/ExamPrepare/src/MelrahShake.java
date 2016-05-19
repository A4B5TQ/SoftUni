import java.util.Scanner;

public class MelrahShake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String pattern = sc.nextLine();
        while (true){
            int firstIndex = input.indexOf(pattern);
            int lastIndex = input.lastIndexOf(pattern);
            if (firstIndex > -1 && lastIndex > -1 && pattern.length() > 0){
                StringBuilder sb = new StringBuilder(input);
                sb.replace(firstIndex,pattern.length() + firstIndex,"");
                sb.replace(lastIndex - pattern.length(),pattern.length() + (lastIndex - pattern.length()),"");
                input = sb.toString();
                System.out.println("Shaked it.");
                sb = new StringBuilder(pattern);
                if (pattern.length() > 0){
                    sb.deleteCharAt(pattern.length() / 2);
                    pattern = sb.toString();
                }
            } else {
                System.out.println("No shake.");
                System.out.println(input);
                break;
            }
        }
    }
}
