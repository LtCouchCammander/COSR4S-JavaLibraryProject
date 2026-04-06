// library core
import java.util.ArrayList;

public class Library {
    int currentDay; // Current simulation day
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();
    ArrayList<Loan> loans = new ArrayList<>();

    // Adds members and books into arrays
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
}