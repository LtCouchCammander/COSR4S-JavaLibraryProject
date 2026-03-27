public class Loan {
        private Book book;
        private Member member;
        private int daysBorrowed;

        public Loan(Book book, Member member) {
            this.book = book;
            this.member = member;
            this.daysBorrowed = 0;
        }

        public void incrementDays() {
            daysBorrowed++;
        }

        public int getDaysBorrowed() {
            return daysBorrowed;
        }

        public Book getBook() {
            return book;
        }

        public Member getMember() {
            return member;
        }
    }

