package javaOOPBasics.encapsulation.shoppingSpree.src;

import java.util.LinkedList;
import java.util.List;

class Person {
    private String name;
    private Double money;
    private LinkedList<Product> products;

    public Person(String name, Double money) throws Exception {
        setName(name);
        setMoney(money);
        this.products = new LinkedList<>();
    }

    private void setName(String name) throws Exception {
        if (name.trim().length() == 0){
            throw new Exception("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    private void setMoney(Double money) throws Exception {
        if (money < 0){
            throw new Exception("Money cannot be negative");
        } else {
            this.money = money;
        }
    }

    public void buyProduct(Product product) throws Exception {
        if (product.getPrice() > this.money){
            throw new Exception(String.format("%s can't afford %s%n"
            ,this.name
            ,product.getName()));
        } else {
            this.products.add(product);
            this.money -= product.getPrice();
            System.out.printf("%s bought %s%n"
            ,this.name
            ,product.getName());
        }
    }

    public List<Product> getProducts(){
        return this.products;
    }
}
