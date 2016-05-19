package Judge;

import java.util.Arrays;
import java.util.Scanner;

public class Help {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //input: 1 2 3 4 5;

        String[] input = sc.nextLine().split("\\s+");
        //output [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(input));
    }
}
