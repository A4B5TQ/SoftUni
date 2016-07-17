package javaAdvance.setsAndMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<Character,Integer> chars = new TreeMap<>();

        char[] arr = sc.nextLine().toCharArray();

        for (char c : arr) {
            if (!chars.containsKey(c)){
                chars.put(c,0);
            }

            int n = chars.get(c);
            n++;
            chars.put(c,n);
        }

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            System.out.printf("%c: %d time/s%n",entry.getKey(),entry.getValue());
        }
    }
}
