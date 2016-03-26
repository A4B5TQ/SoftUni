import java.util.*;
import java.util.stream.Collectors;

public class CardsFrequencies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> cards = Arrays.stream(sc.nextLine().split("\\W+")).collect(Collectors.toList());

        LinkedHashMap<String,Double> cardFreq = new LinkedHashMap<>();

        for (String card : cards) {
            if (!cardFreq.containsKey(card)){
                cardFreq.put(card,1D);
            }else{
                cardFreq.put(card, cardFreq.get(card) + 1);
            }
        }

        for (Map.Entry<String, Double> uniqieCards : cardFreq.entrySet()) {
            System.out.printf("%s -> %.2f%%\n",uniqieCards.getKey(),(uniqieCards.getValue() / cards.size()) * 100);
        }
    }
}
