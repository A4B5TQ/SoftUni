package javaOOPBasics.encapsulation.pizzaCalories.src;

import java.util.ArrayList;
import java.util.List;

class Pizza {
    private String name;
    private int numberOfTopings;
    private Dough dough;
    private List<Toping> topings;

    Pizza(String name, int numberOfTopings) throws Exception {
        this.setName(name);
        this.setNumberOfToppings(numberOfTopings);
        this.topings = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    int getNumberOfToppings() {
        return this.numberOfTopings;
    }

    double getCalories() {
        double doughCalories = this.dough.getCalories();
        double toppingCalories = this.topings
                .stream()
                .map(Toping::getCalories)
                .reduce((t1, t2) -> t1 + t2)
                .get();

        return doughCalories + toppingCalories;
    }

    void addTopping(Toping topping) {
        this.topings.add(topping);
    }

    void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setNumberOfToppings(int numberOfToppings) throws Exception {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new Exception("Number of toppings should be in range [0..10].");
        }

        this.numberOfTopings = numberOfToppings;
    }
}
