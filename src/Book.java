/**
 * Represents a book in the library. Inherits from Media.
 */

public class Book extends Media {
    private String genre;
    private boolean isRead;

    /**
     * Default constructor.
     */
    public Book() {
        super("", "");
    }

    /**
     * Constructor to initialize a Book with the specified title, author, genre, and read status.
     *
     * @param title The title of the book.
     * @param author The author of the book.
     * @param genre The genre of the book.
     * @param isRead Whether the book has been read.
     */

    public Book(String title, String author, String genre, boolean isRead) {
        super(title, author);
        this.genre = genre;
        this.isRead = isRead;
    }

    /**
     * Gets the genre of the book.
     *
     * @return The genre of the book.
     */

    public String getGenre() { return genre; }

    /**
     * Sets the genre of the book.
     *
     * @param genre The genre of the book.
     */

    public void setGenre(String genre) { this.genre = genre; }

    /**
     * Gets whether the book has been read.
     *
     * @return True if the book has been read, false otherwise.
     */
    public boolean isRead() { return isRead; }

    /**
     * Sets whether the book has been read.
     *
     * @param read The read status of the book.
     */
    public void setRead(boolean read) { isRead = read; }

    /**
     * Returns a string representation of the book.
     *
     * @return A string representing the book with title, author, genre, and read status.
     */
    @Override
    public String toString() {
        return String.format("%s by %s (%s) - %s",
                getTitle(), getAuthor(), genre, isRead ? "Read" : "Unread");
    }
}