//Represents the entire library system
class Library {

    int currentDay; // Current simulation day

    // add more fields here
    // add constructor(s) here

    public void printReportHeader() {
        System.out.println("""
                OFFICIAL
                END OF DAY DIRECTORATE REPORT.
                
                Department of State Records and Archives
                CLASSIFICATION: TOP SECRET
                
                summary
                employee status (at work on time, slacking off, doing good work, etc
                employee comments (Personal comments regarding different things
                
                number of members and their names + fines owing
                
                books on shelf
                books borrowed
                books missing - borrower
                
                archives in storage
                missing archives - classification type
                
                """);
    }

    // Just a normal day
    public void report0() {
        printReportHeader();
        System.out.println("""
                SUMMARY:
                All staff clocked in on time and worked dutifully throughout the day. 
                Staff note nothing of significance occured and operations continue as normal.
                
                EMPLOYEE STATUS:
                %s
                
                """);
    }

    public void report1() {

    }

    public void report2() {

    }

    public void report3() {

    }


}