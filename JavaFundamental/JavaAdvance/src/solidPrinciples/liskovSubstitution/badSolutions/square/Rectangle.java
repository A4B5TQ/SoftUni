package solidPrinciples.liskovSubstitution.badSolutions.square;

public class Rectangle extends Shape {

    private double width;
    private double height;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double area() {
        return this.width * this.height;
    }
}
