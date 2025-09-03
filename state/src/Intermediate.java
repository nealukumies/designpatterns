import java.util.Scanner;

public class Intermediate extends Level{
    public Intermediate(Player player) {
        super(player);
    }

    @Override
    public void train() {
        System.out.println(player.getName() + " is training as an Intermediate.");
        player.setExperience(player.getExperience() + 10);
        player.setLevel();
    }

    @Override
    public void meditate() {
        System.out.println(player.getName() + " is meditating as an Intermediate.");
        player.setHealth(player.getHealth() + 10);
    }

    @Override
    public void chooseAction(){
        System.out.println(player.getName() + " is an Intermediate with" + player.getExperience() + " experience and " + player.getHealth() + " health points.");
        System.out.println("Training increases experience by 10, meditating increases health by 10. Expert level is reached at 150 experience.");
        System.out.println("Do you want to train or meditate? (t/m)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("t")) {
            train();
        } else if (input.equalsIgnoreCase("m")) {
            meditate();
        } else {
            System.out.println("Invalid input. Please enter 't' to train or 'm' to meditate.");
        }
    }

    public void fight() {
        // Intermediates cannot fight
    }
}
