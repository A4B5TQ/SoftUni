package solidPrinciples.openClosePrinicples.badSolutions.drawingShapes;

public class DrawingManagerImpl implements DrawingManager {

    @Override
    public void draw(Shape shape) {

        if (shape instanceof Circle)
        {
            this.drawCircle((Circle) shape);
        }
        else if (shape instanceof Rectangle)
        {
            this.drawRectangle((Rectangle) shape);
        }
    }

    public void drawRectangle(Rectangle rectangle)
    {
        // Draw Rectangle
    }

    public void drawCircle(Circle circle)
    {
        // Draw Circle
    }
}
