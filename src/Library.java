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
        int currentDay; // Current simulation day
        private ArrayList<Book> books = new ArrayList<>();
        private ArrayList<Member> members = new ArrayList<>();
        private ArrayList<Loan> loans = new ArrayList<>();

        public Library() {
            // Hard-coded books in the library
            books.add(new Book("War and Peace"));
            books.add(new Book("Crime and Punishment"));
            books.add(new Book("The Master and Margarita"));
            books.add(new Book("One Day in the Life of Ivan Denisovich"));
            books.add(new Book("Dead Souls"));
            books.add(new Book("The Brothers Karamazov"));
            books.add(new Book("Notes from Underground"));
            books.add(new Book("Fathers and Sons"));
            books.add(new Book("The Overcoat"));
            books.add(new Book("A Month in the Country"));
            books.add(new Book("The Red Wheel"));
            books.add(new Book("Oblomov"));
         

            // Hard-coded members of the library
            members.add(new Member("Ivan Petrov"));
            members.add(new Member("Anastasia Ivanova"));
            members.add(new Member("Sergi Kuznetsov"));
            members.add(new Member("Alexei smirnov"));
            members.add(new Member("Nikolai Volkov"));
            members.add(new Member("Ekaterina Petrova"));
            members.add(new Member("Olga Sokolova"));
            members.add(new Member("Vladimir Morozov"));
            members.add(new Member("Yuri Lebedev"));
            members.add(new Member("Tatiana Orlova"));
        }




// This is the Ai behavior code
public void simulateAction() {

    int action = Rand.randomInt(0, 2); // 0 or 1

    Member member = members.get(Rand.randomInt(0, members.size()));

    if (action == 0) {
        // Borrow book
        Book book = books.get(Rand.randomInt(0, books.size()));

        if (book.isAvailable()) {
            book.borrowBook();
            member.borrow(book);

            loans.add(new Loan(book, member));

            System.out.println(member.getName() + " borrowed - " + book.getTitle());
        }

    } else {
        // Return book (if they have one)
        if (!member.getBorrowedBooks().isEmpty()) {
            Book book = member.getBorrowedBooks().get(0);

            book.returnBook();
            member.returnBook(book);

            System.out.println(member.getName() + " returned - " + book.getTitle());
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