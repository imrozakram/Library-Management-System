import java.util.List;
import java.util.Scanner;

/**
 * Console-based Library Management System.
 * Entry point that ties Book and Library together through a simple text menu.
 */
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        // Preload a few sample books so the menu has something to show immediately
        library.addBook(new Book(1, "The Alchemist", "Paulo Coelho", "Fiction"));
        library.addBook(new Book(2, "Clean Code", "Robert C. Martin", "Programming"));
        library.addBook(new Book(3, "Atomic Habits", "James Clear", "Self-help"));

        int choice = -1;

        while (choice != 0) {
            printMenu();
            choice = readInt(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int newId = readInt(sc);
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = sc.nextLine();
                    library.addBook(new Book(newId, title, author, genre));
                    break;

                case 2:
                    System.out.print("Enter ID to remove: ");
                    int removeId = readInt(sc);
                    System.out.println(library.removeBook(removeId) ? "Book removed." : "Book not found.");
                    break;

                case 3:
                    System.out.print("Enter a keyword from the title: ");
                    String keyword = sc.nextLine();
                    List<Book> results = library.searchByTitle(keyword);
                    if (results.isEmpty()) {
                        System.out.println("No matching books found.");
                    } else {
                        for (Book b : results) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to issue: ");
                    int issueId = readInt(sc);
                    System.out.println(library.issueBook(issueId) ? "Book issued." : "Book unavailable or not found.");
                    break;

                case 5:
                    System.out.print("Enter ID to return: ");
                    int returnId = readInt(sc);
                    System.out.println(library.returnBook(returnId) ? "Book returned." : "Book not found or wasn't issued.");
                    break;

                case 6:
                    library.sortByTitle();
                    for (Book b : library.getAllBooks()) {
                        System.out.println(b);
                    }
                    break;

                case 7:
                    System.out.print("Enter ID to look up (binary search): ");
                    int searchId = readInt(sc);
                    Book found = library.searchById(searchId);
                    System.out.println(found != null ? found : "Book not found.");
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

        sc.close();
    }

    private static void printMenu() {
        System.out.println("\n===== Library Management System =====");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Search Book by Title");
        System.out.println("4. Issue Book");
        System.out.println("5. Return Book");
        System.out.println("6. Display All Books (sorted by title)");
        System.out.println("7. Find Book by ID (binary search)");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine(); // consume the leftover newline
        return value;
    }
}
