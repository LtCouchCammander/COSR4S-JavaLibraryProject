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
            lib.incrementCurrentDay();
            System.out.println("\n--- Day " + lib.getCurrentDay() + " ---");

//-----------------------------------------------------------------------------------------------------
            // AI Simulation
            // This section of code simulates the actions of library members in regards too
            // borrowing and returning books, along with loans.

            // Enhanced for loop goes through each loan in the array and adds 1 to the daysBorrowed variable
            for (Loan borrowedLoan : lib.getLoans()) {
                borrowedLoan.incrementDaysBorrowed();
            }

            // Uses Rand methods to decide on if an action is taken and which patron does so
            int action = Rand.randomInt(0, 2); // 0 or 1
            Member chosenMember = lib.getRandomMember(); // I got rid of all the gets to make it more readable. Also did this for a couple other lines below. Used to be lib.getMembers().get(Rand.randomInt(0, lib.getMembers().size()));

            // Borrow a book
            if (action == 0) {
                Book chosenBook = lib.getRandomBook(); // Chooses random book

                if (chosenBook.isAvailable()) {
                    chosenBook.setIsAvailableFalse(); // Sets book to borrowed
                    chosenMember.addBorrowedBooks(chosenBook);// Adds borrowed book under member who borrowed it
                    lib.newLoan(chosenBook, chosenMember); // Creates a new loan for the respective book and member
                    System.out.println(chosenMember.getName() + " borrowed - " + chosenBook.getTitle());
                }
            }

            // Return book (if they have one)
            else {

                // Checks to see if the member has any borrowed books
                if (!chosenMember.getBorrowedBooks().isEmpty()) {

                    Book bookToReturn = chosenMember.getFirstBorrowedBook(); // Gets the first book to return in the members array
                    bookToReturn.setIsAvailableTrue(); // Sets the books availability to true and removes it form the borrowed books array
                    chosenMember.removeBorrowedBooks(bookToReturn); // Removes members borrowed books from its array
                    lib.removeLoan(bookToReturn, chosenMember); // Removes the loan from the loans array
                    System.out.println(chosenMember.getName() + " returned - " + bookToReturn.getTitle());
                }
            }

//-----------------------------------------------------------------------------------------------------
            // Display Library Status
            // Print the list of books and weather or not they are available to be borrowed.
            System.out.println("\n--- Library Status ---");

            // Shows books and their availability status
            for (Book currentBook : lib.getBooks()) {
                System.out.println(currentBook.getTitle() + " | Available: " + currentBook.isAvailable());
            }

            System.out.println("\n--- Active Loans ---");

            // Shows members active loans and information
            for (Loan loan : lib.getLoans()) {
                System.out.println(
                        loan.getMember().getName() + " has \"" +
                                loan.getBook().getTitle() + "\" for " +
                                loan.getDaysBorrowed() + " days"

                );

                // Calculates the fees for books borrowed over 20 days
                float over20Days = (float) loan.getDaysBorrowed() / 20;
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