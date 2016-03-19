import java.util.Scanner;

public class GhettoNumeralSystem {

    public static void main(String[] args) {

        String[] wordArr = new String[]{
                "Gee","Bro",
                "Zuz","Ma",
                "Duh","Yo",
                "Dis","Hood",
                "Jam","Mack"
        };

        Scanner sc = new Scanner(System.in);

        String num = sc.nextLine();

        String output = "";

        for (int i = 0; i < num.length(); i++) {

            output += wordArr[Character.getNumericValue(num.charAt(i))];
        }

        System.out.println(output);
    }
}
