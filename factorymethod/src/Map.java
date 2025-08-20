abstract class Map {

    public void createTile() {
        Tile tile = createTile();
        System.out.println("Creating a tile of type: " + tile.getClass().getSimpleName());
    }

}
