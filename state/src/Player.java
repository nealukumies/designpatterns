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

    public Level getLevel() {
        return level;
    }
    public void setLevel(Level level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public void setLevel() {
        if (experience >= 50 && level instanceof Novice) {
            setLevel(new Intermediate(this));
            System.out.println(name + " leveled up to Intermediate!");
        } else if (experience >= 150 && level instanceof Intermediate) {
            setLevel(new Expert(this));
            System.out.println(name + " leveled up to Expert!");
        } else if (experience >= 300 && level instanceof Expert) {
            setLevel(new Master(this));
            System.out.println(name + " leveled up to Master!");
        }
    }

    public void play() {
        while (true) {
            level.chooseAction();
        }
    }
}
