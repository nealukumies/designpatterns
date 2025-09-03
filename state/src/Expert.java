public class Expert extends Level{
    public Expert(Player player) {
        super(player);
    }

    @Override
    public void train() {
        System.out.println(player.getName() + " is training as an Expert and gaining 20 experience points.");
        player.setExperience(player.getExperience() + 20);
        player.setLevel();
    }

    @Override
    public void meditate() {
        System.out.println(player.getName() + " is meditating as an Expert and gaining 15 health points.");
        player.setHealth(player.getHealth() + 15);
    }

    @Override
    public void fight() {
        System.out.println(player.getName() + " is fighting as an Expert.");
        player.setExperience(player.getExperience() + 20);
        player.setHealth(player.getHealth() - 10);
        player.setLevel();
    }

    @Override
    public void chooseAction() {
        System.out.println(player.getName() + " is an Expert with " + player.getExperience() + " experience and " + player.getHealth() + " health points.");
        System.out.println("Training increases experience by 20, meditating increases health by 15, fighting increases experience by 20 but decreases health by 10.");
        System.out.println("Master level is reached at 300 experience.");
        System.out.println("Do you want to train, meditate, fight or exit the game? (t/m/f/e)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("t")) {
            train();
        } else if (input.equalsIgnoreCase("m")) {
            meditate();
        } else if (input.equalsIgnoreCase("f")) {
            if (player.getHealth() < 10)
                System.out.println("You don't have enough health to fight. Please meditate to regain health.");
            else {
                fight();
            }
        } else if (input.equalsIgnoreCase("e")) {
            System.out.println("You chose to exit the game.");
            System.out.println("Thank you for playing!");
            System.exit(0);
        } else {
            System.out.println("Invalid input. Please enter 't' to train, 'm' to meditate, or 'f' to fight.");
        }
    }
}
