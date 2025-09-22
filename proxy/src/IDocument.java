import java.time.LocalDate;

public interface IDocument {
    int getId();
    LocalDate getDate();
    String getContent(User user);
}
