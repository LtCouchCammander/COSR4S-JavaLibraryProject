public class Loan {
    Book book;
    Member member;
    int daysBorrowed;

    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.daysBorrowed = 0;
    }
}

