public class CityMap extends AbstractMap {
    private static final String[] CITY_TILES = {"Road", "Forest", "Building"};

    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected String createTileType() {
        int idx = random.nextInt(CITY_TILES.length);
        return CITY_TILES[idx];
    }

    @Override
    protected String getImagePath(String type) {
        return switch (type) {
            case "Road" -> "images/road.png";
            case "Forest" -> "images/forest.png";
            case "Building" -> "images/building.png";
            default -> "images/default.png";
        };
    }
}
