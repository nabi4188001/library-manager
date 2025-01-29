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
    public void deleteBook(String title) throws BookNotFoundException {
        books.remove(getBookByTitle(title));
    }

    private Book getBookByTitle(String title) throws BookNotFoundException {
        return books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book not found: " + title));
    }

    @Override
    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .toList();
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .toList();
    }

    @Override
    public List<Book> searchByGenre(String genre) {
        return books.stream()
                .filter(b -> b.getGenre().equalsIgnoreCase(genre))
                .toList();
    }

    public List<Book> getBooks() {
        return books;
    }


    public Map<String, Integer> getReadingStats() {
        int read = (int) books.stream().filter(Book::isRead).count();
        return Map.of(
                "read", read,
                "unread", books.size() - read
        );
    }


}

