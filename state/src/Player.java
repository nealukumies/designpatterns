import java.util.Scanner;

public class Player {
    private String name;
    private Level level;
    private int experience;
    private int health;

    public Player(String name) {
        this.name = name;
        this.experience = 0;
        this.health = 100;
        this.level = new Novice(this);
    }

    public String getName() {
        return name;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }
    public void addExperience(int experience) {
        this.experience += experience;
        checkLevel();
    }

    public int getHealth() {
        return health;
    }
    public void addHealth(int health) {
        this.health += health;
    }

    public void checkLevel() {
        String levelUp =
                " _        _______           _______  _                   _______ \n" +
                        "( \\      (  ____ \\|\\     /|(  ____ \\( \\        |\\     /|(  ____ )\n" +
                        "| (      | (    \\/| )   ( || (    \\/| (        | )   ( || (    )|\n" +
                        "| |      | (__    | |   | || (__    | |        | |   | || (____)|\n" +
                        "| |      |  __)   ( (   ) )|  __)   | |        | |   | ||  _____)\n" +
                        "| |      | (       \\ \\_/ / | (      | |        | |   | || (      \n" +
                        "| (____/\\| (____/\\  \\   /  | (____/\\| (____/\\  | (___) || )      \n" +
                        "(_______/(_______/   \\_/   (_______/(_______/  (_______)|/       \n" +
                        "                                                                 ";
        if (experience >= 50 && level instanceof Novice) {
            System.out.println(levelUp);
            setLevel(new Intermediate(this));
            System.out.println(name + " leveled up to Intermediate!");

        } else if (experience >= 200 && level instanceof Intermediate) {
            System.out.println(levelUp);
            setLevel(new Expert(this));
            System.out.println(name + " leveled up to Expert!");
        } else if (experience >= 400 && level instanceof Expert) {
            System.out.println(levelUp);
            setLevel(new Master(this));
            System.out.println(name + " leveled up to Master!");
            System.out.println("Congratulations! You've reached the highest level! Game ends here.");
            System.exit(0);
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(name);
            System.out.println("Level: " + level.getLevelName());
            System.out.println("Experience: " + experience);
            System.out.println("Health: " + health);

            System.out.println("Choose an action: 1. Train 2. Meditate 3. Fight 4. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    level.train();
                    break;
                case 2:
                    level.meditate();
                    break;
                case 3:
                    if (health <10) {
                        System.out.println("You don't have enough health to fight. Meditate to gain health points.");
                        break;
                    }
                    level.fight();
                    break;
                case 4:
                    System.out.println("Exiting game.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("---------------------------");

        }
    }
}
