import java.util.*;
import java.util.stream.Collectors;

public class MostFrequentWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> arrOfWords = Arrays.stream(sc.nextLine().toLowerCase().split("\\W+")).collect(Collectors.toList());

        TreeMap<String, Integer> mostFreqWord = new TreeMap<>();

        for (String str : arrOfWords) {
            if (!mostFreqWord.containsKey(str)) {
                mostFreqWord.put(str, 1);
            } else {
                mostFreqWord.put(str, mostFreqWord.get(str) + 1);
            }
        }

        List<Integer> valueOfWords = new ArrayList<>();
        valueOfWords.addAll(mostFreqWord.values());

        for (Map.Entry entry : mostFreqWord.entrySet()) {
            if (Collections.max(valueOfWords).equals(entry.getValue())) {
                System.out.println(entry.getKey() + " -> " + Collections.max(valueOfWords) + " times");
            }
        }
    }
}
