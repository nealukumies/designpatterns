public class Main {
    public static void main(String[] args) {
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerDirector gamingDirector = new ComputerDirector(gamingBuilder);
        ComputerDirector officeDirector = new ComputerDirector(officeBuilder);

        Computer gamingComputer = gamingDirector.constructComputer();
        Computer officeComputer = officeDirector.constructComputer();

        System.out.println("Gaming Computer Specifications:\n" + gamingComputer);
        System.out.println("Office Computer Specifications:\n" + officeComputer);
    }
}
