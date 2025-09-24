public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.addPart(new Part("High-end Processor"));
    }
    @Override
    public void buildRAM() {
        computer.addPart(new Part("32GB RAM"));
    }
    @Override
    public void buildHardDrive() {
        computer.addPart(new Part("1TB SSD"));
    }
    @Override
    public void buildGraphicsCard() {
        computer.addPart(new Part("High-end Graphics Card"));
    }
    @Override
    public void buildOperatingSystem() {
        computer.addPart(new Part("Windows 11 Pro"));
    }
    public Computer getComputer() {
        return computer;
    }
}
