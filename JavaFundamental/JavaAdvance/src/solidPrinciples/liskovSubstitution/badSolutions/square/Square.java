package solidPrinciples.liskovSubstitution.badSolutions.square;

public class Square extends Rectangle {

    @Override
    public double getHeight() {
        return super.getHeight();
    }

    @Override
    public double getWidth() {
        return super.getWidth();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        super.setWidth(height);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setHeight(width);
    }
}
