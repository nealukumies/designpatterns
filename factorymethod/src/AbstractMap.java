abstract class AbstractMap {
    public int width;
    public int height;

    public AbstractMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public abstract Tile createTile();

    public void display() {
        System.out.println("Generated map:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = createTile();  // generate tile on the spot
                System.out.print(tile.getCharacter() + " ");
            }
            System.out.println();
        }
    }
}
