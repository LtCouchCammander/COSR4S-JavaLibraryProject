import java.util.ArrayList;

public class Employees {
    public ArrayList<String> employees = new ArrayList<>();
    public Employees() {
        employees.add("Ivan Yegorov");
        employees.add("Dmitri Petrov");
        employees.add("Sergei Kuznetsov");
        employees.add("Anasatsia Ivanova");
        employees.add("Tatiana Volkova");
        employees.add("Ekaterina Smirnov");
    }

   public String checkLateEmployee(ArrayList<String> employees) {

        // Safe guard for empty list
       if (employees.size() == 0) {
           return null;
       }

       int chance = Rand.randomInt(1, 10);

       if (chance != 1) {
           return null;
       }

       int index = Rand.randomInt(0, employees.size() - 1);

       String lateEmployee = employees.get(index);

       return lateEmployee;
   }
}