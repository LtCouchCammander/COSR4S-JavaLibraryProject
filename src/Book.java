import java.util.ArrayList;

public class Book {

        // declares variable types
        // Two attributes: Title name and if the book is available or not
        private String title;
        private boolean isAvailable;

        public Book(String title) {
            this.title = title;
            this.isAvailable = true;
        }

        public String getTitle() {
            return title;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public void borrowBook() {
            isAvailable = false;
        }

        public void returnBook() {
            isAvailable = true;
        }
    }

