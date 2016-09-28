package systemSplit.components;

public abstract class Component {
    protected final int INCREASE_VALUE = 2;
    private String name;
    private double price;

    protected Component(String name, double price){
        this.setName(name);
        this.setPrice(price);
    }

    private void setName(String name) {
        this.name = name;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    public double getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }
}
