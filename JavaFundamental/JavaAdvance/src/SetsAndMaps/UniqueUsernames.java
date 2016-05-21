package SetsAndMaps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        sc.nextLine();

        Set<String> input = new HashSet<>();

        while (count > 0){
            String a = sc.nextLine();
            if (!input.contains(a)){
                System.out.println(a);
                input.add(a);
            }
            count--;
        }
    }
}
