import java.util.HashMap;
import java.util.Map;

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
