import javafx.scene.canvas.GraphicsContext;

public interface Tile {
    String getType();
    void render(GraphicsContext gc, int x, int y, int size);
}
