public class Expert extends Level{
    public Expert(Player player) {
        super(player);
        this.levelName = "Expert";
    }

    @Override
    public void train() {
        System.out.println(player.getName() + " is training as an Expert and gains 20 experience points.");
        player.addExperience(20);
    }

    @Override
    public void meditate() {
        System.out.println(player.getName() + " is meditating as an Expert and gains 15 health points.");
        player.addHealth(15);
    }

    @Override
    public void fight() {
        System.out.println(player.getName() + " is fighting as an Expert and gains 20 experience points while loosing 10 health points.");
        player.addExperience(20);
        player.addHealth(-10);
    }
}
