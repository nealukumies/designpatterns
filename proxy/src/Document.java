import java.time.LocalDate;

public class Document implements IDocument{
    private int id;
    private LocalDate creationDate;
    private String content;
    private DocumentProxy proxy;

    public Document(int id, LocalDate creationDate, String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    @Override
    public int getId() { return id;}
    @Override
    public LocalDate getDate() { return creationDate; }
    @Override
    public String getContent(User user) { return content; }
}
