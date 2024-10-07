package cen3024c;
/**
 * Andres Vega
 * CEN 3024 - Software Development 1
 * October 6, 2024
 * Book.java
 * This class represents each book individually in the collection.
 */

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isCheckedOut;

    //constructor
    public Book(int id, String title, String author) {
        this.id = id;
        this. title = title;
        this.author = author;
        this.isCheckedOut = false;
    }

    //getters
    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public boolean isCheckedOut(){ return isCheckedOut; }

    //methods to check out/check in book
    public void checkOut(){
        isCheckedOut = true;
    }

    public void checkIn(){
        isCheckedOut = false;
    }


    //format book information
    public String toString(){
        String status = isCheckedOut ? "Checked Out" : "Available";
        return String.format("ID: %d, Title: %s, Author: %s, Status: %s", id, title, author, status);
    }
}

