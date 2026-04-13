import java.util.ArrayList;

public class Library {
    // Intellij recommended some of the fields be final. I believe this prevents them from being reassigned after being instantiated
    private int currentDay; // Current simulation day
    private final ArrayList<Book> books = new ArrayList<>();
    private final ArrayList<Member> members = new ArrayList<>();
    private final ArrayList<Loan> loans = new ArrayList<>();

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

    public void incrementCurrentDay() {
        currentDay++;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public Member getRandomMember() {
        return members.get(Rand.randomInt(0, members.size()));
    }

    public Book getRandomBook() {
        return books.get(Rand.randomInt(0, books.size()));
    }

    public void newLoan(Book bookToLoan, Member memberLoaning) {
        loans.add(new Loan(bookToLoan, memberLoaning));
    }

    public void removeLoan(Book bookToReturn, Member chosenMember) {
        // Intellij recommend a remove if statement. Was using for loop before...
        loans.removeIf(removeLoan -> removeLoan.getBook() == bookToReturn && removeLoan.getMember() == chosenMember);
        /*
        for (Loan removeLoan : lib.loans) {
            if (removeLoan.book == bookToReturn && removeLoan.member == chosenMember) {
                lib.loans.remove(removeLoan);
            }
        }*/
    }
}