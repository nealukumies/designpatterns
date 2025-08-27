import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private File logFile;
    FileWriter fileWriter = null;

    private Logger(){
        try {
            logFile = new File("log.txt");
            fileWriter = new FileWriter(logFile);
        } catch (IOException e){
            System.out.println("Error creating log file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void setFileName(String fileName) {
        try {
            logFile = new File(fileName);
            fileWriter = new FileWriter(logFile);
        } catch (IOException e) {
            System.out.println("Error creating log file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void write(String message){
        try {
            fileWriter.write(message + "\n");
        }catch (IOException e){
            System.out.println("Error writing to log file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println("Error closing log file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
