import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ExtractAllUniqueWords {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> words = Arrays.stream(sc.nextLine().toLowerCase().split("\\W+")).collect(Collectors.toList());

        TreeSet<String> uniqueWords = words.stream().collect(Collectors.toCollection(TreeSet::new));

        uniqueWords.forEach(e -> System.out.printf("%s ",e));

    }
}
