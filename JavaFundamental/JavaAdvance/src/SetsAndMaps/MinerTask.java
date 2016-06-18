package setsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, Integer> res = new LinkedHashMap<>();

        String input = sc.nextLine();
        int lineCounter = 0;
        String lastKey = "";

        while (!input.equals("stop")){
            if (lineCounter % 2 == 0){
                if (!res.containsKey(input)){
                    res.put(input,0);
                }
                lastKey = input;
            } else {
                int num = res.get(lastKey) + Integer.parseInt(input);
                res.put(lastKey,num);
            }
            input = sc.nextLine();
            lineCounter++;
        }

        for (Map.Entry<String, Integer> resources : res.entrySet()) {
            System.out.printf("%s -> %d%n",resources.getKey(),resources.getValue());
        }
    }
}
