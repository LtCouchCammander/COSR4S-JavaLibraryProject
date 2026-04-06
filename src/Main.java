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

            // Enhanced for loop goes through each loan in the array and adds 1 to the daysBorrowed variable
            for (Loan borrowedLoan : lib.loans) {
                borrowedLoan.daysBorrowed++;
            }

            // Uses Rand methods to decide on if an action is taken and which patron does so
            int action = Rand.randomInt(0, 2); // 0 or 1
            Member chosenMember = lib.members.get(Rand.randomInt(0, lib.members.size()));

            // Borrow a book
            if (action == 0) {
                // Chooses random book
                Book choosenBook = lib.books.get(Rand.randomInt(0, lib.books.size()));

                if (choosenBook.isAvailable) {
                    // Sets book to borrowed
                    choosenBook.isAvailable = false;
                    // Adds borrowed book under member who borrowed it
                    chosenMember.borrowedBooks.add(choosenBook);

                    lib.loans.add(new Loan(choosenBook, chosenMember));

                    System.out.println(chosenMember.name + " borrowed - " + choosenBook.title);
                }
            }

            // Return book (if they have one)
            else {
                if (!chosenMember.borrowedBooks.isEmpty()) {
                    Book bookToReturn = chosenMember.borrowedBooks.getFirst();

                    bookToReturn.isAvailable = true;
                    chosenMember.borrowedBooks.remove(bookToReturn);

                    // Intellij recommened a remove if statement. Was using for loop before...
                    lib.loans.removeIf(removeLoan -> removeLoan.book == bookToReturn && removeLoan.member == chosenMember);
                    /*
                    for (Loan removeLoan : lib.loans) {
                        if (removeLoan.book == bookToReturn && removeLoan.member == chosenMember) {
                            lib.loans.remove(removeLoan);
                        }
                    }*/

                    System.out.println(chosenMember.name + " returned - " + bookToReturn.title);
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