public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.addPart(new Part("Mid-range Processor"));
    }
    @Override
    public void buildRAM() {
        computer.addPart(new Part("16GB RAM"));
    }
    @Override
    public void buildHardDrive() {
        computer.addPart(new Part("512GB SSD"));
    }
    @Override
    public void buildGraphicsCard() {
        computer.addPart(new Part("Integrated Graphics") );
    }
    @Override
    public void buildOperatingSystem() {
        computer.addPart(new Part("Windows 11 Pro"));
    }
    public Computer getComputer() {
        return computer;
    }
}
