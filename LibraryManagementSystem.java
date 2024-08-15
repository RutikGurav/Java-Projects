import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    library.add(new Book(id, title, author));
                    System.out.println("Book added successfully!\n");
                    break;

                case 2:
                    System.out.println("\nBooks in Library:");
                    for (Book book : library) {
                        System.out.println("ID: " + book.id + ", Title: " + book.title + ", Author: " + book.author);
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchId = scanner.nextInt();
                    Book foundBook = null;
                    for (Book book : library) {
                        if (book.id == searchId) {
                            foundBook = book;
                            break;
                        }
                    }
                    if (foundBook != null) {
                        System.out.println("Book Found - ID: " + foundBook.id + ", Title: " + foundBook.title + ", Author: " + foundBook.author);
                    } else {
                        System.out.println("Book not found.\n");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to delete: ");
                    int deleteId = scanner.nextInt();
                    Book bookToDelete = null;
                    for (Book book : library) {
                        if (book.id == deleteId) {
                            bookToDelete = book;
                            break;
                        }
                    }
                    if (bookToDelete != null) {
                        library.remove(bookToDelete);
                        System.out.println("Book deleted successfully!\n");
                    } else {
                        System.out.println("Book not found.\n");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the Library Management System.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.\n");
            }
        }
    }
}
