public abstract class Level {
    protected Player player;
    protected String levelName;

    public Level(Player player) {
        this.player = player;
    }

    public String getLevelName() {
        return levelName;
    }

    public void train() {
        System.out.println("You cannot train at this level.");
    };
    public void meditate(){
        System.out.println("You cannot meditate at this level.");
    };
    public void fight(){
        System.out.println("You cannot fight at this level.");
    };

}