// Disclaimer
//
// We originally planned on doing a cool USSR Cold War themed library but
// bit off way more than we could chew and ended up with just a goofy
// russian themed library.

// Ai was used to help understand how the fields stored in other files are used and called upon in the
// main file and other similar concepts.


public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        while (true) {

            // Advance time
            lib.currentDay = lib.currentDay + 1;
            System.out.println("\n--- Day " + lib.currentDay + " ---");

//-----------------------------------------------------------------------------------------------------

            // AI Simulation
            // This section of code simulates the actions of library members in regards too
            // borrowing and returning books, along with loans.

            for (Loan value : lib.loans) {
                value.daysBorrowed++;
            }

            int action = Rand.randomInt(0, 2); // 0 or 1
            Member memberVariable = lib.members.get(Rand.randomInt(0, lib.members.size()));

            if (action == 0) {
                // Borrow a book
                Book bookVariable = lib.books.get(Rand.randomInt(0, lib.books.size()));
                // gets book

                if (bookVariable.isAvailable) {
                    // sets book to borrowed
                    bookVariable.isAvailable = false;
                    // adds borrowed book under member who borrowed it
                    memberVariable.borrowedBooks.add(bookVariable);

                    lib.loans.add(new Loan(bookVariable, memberVariable));

                    System.out.println(memberVariable.name + " borrowed - " + bookVariable.title);
                }
            }

            // Return book (if they have one)
            else {
                if (!memberVariable.borrowedBooks.isEmpty()) {
                    Book bookToReturn = memberVariable.borrowedBooks.get(0);

                    bookToReturn.isAvailable = true;
                    memberVariable.borrowedBooks.remove(bookToReturn);

                    // REMOVE matching loan
                    Loan loanToRemove = null;

                    for (Loan loan : lib.loans) {
                        if (loan.book == bookToReturn && loan.member == memberVariable) {
                            loanToRemove = loan;
                            break;
                        }
                    }

                    if (loanToRemove != null) {
                        lib.loans.remove(loanToRemove);
                    }

                    System.out.println(memberVariable.name + " returned - " + bookToReturn.title);
                }
            }

//-----------------------------------------------------------------------------------------------------

            // Display Library Status
            // Print the list of books and weather or not they are available to be borrowed.
            System.out.println("\n--- Library Status ---");

            for (Book b : lib.books) {
                System.out.println(b.title + " | Available: " + b.isAvailable);
            }

            System.out.println("\n--- Active Loans ---");

            for (Loan loan : lib.loans) {
                System.out.println(
                        loan.member.name + " has \"" +
                                loan.book.title + "\" for " +
                                loan.daysBorrowed + " days"

                );

                float over20Days = (float) loan.daysBorrowed / 20;
                if (over20Days >= 1) {
                    float fineOwed = over20Days * 550;
                    System.out.println("Over Due Fines | ₽ Owed: " + fineOwed);
                }
            }
            System.out.println("----------------------\n");

            // Pause using provided Input class
            Input.waitForUserToPressEnter("Press Enter to simulate the next day.");
        }
    }
}