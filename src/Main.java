public class Main {
    public static void main(String[] args) {

        Library lib = new Library();
        while (true) {

            // Advance time
            lib.currentDay = lib.currentDay + 1;
            System.out.println("\n--- Day " + lib.currentDay + " ---");

            // Simulate AI code here
            lib.simulateAction();


            // Show current state of lib code here
            lib.displayStatus();


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
