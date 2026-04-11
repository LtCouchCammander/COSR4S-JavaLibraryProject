import java.util.ArrayList;

public class Member {
    private String name;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public void addBorrowedBooks(Book bookToBorrow) {
        borrowedBooks.add(bookToBorrow);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}