package solidPrinciples.liskovSubstitution.goodSolutions.square;

public class Rectangle extends Shape {

    private double width;
    private double height;

    @Override
    public double area() {
        return this.width * this.height;
    }
}
