package models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Reader extends Person {
    private List<Book> borrowedBooks;

    public Reader(String name) {
        super(name);
        this.borrowedBooks = new ArrayList<>();
    }

    public void purchaseBook(Book book) {
        System.out.println("I purchased the " + book.getTitle()+" for "+book.getPrice()+"$");
    }

    public void borrowBook(Book book) {
        if (book.getStatus()) {
            System.out.println("I am "+this.name+" and i borrowed: " + book.getTitle()+" and paid the deposit of "+(0.3*book.getPrice())+"$");
            borrowedBooks.add(book);
            book.updateStatus(false);
        } else {
            System.out.println("Book is currently not available.");
        }
    }

    public void returnBook(Book book,double fee) {
        if (borrowedBooks.remove(book)) {
            book.updateStatus(true);
            double deposit = Math.round(0.3*book.getPrice());
            if(fee>(book.getPrice()*0.3)) {
                System.out.println("I am "+this.name+" and i paid extra "+(fee-deposit+"$"));
            }else {
                System.out.println("I am "+this.name+" and i got a refund of "+(deposit-fee)+"$");
            }
        }
    }


    @Override
    public void whoyouare() {
        System.out.println("I am Reader: " + this.name);
    }

    public String getName() {
        return this.name;
    }
}
