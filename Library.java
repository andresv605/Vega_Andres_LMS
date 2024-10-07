package cen3024c;
/**
 * Andres Vega
 * CEN 3024 - Software Development 1
 * October 6, 2024
 * Library.java
 * This class manages the collection adding books from a file, removing books, and listing the books.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {
    private List<Book> books;

    //constructor
    public Library(){
        books = new ArrayList<>();
    }

    /**
     * method: addBooksFromFile
     * parameters: String filename
     * return: n/a
     * purpose: Reads text file and adds book to the collection
     */
    public void addBook(Book book){
        books.add(book);
    }
    /**
     * method: removeBook
     * parameters: int id
     * return: n/a
     * purpose: Removes book with matching ID
     */
    public boolean removeBookById(int id){
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean removeBookByTitle(String title){
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                return true;

            }
        }
        return false;
    }

    //check out book by title
    public boolean checkOutBook(String title){
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title.trim()) && !book.isCheckedOut()) {
                book.checkOut();
                return true;
            }
        }
        return false;
    }

    //check in book by title
    public boolean checkInBook(String title){
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title.trim()) && book.isCheckedOut()) {
                book.checkIn();
                return true;
            }
        }
        return false;
    }


    /**
     * method: listBooks
     * parameters: none
     * return: n/a
     * purpose: Lists books in the collection
     */
    public void printBooks(){
        if(books.isEmpty()){
            System.out.println("There are no books in the library.");
        } else{
            System.out.println("The books in the library are: ");
            for (Book book : books){
                System.out.println(book);
            }
        }
    }
}
