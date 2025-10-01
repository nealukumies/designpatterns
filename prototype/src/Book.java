public class Book implements Cloneable {
    private String author;
    private String title;
    private Genre genre;
    private int publicationYear;

    public Book(String author, String title, Genre genre, int publicationYear) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public Genre getGenre() {
        return genre;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    @Override
    public String toString() {
        return "Book{author= " + author + ", title= " + title + "}";
    }
    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
