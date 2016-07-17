package javaOOPBasics.inheritance.bookShop;

public class GoldenEditionBook extends Book{

    public GoldenEditionBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    protected double getPrice() {
        return super.getPrice() + super.getPrice() * 0.3D;
    }
}
