public class Loan {
    private final Book book;
    private final Member member;
    private int daysBorrowed;

    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.daysBorrowed = 0;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public int getDaysBorrowed() {
        return daysBorrowed;
    }

    public void incrementDaysBorrowed() {
        daysBorrowed++;
    }
}

