package javaOOPBasics.encapsulation.pizzaCalories.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        try {
            String input = sc.readLine();

            while (!input.equals("END")) {
                String[] tokens = input.split("\\s+");

                switch (tokens[0]) {
                    case "Dough":
                        Dough dough = createDough(tokens);
                        System.out.printf("%.2f%n", dough.getCalories());
                        break;
                    case "Topping":
                        Toping toping = createToping(tokens);
                        System.out.printf("%.2f%n", toping.getCalories());
                        break;
                    case "Pizza":
                        Pizza pizza = createPizza(tokens, sc);
                        System.out.printf("%s - %.2f Calories.", pizza.getName(), pizza.getCalories());
                        break;
                }
                input = sc.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Pizza createPizza(String[] tokens, BufferedReader scanner) throws Exception {
        String pizzaName = tokens[1];
        int numberOfToppings = Integer.valueOf(tokens[2]);

        Pizza pizza = new Pizza(pizzaName, numberOfToppings);

        String input = scanner.readLine();
        String[] innerTokens = input.split("\\s+");

        Dough dough = createDough(innerTokens);
        pizza.setDough(dough);

        for (int i = 0; i < pizza.getNumberOfToppings(); i++) {
            input = scanner.readLine();
            innerTokens = input.split("\\s+");
            pizza.addTopping(createToping(innerTokens));
        }

        return pizza;
    }

    private static Toping createToping(String[] tokens) throws Exception {
        return new Toping(tokens[1], Double.parseDouble(tokens[2]));
    }

    private static Dough createDough(String[] tokens) throws Exception {
        return new Dough(tokens[1], tokens[2], Double.parseDouble(tokens[3]));
    }
}
