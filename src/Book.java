/**
 * Represents a single book in the library.
 * Demonstrates basic OOP: private fields (encapsulation) with getters/setters.
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private boolean issued;

    public Book(int id, String title, String author, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.issued = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    @Override
    public String toString() {
        return String.format("%-4d %-25s %-20s %-15s %s",
                id, title, author, genre, issued ? "Issued" : "Available");
    }
}
