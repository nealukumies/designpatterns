import java.util.HashMap;
import java.util.Map;

// Flyweight Factory that manages the shared Tile instances.
// It checks if a Tile of the requested type already exists; if so, it returns the existing instance.
// If not, it creates a new Tile, stores it, and then returns it.
public class TileFactory {
    private static final Map<String, Tile> tiles = new HashMap<>();

    public static Tile getTile(String type, String path) {
        if (tiles.containsKey(type)) {
            return tiles.get(type);
        } else {
            Tile newTile = new AbstractTile(type, path);
            tiles.put(type, newTile);
            return newTile;
        }
    }
}
