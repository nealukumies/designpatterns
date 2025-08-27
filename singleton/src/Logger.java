import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private File logFile;
    private FileWriter fileWriter = null;

    private Logger(){
        try {
            logFile = new File("log.txt");
            fileWriter = new FileWriter(logFile, true); // Append mode to avoid overwriting
        } catch (IOException e){
            System.out.println("Error creating log file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static synchronized Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public synchronized void setFileName(String fileName) {
        try {
            if (fileWriter != null) {
                fileWriter.close();
            }
            logFile = new File(fileName);
            fileWriter = new FileWriter(logFile, true);
        } catch (IOException e) {
            System.out.println("Error creating log file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public synchronized void write(String message){
        try {
            fileWriter.write(message + "\n");
            fileWriter.flush();
        }catch (IOException e){
            System.out.println("Error writing to log file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public synchronized void close(){
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
