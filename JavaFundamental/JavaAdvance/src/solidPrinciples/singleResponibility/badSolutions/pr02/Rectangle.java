package solidPrinciples.singleResponibility.badSolutions.pr02;

public class Rectangle implements Shape{
    private double width;
    private double height;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double area(){
        return this.width * this.height;
    }

    @Override
    public void draw(DrawingContext context) {
        //Drawing the rectangle on the context
    }
}
