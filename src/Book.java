public class Book {
    // declares variable types
    // Two attributes: Title name and if the book is available or not
    private final String title;
    private boolean isAvailable;

    public Book(String title) {
        this.title = title;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailableFalse() {
        isAvailable = false;
    }

    public void setIsAvailableTrue() {
        isAvailable = true;
    }

    public String getTitle() {
        return title;
    }
}

