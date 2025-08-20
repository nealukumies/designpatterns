import java.util.Scanner;

public class Game {

    public static AbstractMap createMap(int type, int width, int height) {
        if (type == 1) {
            return new CityMap(width, height);
        } else if (type == 2) {
            return new WildernessMap(width, height);
        } else {
            System.out.println("Invalid map type selected.");
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the RPG Map Generator!");
        System.out.println("Enter 1 for a City Map, 2 for a Wilderness Map, or 3 to exit:");
        int choice = sc.nextInt();
        int width = 30;
        int height = 20;

        while (choice != 3) {
            AbstractMap map = createMap(choice, width, height);
            if (map != null) {
                map.display();
            }
            System.out.println("Enter 1 for a City Map, 2 for a Wilderness Map, or 3 to exit:");
            choice = sc.nextInt();
        }
    }
}
