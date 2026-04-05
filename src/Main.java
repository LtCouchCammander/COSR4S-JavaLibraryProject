public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        while (true) {

            // Advance time
            lib.currentDay = lib.currentDay + 1;
            System.out.println("\n--- Day " + lib.currentDay + " ---");

//-----------------------------------------------------------------------------------------------------

            // AI Simulation

            for (Loan value : lib.loans) {
                value.daysBorrowed++;
            }

            int action = Rand.randomInt(0, 2); // 0 or 1
            Member memberVariable = lib.members.get(Rand.randomInt(0, lib.members.size()));
            if (action == 0) {
                // Borrow book
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



            /*
            // simulate a random event
            int randomNumber = Rand.randomInt(0, 4); // could generate 0, 1, 2, or 3

            switch (randomNumber) {
                case 0 -> lib.report0();
                case 1 -> lib.report1();
                case 2 -> lib.report2();
                case 3 -> lib.report3();
            }
            lib.report();
             */
// Input.waitForUserToPressEnter("Press Enter to simulate the next day.");
