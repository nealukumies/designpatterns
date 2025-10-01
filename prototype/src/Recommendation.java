import java.util.ArrayList;

public class Recommendation implements Cloneable{
    private TargetAudience targetAudience;
    private ArrayList<Book> books;

    public Recommendation(TargetAudience targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public TargetAudience getTargetAudience() {
        return targetAudience;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }
    public void setTargetAudience(TargetAudience targetAudience) {
        this.targetAudience = targetAudience;
    }
    public void addBook(Book book) {
        this.books.add(book);
    }
    public void removeBook(Book book) {
        this.books.remove(book);
    }
    @Override
    public String toString() {
        return "Recommendation{" +
                "targetAudience='" + targetAudience + '\'' +
                ", books=" +
                "\n" + books +
                '}';
    }

    @Override
    public Recommendation clone() {
        try {
            Recommendation cloned = (Recommendation) super.clone();
            cloned.books = new ArrayList<>();
            for (Book book : this.books) {
                cloned.books.add(new Book(book.getAuthor(), book.getTitle(), book.getGenre(), book.getPublicationYear()));
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
