import java.util.ArrayList;

public class Member {
    private final String name;
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public Book getFirstBorrowedBook() {
        return borrowedBooks.getFirst();
    }

    public void addBorrowedBooks(Book bookToBorrow) {
        borrowedBooks.add(bookToBorrow);
    }

    public void removeBorrowedBooks(Book bookToReturn) {
        borrowedBooks.remove(bookToReturn);
    }
}