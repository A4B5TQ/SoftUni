package javaAdvance.setsAndMaps;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Map<String,Set<String>> personAndHands = new LinkedHashMap<>();

        while (!input.equals("JOKER")){
            String[] datas = input.split(":");
            if (!personAndHands.containsKey(datas[0])){
                personAndHands.put(datas[0],new HashSet<>());
            }

            Set<String> tmp = personAndHands.get(datas[0]);
            tmp.addAll(Arrays.asList(datas[1].trim().split("[\\s,]+")));
            personAndHands.put(datas[0],tmp);
            input = sc.nextLine();
        }

        for (Map.Entry<String, Set<String>> hands : personAndHands.entrySet()) {
            
            long sum = 0;
            Set<String> cards = hands.getValue();

            for (String card : cards) {
                int suitSize = 0;
                int countSize = 0;
                switch (card.substring(card.length() - 1)){
                    case "S": suitSize = 4; break;
                    case "H": suitSize = 3; break;
                    case "D": suitSize = 2; break;
                    case "C": suitSize = 1; break;
                }
                switch (card.substring(0,card.length() - 1)){
                    case "A": countSize = 14; break;
                    case "K": countSize = 13; break;
                    case "Q": countSize = 12; break;
                    case "J": countSize = 11; break;
                    default: countSize = Integer.parseInt(card.substring(0,card.length() - 1));
                        break;
                }
                sum += suitSize * countSize;
            }

            System.out.printf("%s: %d%n",hands.getKey(),sum);
        }
    }
}
