public class AbstractTile implements Tile {
    private String type;
    private char character;

    public AbstractTile(String type, char character) {
        this.type = type;
        this.character = character;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public char getCharacter() {
        return character;
    }
}
