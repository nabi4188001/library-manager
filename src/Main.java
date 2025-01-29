
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
                    case 4 -> searchBooks();
                    case 5 -> showStats();
                    case 6 -> displayAllBooks();
                    case 7 -> System.exit(0);
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
        System.out.println("4. Search Books");
        System.out.println("5. Show Reading Stats");
        System.out.println("6. Display All Books");
        System.out.println("7. Exit");
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

    private static void searchBooks() {
        while (true) {
            System.out.println("\nSearch by:");
            System.out.println("1. Title");
            System.out.println("2. Author");
            System.out.println("3. Genre");
            System.out.println("4. Go Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1 -> searchByTitle();
                case 2 -> searchByAuthor();
                case 3 -> searchByGenre();
                case 4 -> {
                    System.out.println("Going back to the main menu...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
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