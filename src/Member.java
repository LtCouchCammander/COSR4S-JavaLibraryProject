import java.util.ArrayList;

public class Member {

    String name;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }


    // ______________________________________________________
/*
    public String getName() {
        return name;
    }

    public void borrow(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

 */
}
