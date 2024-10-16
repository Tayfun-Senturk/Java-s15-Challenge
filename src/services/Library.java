package services;

import models.Book;
import models.Journals;
import models.MemberRecord;
import models.Reader;

import java.util.List;
import java.util.ArrayList;

public class Library {
    private List<Book> books;
    private List<MemberRecord> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void newBook(Book book) {
        books.add(book);
        System.out.println("New book added: " + book.getTitle());
    }


    public void newMember(MemberRecord member) {
        members.add(member);
        System.out.println("New member added: " + member.getMemberName());
    }

    public List<MemberRecord> getMembers() {
        return members;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void deleteBook(Book book) {
        books.remove(book);
    }


    public void updateBook(Book oldBook, Book newBook) {
        int index = books.indexOf(oldBook);
        if (index != -1) {
            books.set(index, newBook);
            System.out.println("Book updated: " + newBook.getTitle());
        } else {
            System.out.println("Book not found.");
        }
    }

    public void showBooks() {
        for (Book book : books) {
            book.display();
        }
    }

    public List<Book> getBooksByCategory(String category) {
        List<Book> categorizedBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getClass().getSimpleName().equals(category)) {
                categorizedBooks.add(book);
            }
        }
        return categorizedBooks;
    }

}
