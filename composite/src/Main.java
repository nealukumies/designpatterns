public class Main {
    public static void main(String[] args) {
        System.out.println("Composite Pattern");

        Component department1 = new Department("Department 1");
        Component department2 = new Department("Department 2");
        Component department3 = new Department("Department 3");
        Component department4 = new Department("Department 4");
        Component department5 = new Department("Department 5");

        Component employee1 = new Employee("Ada", 15000);
        Component employee2 = new Employee("Ida", 6000);
        Component employee3 = new Employee("Eda", 7000);
        Component employee4 = new Employee("Uda", 8000);
        Component employee5 = new Employee("Oda", 9000);
        Component employee6 = new Employee("Frida", 5000);

        department1.add(employee1);
        department1.add(department2);
        department1.add(department3);

        department2.add(department4);
        department2.add(department5);
        department2.add(employee2);

        department3.add(employee3);
        department3.add(employee4);

        department4.add(employee5);

        department5.add(employee6);

        System.out.println("Organization Structure:");
        department1.print("");
        System.out.println("Organization total salary: " + department1.getTotalSalary() + " €.");
    }
}
