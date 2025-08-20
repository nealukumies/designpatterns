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

    public void action(){
        System.out.println("Performing action for tile type: " + type);
        // Additional action logic can be implemented here, not used in this assignment
    }
}
