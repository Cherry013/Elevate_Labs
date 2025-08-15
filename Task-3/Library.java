import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Users> users = new ArrayList<>();
    private Map<Integer, Integer> issuedBooks = new HashMap<>(); // BookID -> UserID

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(Users user) {
        users.add(user);
    }

    public void showBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void showUsers() {
        for (Users u : users) {
            System.out.println(u);
        }
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        Users us = findUser(userId);

        if (book != null && us != null && book.isAvailable()) {
            book.setAvailable(false);
            issuedBooks.put(bookId, userId);
            System.out.println("Book issued to " + us.getName());
        } else {
            System.out.println("Book not available or invalid ID.");
        }
    }

    public void returnBook(int bookId) {
        Book book = findBook(bookId);

        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            issuedBooks.remove(bookId);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Invalid book ID or book was not issued.");
        }
    }

    private Book findBook(int bookId) {
        for (Book b : books) {
            if (b.getId() == bookId) return b;
        }
        return null;
    }

    private Users findUser(int userId) {
        for (Users u : users) {
            if (u.getId() == userId) return u;
        }
        return null;
    }
}