
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LibraryManager manager = new LibraryManager();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> addBook();
                    case 2 -> editBook();
                    case 3 -> deleteBook();
                    case 4 -> searchByTitle();
                    case 5 -> searchByAuthor();
                    case 6 -> searchByGenre();
                    case 7 -> showStats();
                    case 8 -> displayAllBooks();
                    case 9 -> System.exit(0);
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nPersonal Library Manager");
        System.out.println("1. Add Book");
        System.out.println("2. Edit Book");
        System.out.println("3. Delete Book");
        System.out.println("4. Search by Title");
        System.out.println("5. Search by Author");
        System.out.println("6. Search by Genre");
        System.out.println("7. Show Reading Stats");
        System.out.println("8. Display All Books"); // New option
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }


    public static boolean isValidString(String input) {
        return input.matches("[a-zA-Z]+");
    }


    private static void addBook() throws DuplicateBookException, InvalidInputException, InvalidYesNoInputException {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        if (!isValidString(author)) {
            throw new InvalidInputException("Author name must contain only letters.");
        }

        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        System.out.print("Have you read it? (yes/no): ");
        String readInput = scanner.nextLine().toLowerCase();
        boolean isRead;
        if (readInput.equals("yes")) {
            isRead = true;
        } else if (readInput.equals("no")) {
            isRead = false;
        } else {
            throw new InvalidYesNoInputException("Please enter 'yes' or 'no'.");
        }

        Book book = new Book(title, author, genre, isRead);
        manager.addBook(book);
        System.out.println("Book added successfully!");
    }

    private static void editBook() throws BookNotFoundException, InvalidInputException, InvalidYesNoInputException {
        System.out.print("Enter the title of the book to edit: ");
        String oldTitle = scanner.nextLine();

        System.out.print("Enter new title: ");
        String title = scanner.nextLine();

        System.out.print("Enter new author: ");
        String author = scanner.nextLine();
        if (!isValidString(author)) {
            throw new InvalidInputException("Author name must contain only letters.");
        }

        System.out.print("Enter new genre: ");
        String genre = scanner.nextLine();

        System.out.print("Have you read it? (yes/no): ");
        String readInput = scanner.nextLine().toLowerCase();
        boolean isRead;
        if (readInput.equals("yes")) {
            isRead = true;
        } else if (readInput.equals("no")) {
            isRead = false;
        } else {
            throw new InvalidYesNoInputException("Please enter 'yes' or 'no'.");
        }

        Book updatedBook = new Book(title, author, genre, isRead);
        manager.editBook(oldTitle, updatedBook);
        System.out.println("Book updated successfully!");
    }


    private static void deleteBook() throws BookNotFoundException {
        System.out.print("Enter the title of the book to delete: ");
        String title = scanner.nextLine();
        manager.deleteBook(title);
        System.out.println("Book deleted successfully!");
    }

    private static void searchByTitle() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        List<Book> results = manager.searchByTitle(title);
        displaySearchResults(results);
    }

    private static void searchByAuthor() {
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        List<Book> results = manager.searchByAuthor(author);
        displaySearchResults(results);
    }

    private static void searchByGenre() {
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        List<Book> results = manager.searchByGenre(genre);
        displaySearchResults(results);
    }

    private static void showStats() {
        Map<String, Integer> stats = manager.getReadingStats();
        System.out.println("\nReading Statistics:");
        System.out.println("Read books: " + stats.get("read"));
        System.out.println("Unread books: " + stats.get("unread"));
    }

    private static void displaySearchResults(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private static void displayAllBooks() {
        List<Book> allBooks = manager.getBooks();
        if (allBooks.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("\nBooks in the library:");
            allBooks.forEach(System.out::println);
        }
    }

}