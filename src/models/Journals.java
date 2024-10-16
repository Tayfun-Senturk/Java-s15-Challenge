package models;

import java.time.LocalDate;
import java.util.Date;

public class Journals extends Book {
    public Journals(String bookID, Author author, String name, double price, String edition, LocalDate dateOfPurchase) {
        super(bookID, author, name, price, edition, dateOfPurchase);
    }

    @Override
    public void display() {
        String issuedTo = getStatus() ? "available" : "issued to someone";
        System.out.println("Journal "+getBookID()+": " + this.getTitle() + " by " + this.getAuthor() + ", Edition: " + this.getEdition() + " |" + issuedTo+"|");
    }

    public void research() {
        System.out.println("Researching with journal: " + this.getTitle());
    }
}

