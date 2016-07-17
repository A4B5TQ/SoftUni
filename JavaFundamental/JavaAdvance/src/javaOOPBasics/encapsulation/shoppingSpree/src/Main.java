package javaOOPBasics.encapsulation.shoppingSpree.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Person> persons = new LinkedHashMap<>();
        LinkedHashMap<String, Product> products = new LinkedHashMap<>();


        String[] personsData = sc.readLine().split(";");

        for (String data : personsData) {
            String[] personInfo = data.split("=");
            String name = personInfo[0];
            Double money = Double.parseDouble(personInfo[1]);

            try {
                Person person = new Person(name, money);
                persons.put(name, person);
            } catch (Exception e) {
                System.out.print(e.getMessage());
                return;
            }
        }

        String[] productsData = sc.readLine().split(";");

        for (String data : productsData) {
            String[] productInfo = data.split("=");
            String name = productInfo[0];
            Double price = Double.parseDouble(productInfo[1]);
            try {
                Product product = new Product(name, price);
                products.put(name, product);

            } catch (Exception e) {
                System.out.print(e.getMessage());
                return;
            }
        }
        String input = sc.readLine();

        while (!input.equals("END")) {
            String[] inputData = input.split("\\s+");
            Person person = persons.get(inputData[0]);
            Product product = products.get(inputData[1]);
            try {
                person.buyProduct(product);
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
            input = sc.readLine();
        }
        persons.entrySet().stream().forEach(entry -> {
            int productsCount = entry.getValue().getProducts().size();
            if (productsCount == 0) {
                System.out.println(entry.getKey() + " - Nothing bought");
            } else {
                System.out.println(entry.getKey() + " - " +
                        String.join(", ", entry.getValue().getProducts()
                                .stream().map(Product::getName).toArray(String[]::new)));
            }
        });
    }
}
