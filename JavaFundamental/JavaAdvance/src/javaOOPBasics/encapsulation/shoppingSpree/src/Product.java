package javaOOPBasics.encapsulation.shoppingSpree.src;

class Product {
    private String name;
    private Double price;


    Product(String name, Double price) throws Exception {
        setPrice(price);
        setName(name);
    }

    private void setName(String name) throws Exception {
        if (name.trim().length() == 0){
            throw new Exception("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    private void setPrice(Double money) throws Exception {
        if (money < 0){
            throw new Exception("Money cannot be negative");
        } else {
            this.price = money;
        }
    }

    Double getPrice(){
        return this.price;
    }

    String getName(){
        return this.name;
    }
}
