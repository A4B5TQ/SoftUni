import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> card = Arrays.stream(sc.nextLine().split("[^\\d{0,2}|J|Q|K|A]+")).collect(Collectors.toList());
        card.add(" ");//hack

        long sumOfCards = 0;
        int count = 1;

        for (int i = 0; i < card.size() - 1; i++) {
            if (!card.get(i).equals("A") && !card.get(i).equals("K") && !card.get(i).equals("Q") && !card.get(i).equals("J")) {
                if (card.get(i).equals(card.get(i + 1))) {
                    count++;
                } else {
                    if (count > 1) {
                        sumOfCards += (count * Integer.parseInt(card.get(i)) * 2);
                    } else {
                        sumOfCards += Integer.parseInt(card.get(i));
                    }
                    count = 1;
                }
            } else {
                if (card.get(i).equals("J")) {
                    if (card.get(i).equals(card.get(i + 1))) {
                        count++;
                    } else {
                        if (count > 1) {
                            sumOfCards += (count * 12) * 2;
                        } else {
                            sumOfCards += 12;
                        }
                        count = 1;
                    }
                } else if (card.get(i).equals("Q")) {
                    if (card.get(i).equals(card.get(i + 1))) {
                        count++;
                    } else {
                        if (count > 1) {
                            sumOfCards += (count * 13) * 2;
                        } else {
                            sumOfCards += 13;
                        }
                        count = 1;
                    }
                } else if (card.get(i).equals("K")) {
                    if (card.get(i).equals(card.get(i + 1))) {
                        count++;
                    } else {
                        if (count > 1) {
                            sumOfCards += (count * 14) * 2;
                        } else {
                            sumOfCards += 14;
                        }
                        count = 1;
                    }
                } else if (card.get(i).equals("A")) {
                    if (card.get(i).equals(card.get(i + 1))) {
                        count++;
                    } else {
                        if (count > 1) {
                            sumOfCards += (count * 15) * 2;
                        } else {
                            sumOfCards += 15;
                        }
                        count = 1;
                    }
                }
            }
        }
        System.out.println(sumOfCards);
    }
}
