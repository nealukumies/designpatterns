public class Intermediate extends Level{
    public Intermediate(Player player) {
        super(player);
        this.levelName = "Intermediate";
    }

    @Override
    public void train() {
        System.out.println(player.getName() + " is training as an Intermediate and gains 15 experience points.");
        player.addExperience(15);
    }

    @Override
    public void meditate() {
        System.out.println(player.getName() + " is meditating as an Intermediate and gains 10 health points.");
        player.addHealth(10);
    }
}
