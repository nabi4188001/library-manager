public class Book extends Media {
    private String genre;
    private boolean isRead;

    public Book() {
        super("", "");
    }

    public Book(String title, String author, String genre, boolean isRead) {
        super(title, author);
        this.genre = genre;
        this.isRead = isRead;
    }

    // Getters and setters
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public boolean isRead() { return isRead; }
    public void setRead(boolean read) { isRead = read; }

    @Override
    public String toString() {
        return String.format("%s by %s (%s) - %s",
                getTitle(), getAuthor(), genre, isRead ? "Read" : "Unread");
    }
}