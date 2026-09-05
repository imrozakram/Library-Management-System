import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Manages a collection of Book objects.
 * Demonstrates use of ArrayList, sorting (Collections.sort with Comparator),
 * and a manual binary search implementation.
 */
public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public boolean removeBook(int id) {
        return books.removeIf(b -> b.getId() == id);
    }

    public List<Book> searchByTitle(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }

    /**
     * Binary search by id. Requires the list to be sorted by id first,
     * so we sort a copy before searching (keeps the original list order intact).
     */
    public Book searchById(int id) {
        List<Book> sorted = new ArrayList<>(books);
        sorted.sort(Comparator.comparingInt(Book::getId));

        int low = 0;
        int high = sorted.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midId = sorted.get(mid).getId();

            if (midId == id) {
                return sorted.get(mid);
            } else if (midId < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public boolean issueBook(int id) {
        for (Book b : books) {
            if (b.getId() == id && !b.isIssued()) {
                b.setIssued(true);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(int id) {
        for (Book b : books) {
            if (b.getId() == id && b.isIssued()) {
                b.setIssued(false);
                return true;
            }
        }
        return false;
    }

    public void sortByTitle() {
        Collections.sort(books, Comparator.comparing(Book::getTitle));
    }

    public List<Book> getAllBooks() {
        return books;
    }
}
