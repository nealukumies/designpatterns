import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UIFactory factory;
        String choice;
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Abstract Factory");
            System.out.println("Choose factory A or B, E for exit.");
            choice = scanner.nextLine().toUpperCase();
            if (choice.equals("E")) {
                System.out.println("Exiting program.");
                break;
            } else if (choice.equals("A")) {
                factory = new AFactory();
            } else if (choice.equals("B")) {
                factory = new BFactory();
            } else {
                System.out.println("Invalid input. Choose factory A or B, E for exit.");
                continue;
            }

            Button button = factory.createButton("Button");
            TextField textField = factory.createTextField("Text field");
            Checkbox checkbox = factory.createCheckbox("Check this", true);
            System.out.println("Factory " + choice + " created:");

            while (true) {
            System.out.println("Display components D, Edit text E or New factory N?");
            String action = scanner.nextLine().toUpperCase();

            if (action.equals("N")){
                break;
            }
            else if (action.equals("D")) {
                button.display();
                textField.display();
                checkbox.display();
            } else if (action.equals("E")) {
                System.out.println("Do you want to edit Button B, TextField T or Checkbox C?");
                String component = scanner.nextLine().toUpperCase();
                System.out.println("Enter new text:");
                String newText = scanner.nextLine();
                switch (component) {
                    case "B":
                        button.setText(newText);
                        break;
                    case "T":
                        textField.setText(newText);
                        break;
                    case "C":
                        checkbox.setText(newText);
                        break;
                    default:
                        System.out.println("Invalid input.");
                        continue;
                }
                System.out.println("Updated components");
                button.display();
                textField.display();
                checkbox.display();
            } else {
                System.out.println("Invalid input.");
            }
            }
        }
    }
}