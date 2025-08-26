import java.util.ArrayList;
import java.util.List;

public class Department extends Component {
    private List<Component> children = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "<Department>");
        System.out.println(indent + "    <Name>" + name + "</Name>");
        for (Component component : children) {;
            component.print(indent + "    ");
        }
        System.out.println(indent + "</Department>");
    }

    @Override
    public void add(Component component) {
        this.children.add(component);
    }

    @Override
    public void remove(Component component) {
        this.children.remove(component);
    }

    public double getTotalSalary() {
        double total = 0;
        for (Component component : children) {
            if (component instanceof Employee) {
                total += ((Employee) component).getSalary();
            } else {
                total += component.getTotalSalary();
           }
        }
        return total;
    }
}
