package SetsAndMaps;

import java.util.HashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc .nextInt();
        int m = sc.nextInt();

        HashSet<Integer> firsSet = new HashSet<>(n);
        HashSet<Integer> seccondSet = new HashSet<>(m);

        for (int i = 0; i < n; i++) {
            firsSet.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            seccondSet.add(sc.nextInt());
        }

        if (n > m) {
            for (Integer num : seccondSet) {
                if (firsSet.contains(num)){
                    System.out.print(num + " ");
                }
            }
        } else {
            for (Integer num : firsSet) {
                if (seccondSet.contains(num)){
                    System.out.print(num + " ");
                }
            }
        }
    }
}
