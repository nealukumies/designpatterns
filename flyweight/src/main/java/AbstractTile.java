import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class AbstractTile implements Tile {
    private String type;
    private Image image;

    public AbstractTile(String type, String path) {
        this.type = type;
        this.image = new Image(path);
    }

    @Override
    public String getType() {
        return type;
    }
    @Override
    public void render(GraphicsContext gc, int x, int y, int size) {
        gc.drawImage(image, x * size, y * size, size, size);
    }

    public void action(){
        System.out.println("Performing action for tile type: " + type);
        // Additional action logic can be implemented here, not used in this assignment
    }
}
