import java.util.Objects;

//Represents the entire library system
class Library {
    EmployeeDirectory emp = new EmployeeDirectory();

    int currentDay; // Current simulation day
    // add more fields here
    // add constructor(s) here

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
                System.out.println();
            }
        }
            /*
                COMMENTS:

                BOOK INVENTORY:
                BORROWED BOOKS:
                MISSING BOOKS:

                ARCHIVE INVENTORY
                MISSING ARCHIVES - CLASSIFICATION TYPE
                """);

             */
    }


}