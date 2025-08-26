public class Employee extends Component {
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "<Employee>");
        System.out.println(indent + indent + "<Name>" + name + "</Name>");
        System.out.println(indent + indent + "<Salary>" + salary + "</Salary>");
        System.out.println(indent + "</Employee>");
    }

    public double getSalary() {
        return salary;
    }

    //the following not supported in leaf
    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Cannot add to an employee");
    }
    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Cannot remove from an employee");
    }
    @Override
    public double getTotalSalary() {
        return salary;
    }

}
