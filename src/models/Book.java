package models;

import java.time.LocalDate;
import java.util.Date;

public abstract class Book {
    private String bookID;
    private Author author;
    private String name;
    private double price;
    private boolean status;
    private String edition;
    private LocalDate dateOfPurchase;

    public Book(String bookID, Author author, String name, double price, String edition, LocalDate dateOfPurchase) {
        this.bookID = bookID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = true;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
    }


    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public String getEdition() {
        return edition;
    }


    public abstract void display();


    public void updateStatus(boolean newStatus) {
        this.status = newStatus;
    }


    public boolean getStatus() {
        return status;
    }

    public String getBookID() {
        return bookID;
    }
    public abstract void use();
}
