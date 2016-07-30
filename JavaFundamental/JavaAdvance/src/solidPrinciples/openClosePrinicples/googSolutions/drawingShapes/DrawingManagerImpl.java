package solidPrinciples.openClosePrinicples.googSolutions.drawingShapes;

public abstract class DrawingManagerImpl implements DrawingManager {

    @Override
    public void draw(Shape shape) {

        this.drawFigure(shape);
    }

    protected abstract void drawFigure(Shape shape);
}
