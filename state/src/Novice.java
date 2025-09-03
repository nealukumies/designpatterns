import java.util.Scanner;

 class Novice extends Level{
    public Novice(Player player) {
        super(player);
    }

    @Override
    public void train() {
        System.out.println(player.getName() + " is training as a Novice and gaining 10 experience points.");
        player.setExperience(player.getExperience() + 10);
        player.setLevel();
    }
    @Override
    public void chooseAction() {
        System.out.println(player.getName() + " is a Novice with " + player.getExperience() + " experience and " + player.getHealth() + " health points.");
        System.out.println("Training increases experience by 10. Intermediate level is reached at 50 experience.");
        System.out.println("Do you want to train or exit the game? (t/e)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("t")) {
            train();
        } else {
            System.out.println("You chose not to train.");
            System.out.println("Thank you for playing!");
            System.exit(0);
        }
    }

    @Override
    public void meditate(){
        // Novices cannot meditate
    }
    @Override
    public void fight() {
        // Novices cannot fight
    }
}
