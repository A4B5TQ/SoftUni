import java.util.*;
import java.util.stream.Collectors;

public class CombineListsOfLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Character> l1 = Arrays.stream(sc.nextLine().split("\\s+")).map(e -> e.charAt(0)).collect(Collectors.toList());
        List<Character> l2 = Arrays.stream(sc.nextLine().split("\\s+")).map(e -> e.charAt(0)).collect(Collectors.toList());

        List<Character> output = new ArrayList<>();
        output.addAll(l1);

        l2.stream().filter(character -> !l1.contains(character)).forEach(output::add);

        output.stream().forEach(e -> System.out.printf("%c ", e));
    }
}
