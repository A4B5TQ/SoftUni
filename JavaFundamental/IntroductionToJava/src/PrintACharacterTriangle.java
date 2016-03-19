import java.util.Scanner;

public class PrintACharacterTriangle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < num; i++) {

            for (char j = 'a'; j <= 'a' + i; j++) {

                System.out.print(j + " ");
            }

            System.out.println();
        }

        for (int i = num - 1; i > 0 ; i--) {

            for (char j = 'a'; j < 'a' + i; j++) {

                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}
