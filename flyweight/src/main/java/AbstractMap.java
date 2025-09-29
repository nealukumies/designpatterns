import javafx.scene.canvas.GraphicsContext;
import java.util.Random;

public abstract class AbstractMap {
    protected final int width;
    protected final int height;
    protected final String[][] mapTypes;
    protected final Random random = new Random();

    public AbstractMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.mapTypes = new String[height][width];
        generateMap();
    }

    protected abstract String createTileType();

    private void generateMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                mapTypes[i][j] = createTileType();
            }
        }
    }

    public void render(GraphicsContext gc, int tileSize) {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                String type = mapTypes[row][col];

                Tile tile = TileFactory.getTile(type, getImagePath(type));
                tile.render(gc, col, row, tileSize);
            }
        }
    }

    protected abstract String getImagePath(String type);
}
