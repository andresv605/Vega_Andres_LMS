package cen3024c;
/**
 * Andres Vega
 * CEN 3024 - Software Development 1
 * October 6, 2024
 * LibraryManagementSystem.java
 * This class contains the main method. It processes adding/removing books, loads books from the file,
 * processes checking out/checking in books, and prints the collection after each step is completed.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class LibraryManagementSystem {
    /**
     * method: main
     * parameters: none
     * return: n/a
     * purpose: Prints each possible operation for the user and processes the request
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        //ask user for file name and loads book info from the file
        System.out.print("Enter the file name containing the book information: ");
        String fileName = scanner.nextLine();
        loadBooksFromFile(library, fileName);

        //print book collection
        library.printBooks();

        //remove book using ID
        System.out.print("\nDo you want to remove a book by ID? (Yes/No): ");
        String removeByIdOption = scanner.nextLine();
        if (removeByIdOption.equalsIgnoreCase("Yes")) {
            System.out.print("Enter a book ID to remove: ");
            int bookId = scanner.nextInt();
            scanner.nextLine();
            if (library.removeBookById(bookId)) {
                System.out.println("The book with the ID " + bookId + " has been removed.");
            } else {
                System.out.println("The book with the ID " + bookId + " does not exist.");
            }
            library.printBooks();
        }

        //remove book using title
        System.out.print("\nDo you want to remove a book by title? (Yes/No): ");
        String removeByTitle = scanner.nextLine();
        if (removeByTitle.equalsIgnoreCase("Yes")) {
            System.out.print("Enter a book title to remove: ");
            String bookTitle = scanner.nextLine();
            if (library.removeBookByTitle(bookTitle)) {
                System.out.println("The book with the title " + bookTitle + " has been removed.");
            } else {
                System.out.println("The book with the title " + bookTitle + " does not exist.");
            }
            library.printBooks();
        }

        //check out book with book title
        System.out.print("\nDo you want to check out a book? (Yes/No): ");
        String checkOutOption = scanner.nextLine();
        if (checkOutOption.equalsIgnoreCase("Yes")) {
            System.out.print("Enter a book title to check out: ");
            String checkOutTitle = scanner.nextLine();
            if (library.checkOutBook(checkOutTitle)) {
                System.out.println("The book with the title " + checkOutTitle + "' has been checked out.");
            } else {
                System.out.println("The book with the title " + checkOutTitle + " is unavailable.");
            }
            library.printBooks();
        }

        //check in book with book title
        System.out.print("\nDo you want to check in a book? (Yes/No): ");
        String checkInOption = scanner.nextLine();
        if (checkInOption.equalsIgnoreCase("Yes")) {
            System.out.print("Enter a book title to check in: ");
            String checkInTitle = scanner.nextLine();
            if (library.checkInBook(checkInTitle)) {
                System.out.println("The book with the title " + checkInTitle + " has been checked in.");
            } else {
                System.out.println("The book with the title " + checkInTitle + " was not checked out.");
            }
            library.printBooks();
        }

        scanner.close();
    }

    /**
     * method: loadBooksFromFile
     * parameters: Library, String fileName
     * return: n/a
     * purpose: Reads file and adds book to the library collection
     */
    private static void loadBooksFromFile(Library library, String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] bookData = line.split(",");
                int id = Integer.parseInt(bookData[0]);
                String title = bookData[1];
                String author = bookData[2];
                library.addBook(new Book(id, title, author));
            }
            System.out.println("Books have been added from the file.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());

        }

    }

}
