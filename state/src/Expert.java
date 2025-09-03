public class Expert extends Level{
    public Expert(Player player) {
        super(player);
    }

    @Override
    public void train() {
        System.out.println(player.getName() + " is training as an Expert.");
        player.setExperience(player.getExperience() + 15);
        player.setLevel();
    }

    @Override
    public void meditate() {
        System.out.println(player.getName() + " is meditating as an Expert.");
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
        System.out.println("Training increases experience by 15, meditating increases health by 15, fighting increases experience by 20 but decreases health by 10.");
        System.out.println("Master level is reached at 300 experience.");
        System.out.println("Do you want to train, meditate, or fight? (t/m/f)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("t")) {
            train();
        } else if (input.equalsIgnoreCase("m")) {
            meditate();
        } else if (input.equalsIgnoreCase("f")) {
            fight();
        } else {
            System.out.println("Invalid input. Please enter 't' to train, 'm' to meditate, or 'f' to fight.");
        }
    }
}
