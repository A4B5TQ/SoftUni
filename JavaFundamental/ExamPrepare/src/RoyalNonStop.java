import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class RoyalNonStop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextLine();

        Double[] prices = Arrays.stream(sc.nextLine().split("\\s+")).map(Double::parseDouble).toArray(Double[]::new);

        double lukankaPrice = prices[0];
        double rakiaPrice = prices[1];

        String[] input = sc.nextLine().split("\\s+");
        BigDecimal money = BigDecimal.ZERO;

        int counter = 0;

        while (!input[0].equals("Royal")) {
            counter++;
            int targetRow = Integer.parseInt(input[0]);
            int targetColum = Integer.parseInt(input[1]);
            if (targetRow >= targetColum && targetRow != 0 && targetColum != 0) {
                for (int i = targetColum; i >= 0; i--) {
                    if (targetRow % 2 != 0) {

                        double calc = ((targetRow + 1) * (i + 1)) * rakiaPrice;
                        money = money.add(BigDecimal.valueOf(calc));
                    } else {

                        double calc = ((targetRow + 1) * (i + 1)) * lukankaPrice;
                        money = money.add(BigDecimal.valueOf(calc));
                    }

                }
                for (int i = targetRow - 1; i > 0; i--) {
                    if (i % 2 == 0) {
                        double calc = (i + 1) * lukankaPrice;
                        money = money.add(BigDecimal.valueOf(calc));
                    } else {
                        double calc = (i + 1) * rakiaPrice;
                        money = money.add(BigDecimal.valueOf(calc));
                    }
                }
            } else if (targetRow < targetColum && targetRow != 0 && targetColum != 0) {
                for (int i = targetRow; i >= 0; i--) {
                    if (i % 2 == 0) {
                        double calc = ((targetColum + 1) * (i + 1)) * lukankaPrice;
                        money = money.add(BigDecimal.valueOf(calc));
                    } else {
                        double calc = ((targetColum + 1) * (i + 1)) * rakiaPrice;
                        money = money.add(BigDecimal.valueOf(calc));
                    }
                }
                for (int i = targetColum - 1; i > 0; i--) {

                    double calc = (i + 1) * lukankaPrice;
                    money = money.add(BigDecimal.valueOf(calc));
                }
            }else if (targetColum == 0) {
                for (int i = targetRow; i > 0; i--) {
                    if (i % 2 == 0) {
                        double calc = (i + 1) * lukankaPrice;
                        money = money.add(BigDecimal.valueOf(calc));
                    } else {
                        double calc = (i + 1) * rakiaPrice;
                        money = money.add(BigDecimal.valueOf(calc));
                    }
                }
            } else if(targetRow == 0){
                double calc = (targetColum) * lukankaPrice;
                money = money.add(BigDecimal.valueOf(calc));
            }
            input = sc.nextLine().split("\\s+");
        }
        System.out.printf("%.6f\n", Double.parseDouble(money.toString()));
        System.out.println(counter);
    }
}