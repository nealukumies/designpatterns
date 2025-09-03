public class Master extends Level {
    public Master(Player player) {
        super(player);
    }

    @Override
    public void train(){
        // Masters cannot train, game ended
    }
    @Override
    public void meditate() {
        // Masters cannot meditate, game ended
    }
    @Override
    public void fight() {
        // Masters cannot fight, game ended
    }

    @Override
    public void chooseAction() {
        System.out.println(player.getName() + " gained the Master level with " + player.getExperience() + " experience and " + player.getHealth() + " health points.");
        System.out.println("Congratulations! You have reached the highest level!");
        System.out.println("Do you want to play again? (y/n)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("y")) {
            player.setExperience(0);
            player.setHealth(100);
            player.setLevel(new Novice(player));
            System.out.println("Game restarted. You are now a Novice again.");
        } else {
            System.out.println("Thank you for playing!");
            System.exit(0);
        }
    }
}
