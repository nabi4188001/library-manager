
import java.util.*;

public class LibraryManager implements Searchable {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) throws DuplicateBookException {
        if (books.stream().anyMatch(b -> b.getTitle().equalsIgnoreCase(book.getTitle()))) {
            throw new DuplicateBookException("Book already exists: " + book.getTitle());
        }
        books.add(book);
    }
}

