package models;


import java.time.LocalDate;
import java.util.Date;

public class Magazines extends Book {
    public Magazines(String bookID, Author author, String name, double price, String edition, LocalDate dateOfPurchase) {
        super(bookID, author, name, price, edition, dateOfPurchase);
        author.newBook(this);
    }

    @Override
    public void display() {
        String issuedTo = getStatus() ? "available" : "issued to someone";
        System.out.println("Magazine "+getBookID()+": " + this.getTitle() + " by " + this.getAuthor() + ", Edition: " + this.getEdition() + " |" + issuedTo+"|");
    }

    public void use() {
        System.out.println("Enjoying entertainment with magazine: " + this.getTitle());
    }
}
