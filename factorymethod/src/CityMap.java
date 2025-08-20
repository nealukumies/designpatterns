public class CityMap extends AbstractMap {


    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    public Tile createTile() {
        int randomType = (int) (Math.random() * 3);
        switch (randomType) {
            case 0:
                return new RoadTile();
            case 1:
                return new ForestTile();
            case 2:
                return new BuildingTile();
        }
        return null;
    }
}
