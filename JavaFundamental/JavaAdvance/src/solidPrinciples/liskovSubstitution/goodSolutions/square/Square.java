package solidPrinciples.liskovSubstitution.goodSolutions.square;

public class Square extends Shape {

    private double side;

    @Override
    public double area() {
        return this.side * this.side;
    }
}
