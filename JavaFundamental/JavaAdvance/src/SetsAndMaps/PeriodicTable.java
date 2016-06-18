package setsAndMaps;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        TreeSet<String> elements = new TreeSet<>();

        while (n > 0){
            String[] el = sc.nextLine().split("\\s+");
            elements.addAll(Arrays.asList(el));
            n--;
        }

        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
