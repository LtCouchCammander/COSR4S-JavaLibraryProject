/*import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

//Represents the entire library system
class Library {
    int currentDay; // Current simulation day

    Book[] books;
    Member[] members;

    public Library() {
        books = new Book[15];

    }


 */





// library core
import java.util.ArrayList;

    public class Library {
        private ArrayList<Book> books;
        private ArrayList<Member> members;
        private ArrayList<Loan> loans;

        public Library() {
            books = new ArrayList<>();
            members = new ArrayList<>();
            loans = new ArrayList<>();

            // Hard-coded books
            books.add(new Book("War and Peace"));
            books.add(new Book("Crime and Punishment"));
            books.add(new Book("The Master and Margarita"));

            // Hard-coded members
            members.add(new Member("Ivan"));
            members.add(new Member("Anastasia"));
        }





// This is the Ai behavior code
        public void simulateAction() {
            int action = (int)(Math.random() * 2);

            Member member = members.get((int)(Math.random() * members.size()));

            if (action == 0) {
                // Borrow book
                Book book = books.get((int)(Math.random() * books.size()));

                if (book.isAvailable()) {
                    book.borrowBook();
                    member.borrow(book);

                    loans.add(new Loan(book, member));

                    System.out.println(member.getName() + " borrowed " + book.getTitle());
                }

            } else {
                // Return book (if they have one)
                if (!member.getBorrowedBooks().isEmpty()) {
                    Book book = member.getBorrowedBooks().get(0);

                    book.returnBook();
                    member.returnBook(book);

                    System.out.println(member.getName() + " returned " + book.getTitle());
                }
            }
        }



// display the status of the library
        public void displayStatus() {
            System.out.println("\n--- Library Status ---");

            for (Book b : books) {
                System.out.println(b.getTitle() + " | Available: " + b.isAvailable());
            }

            System.out.println("----------------------\n");
        }



    //EmployeeDirectory emp = new EmployeeDirectory();
    // add more fields here
    // add constructor(s) here
    /*
    public void report() {

        String latePerson = emp.checkLateEmployee();
        System.out.println();
        System.out.print("""
                OFFICIAL
                END OF DAY DIRECTORATE REPORT.

                Department of State Records and Archives
                CLASSIFICATION: TOP SECRET

                SUMMARY:
                """);
        if (latePerson == null) {
            System.out.println("All staff clocked in on time and worked dutifully throughout the day.");
        }
        else {
            System.out.println("One Staff member was late. This will reflect greatly on their record...");
        }
        System.out.print("""
                Staff note nothing of significance occured and operations continue as normal.

                EMPLOYEE STATUS:
                """);
        for (int i = 0; i < emp.employeeList.size(); i += 1) {
            System.out.print(emp.employeeList.get(i));
            if (Objects.equals(emp.employeeList.get(i), latePerson)) {
                System.out.println(": LATE");
            }
            else {
                System.out.println(": PRESENT");
            }
        }

        System.out.println("\nBOOK INVENTORY");
            /*
                COMMENTS:

                BOOK INVENTORY:
                BORROWED BOOKS:
                MISSING BOOKS:

                ARCHIVE INVENTORY
                MISSING ARCHIVES - CLASSIFICATION TYPE
                """);

    }
*/

}