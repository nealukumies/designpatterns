import java.util.Scanner;

public class Game {

    public Map createMap(int type) {
        if (type == 1) {
            return new CityMap();
        } else if (type == 2) {
            return new WildernessMap();
        } else {
            throw new IllegalArgumentException("Invalid map type");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the RPG Map Generator!");
        System.out.println("Enter 1 for a City Map, 2 for a Wilderness Map, or 3 to exit:");
        int choice = sc.nextInt();
        while (choice != 3) {
            switch (choice) {
                case 1:
                    System.out.println("Generating City Map...");
                    // call map
                    break;
                case 2:
                    System.out.println("Generating Wilderness Map...");
                    // call map
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
            System.out.println("Enter 1 for a City Map, 2 for a Wilderness Map, or 3 to exit:");
            choice = sc.nextInt();
        }
    }
}
