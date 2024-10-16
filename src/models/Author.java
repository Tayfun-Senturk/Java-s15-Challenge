package models;

import java.util.List;
import java.util.ArrayList;

public class Author extends Person {
    private List<Book> books;

    public Author(String name) {
        super(name);
        this.books = new ArrayList<>();
    }

    public void newBook(Book book) {
        books.add(book);
    }

    public void showBook() {
        for (Book book : books) {
            book.display();
        }
    }

    @Override
    public void whoyouare() {
        System.out.println("I am Author: " + this.name);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public boolean equalsIgnoreCase(String author) {
        return this.name.equalsIgnoreCase(author);
    }
}
