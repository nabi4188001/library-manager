
import java.util.*;

public class LibraryManager implements Searchable {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) throws DuplicateBookException {
        if (books.stream().anyMatch(b -> b.getTitle().equalsIgnoreCase(book.getTitle()))) {
            throw new DuplicateBookException("Book already exists: " + book.getTitle());
        }
        books.add(book);
    }
    public void editBook(String oldTitle, Book newBook) throws BookNotFoundException {
        Book existing = getBookByTitle(oldTitle);
        existing.setTitle(newBook.getTitle());
        existing.setAuthor(newBook.getAuthor());
        existing.setGenre(newBook.getGenre());
        existing.setRead(newBook.isRead());
    }

}

