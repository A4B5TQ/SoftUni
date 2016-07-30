package solidPrinciples.singleResponibility.googSolutions.pr02;

public class DrawingManagerImpl implements DrawingManager {
    private DrawingContext drawingContext;
    private Renderer renderer;

    public DrawingManagerImpl(DrawingContext drawingContext, Renderer renderer) {
        this.drawingContext = drawingContext;
        this.renderer = renderer;
    }


    @Override
    public void draw(Shape shape) {
        this.renderer.render(this.drawingContext, shape);
    }
}
