import java.time.LocalDate;
import java.util.HashMap;

public class Library {
    private HashMap<Integer, IDocument> documents;
    private int documentId = 1;

    public Library() {
        this.documents = new HashMap<>();
    }

    public void addDocument(LocalDate creationDate, String content, boolean isProtected) {
        Document document = new Document(documentId, creationDate, content);

        if (isProtected) {
            documents.put(documentId, new DocumentProxy(document));
        } else {
            documents.put(documentId, document);
        }
        documentId ++;
    }

    public IDocument getDocument(int id) {
        return documents.get(id);
    }
}
