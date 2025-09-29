public class WildernessMap extends AbstractMap {
    private static final String[] WILDERNESS_TILES = {"Swamp", "Forest", "Water"};

    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected String createTileType() {
        int idx = random.nextInt(WILDERNESS_TILES.length);
        return WILDERNESS_TILES[idx];
    }

    @Override
    protected String getImagePath(String type) {
        return switch (type) {
            case "Swamp" -> "images/swamp.png";
            case "Forest" -> "images/forest.png";
            case "Water" -> "images/water.png";
            default -> "images/default.png";
        };
    }
}