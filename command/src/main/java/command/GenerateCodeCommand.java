package command;

import view.GridController;

public class GenerateCodeCommand implements Command{
    private GridController receiver;
    public GenerateCodeCommand(GridController receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        int[][] data = receiver.getPixelData();
        System.out.println("int[][] pixelData = {");
        for (int i = 0; i < data.length; i++) {
            System.out.print("    {");
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j]);
                if (j < data[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("},");
            }
    }
}
