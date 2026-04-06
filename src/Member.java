import java.util.ArrayList;

public class Member {

    String name;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }
}