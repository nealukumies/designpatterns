public class BuildingTile implements Tile {
    @Override
    public String getType() {
        return "Building";
    }

    @Override
    public char getCharacter() {
        return 'B';
    }
}
