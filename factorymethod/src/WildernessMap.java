public class WildernessMap extends AbstractMap {
    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    public Tile createTile() {
        int randomType = (int) (Math.random() * 3);
        switch (randomType) {
            case 0:
                return new SwampTile();
            case 1:
                return new ForestTile();
            case 2:
                return new WaterTile();
        }
        return null;
    }

}
