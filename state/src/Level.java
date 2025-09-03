import java.util.Scanner;

public abstract class Level {
    protected Player player;
    protected Scanner scanner;

    public Level(Player player) {
        this.player = player;
        scanner = new Scanner(System.in);
    }

    public abstract void chooseAction();
    public abstract void train();
    public abstract void meditate();
    public abstract void fight();

}