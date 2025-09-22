import java.time.LocalDate;

public class DocumentProxy implements IDocument{
    private Document document;

    public DocumentProxy(Document document) {
        this.document = document;

    }

    @Override
    public int getId() { return document.getId();}
    @Override
    public LocalDate getDate() { return document.getDate(); }
    @Override
    public String getContent(User user){
        AccessControlService accessControlService = AccessControlService.getInstance();
            if (accessControlService.isAllowed(user.getUsername(), document.getId())) {
                return document.getContent(user);
            } else {
            throw new AccessDeniedException("User " + user.getUsername() + " does not have access to document id "  + document.getId() + ".");
        }
    }
}
