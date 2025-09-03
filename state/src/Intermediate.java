import java.util.Scanner;

public class Intermediate extends Level{
    public Intermediate(Player player) {
        super(player);
    }

    @Override
    public void train() {
        System.out.println(player.getName() + " is training as an Intermediate and gaining 15 experience points.");
        player.setExperience(player.getExperience() + 15);
        player.setLevel();
    }

    @Override
    public void meditate() {
        System.out.println(player.getName() + " is meditating as an Intermediate and gaining 10 health points.");
        player.setHealth(player.getHealth() + 10);
    }

    @Override
    public void chooseAction(){
        System.out.println(player.getName() + " is an Intermediate with " + player.getExperience() + " experience and " + player.getHealth() + " health points.");
        System.out.println("Training increases experience by 15, meditating increases health by 10. Expert level is reached at 150 experience.");
        System.out.println("Do you want to train, meditate or exit the game? (t/m/e)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("t")) {
            train();
        } else if (input.equalsIgnoreCase("m")) {
            meditate();
        } else if (input.equalsIgnoreCase("e")) {
            System.out.println("You chose to exit the game.");
            System.out.println("Thank you for playing!");
            System.exit(0);
        } else {
            System.out.println("Invalid input. Please enter 't' to train, 'm' to meditate, or 'e' to exit.");
            chooseAction();
        }
    }

    public void fight() {
        // Intermediates cannot fight
    }
}
