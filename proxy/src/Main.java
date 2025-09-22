import java.sql.SQLOutput;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addDocument(LocalDate.of(2025, 9, 22), "Document 1", false);
        library.addDocument(LocalDate.of(2025, 9, 23), "Document 2", true);

        User user = new User("Aliisa");
        User user2 = new User("Mikko");

        //Only user Aliisa has access to document 2
        AccessControlService accessControlService = AccessControlService.getInstance();
        accessControlService.addUserAccess("Aliisa", 2);

        System.out.println("User " + user.getUsername() + " tries to access Document 1:");
        System.out.println(library.getDocument(1).getContent(user));
        System.out.println("User " + user.getUsername() + " tries to access Document 2:");
        System.out.println(library.getDocument(2).getContent(user));

        System.out.println("User " + user2.getUsername() + " tries to access Document 1:");
        System.out.println(library.getDocument(1).getContent(user2));
        System.out.println("User " + user2.getUsername() + " tries to access Document 2:");
        try {
            System.out.println(library.getDocument(2).getContent(user2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
