import java.util.ArrayList;
import java.util.Scanner;

// --------------------- Book Class ---------------------
class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public void issue() { isIssued = true; }
    public void returnBook() { isIssued = false; }

    @Override
    public String toString() {
        return id + " - " + title + " by " + author + 
               (isIssued ? " [Issued]" : " [Available]");
    }
}

// --------------------- User Class ---------------------
class User {
    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return userId + " - " + name;
    }
}

// --------------------- Library Class ---------------------
class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) { books.add(book); }
    public void addUser(User user) { users.add(user); }

    public Book findBook(int bookId) {
        for (Book b : books) if (b.getId() == bookId) return b;
        return null;
    }

    public User findUser(int userId) {
        for (User u : users) if (u.getUserId() == userId) return u;
        return null;
    }

    public void issueBook(int bookId, int userId) {
        Book b = findBook(bookId);
        User u = findUser(userId);

        if (b == null) {
            System.out.println("Book not found!");
            return;
        }
        if (u == null) {
            System.out.println("User not found!");
            return;
        }
        if (b.isIssued()) {
            System.out.println("Book is already issued!");
            return;
        }

        b.issue();
        System.out.println("Book \"" + b.getTitle() + "\" issued to " + u.getName());
    }

    public void returnBook(int bookId) {
        Book b = findBook(bookId);

        if (b == null) {
            System.out.println("Book not found!");
            return;
        }
        if (!b.isIssued()) {
            System.out.println("Book is not issued!");
            return;
        }

        b.returnBook();
        System.out.println("Book \"" + b.getTitle() + "\" returned successfully.");
    }

    public void showBooks() {
        System.out.println("\n--- Book List ---");
        for (Book b : books) System.out.println(b);
    }
}

// --------------------- Main Class (Driver Code) ---------------------
public class LibraryManagementSystem {
    public static void main(String[] args) {

        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        // Sample data
        lib.addBook(new Book(1, "The Alchemist", "Paulo Coelho"));
        lib.addBook(new Book(2, "1984", "George Orwell"));
        lib.addBook(new Book(3, "Clean Code", "Robert C. Martin"));

        lib.addUser(new User(101, "Alice"));
        lib.addUser(new User(102, "Bob"));

        int choice;

        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Show Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    lib.showBooks();
                    break;

                case 2:
                    System.out.print("Enter Book ID: ");
                    int bookIdIssue = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    lib.issueBook(bookIdIssue, userId);
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    int bookIdReturn = sc.nextInt();
                    lib.returnBook(bookIdReturn);
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        sc.close();
    }
}
