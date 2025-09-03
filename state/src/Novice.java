class Novice extends Level{
    public Novice(Player player) {
        super(player);
        this.levelName = "Novice";
    }

    @Override
    public void train() {
        System.out.println(player.getName() + " is training as a Novice and gains 10 experience points.");
        player.addExperience(10);
    }
}
