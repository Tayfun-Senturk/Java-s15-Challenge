package models;

import java.time.LocalDate;
import java.util.Date;

public class StudyBooks extends Book {
    public StudyBooks(String bookID, Author author, String name, double price, String edition, LocalDate dateOfPurchase) {
        super(bookID, author, name, price, edition, dateOfPurchase);
    }

    @Override
    public void display() {
        String issuedTo = getStatus() ? "available" : "issued to someone";
        System.out.println("Study Book "+getBookID()+": " + this.getTitle() + " by " + this.getAuthor() + ", Edition: " + this.getEdition() + " |" + issuedTo+"|");
    }

    public void study() {
        System.out.println("Studying with book: " + this.getTitle());
    }
}
