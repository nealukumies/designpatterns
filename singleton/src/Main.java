import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Logger logger = Logger.getInstance();
        logger.setFileName("new_log.txt");
        logger.write("Singleton pattern example");
        logger.write("Logging another message");
        logger.write("Final log entry");
        logger.close();

        System.out.println("Reading from new_log to verify contents:");
        try {
            File file = new File("new_log.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred reading file.");
            e.printStackTrace();
        }
    }
}
