import java.util.ArrayList;
import java.util.Scanner;

class Book {

    int id;
    String title;
    String author;
    String category;
    boolean isIssued;

    Book(int id, String title, String author, String category) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isIssued = false;
    }

    void displayBook() {

        System.out.println(
            "ID: " + id +
            " | Title: " + title +
            " | Author: " + author +
            " | Category: " + category +
            " | Status: " + (isIssued ? "Issued" : "Available")
        );
    }
}

public class Main {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addBook() {

        sc.nextLine();

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        System.out.print("Enter Book Category: ");
        String category = sc.nextLine();

        books.add(new Book(id, title, author, category));

        System.out.println("Book Added Successfully!");
    }

    public static void viewBooks() {

        if (books.isEmpty()) {

            System.out.println("No Books Available.");
            return;
        }

        System.out.println("\n===== BOOK LIST =====");

        for (Book b : books) {

            b.displayBook();
        }

        System.out.println("\nTotal Books Available: " + books.size());
    }

    public static void searchBook() {

        System.out.print("Enter Book ID to Search: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.id == id) {

                System.out.println("\nBook Found:");
                b.displayBook();
                return;
            }
        }

        System.out.println("Book Not Found.");
    }

    public static void issueBook() {

        System.out.print("Enter Book ID to Issue: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.id == id) {

                if (!b.isIssued) {

                    b.isIssued = true;

                    System.out.println("Book Issued Successfully!");

                } else {

                    System.out.println("Book is Already Issued.");
                }

                return;
            }
        }

        System.out.println("Book Not Found.");
    }

    public static void returnBook() {

        System.out.print("Enter Book ID to Return: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.id == id) {

                if (b.isIssued) {

                    b.isIssued = false;

                    System.out.println("Book Returned Successfully!");
                    System.out.println("Fine Amount: ₹0");

                } else {

                    System.out.println("Book was not Issued.");
                }

                return;
            }
        }

        System.out.println("Book Not Found.");
    }

    public static void deleteBook() {

        System.out.print("Enter Book ID to Delete: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.id == id) {

                books.remove(b);

                System.out.println("Book Deleted Successfully!");

                return;
            }
        }

        System.out.println("Book Not Found.");
    }

    public static void main(String[] args) {

        int choice;

        /* Preloaded Dataset */

        books.add(new Book(101, "Harry Potter", "J.K. Rowling", "Fantasy"));
        books.add(new Book(102, "Atomic Habits", "James Clear", "Self-help"));
        books.add(new Book(103, "The Alchemist", "Paulo Coelho", "Fiction"));
        books.add(new Book(104, "Rich Dad Poor Dad", "Robert Kiyosaki", "Finance"));
        books.add(new Book(105, "Ikigai", "Hector Garcia", "Motivation"));

        do {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");

            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    issueBook();
                    break;

                case 5:
                    returnBook();
                    break;

                case 6:
                    deleteBook();
                    break;

                case 7:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 7);
    }
}

