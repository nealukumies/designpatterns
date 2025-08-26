public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void print(String indent);
    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract double getTotalSalary();

}
