package solidPrinciples.singleResponibility.googSolutions.pr02;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double area(){
        return this.width * this.height;
    }
}
