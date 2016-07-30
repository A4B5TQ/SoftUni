package solidPrinciples.singleResponibility.googSolutions.pr02;

public class Square implements solidPrinciples.singleResponibility.googSolutions.pr02.Shape {
    private int side;
    @Override
    public double area() {
        return this.side * this.side;
    }
}
