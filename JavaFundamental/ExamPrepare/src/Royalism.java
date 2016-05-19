import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Royalism {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] inputNames = sc.nextLine().split("\\s+");

        List<String> royalist = new ArrayList<>();
        List<String> nonRoyalist = new ArrayList<>();

        for (String name : inputNames) {
            long asciiSum = 0;

            for (char symbol : name.toCharArray()) {
                asciiSum += symbol;
                if (asciiSum > 26) {
                    while (asciiSum > 26) {
                        asciiSum -= 26;
                    }
                }
            }
            if (asciiSum == 18) {
                royalist.add(name);
            } else {
                nonRoyalist.add(name);
            }
        }

        if (royalist.size() >= nonRoyalist.size()) {
            System.out.println("Royalists - " + royalist.size());
            royalist.stream().forEach(System.out::println);
            System.out.println("All hail Royal!");
        } else {
            nonRoyalist.stream().forEach(System.out::println);
            System.out.println("Royalism, Declined!");
        }
    }
}
