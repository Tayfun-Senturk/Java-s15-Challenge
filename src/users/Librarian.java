package users;

import models.*;
import services.Library;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Librarian extends Person {
    private String password;
    private Map<Book, MemberRecord> issuedBooks = new HashMap<>();
    private Map<Book, LocalDate> borrowDates = new HashMap<>();
    private Library library;
    DecimalFormat df = new DecimalFormat("#.0");

    public Librarian(String name, String password, Library library) {
        super(name);
        this.password = password;
        this.library = library;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return password;
    }

    public Map<Book, MemberRecord> getIssuedBooks() {
        return issuedBooks;
    }

    public Book searchBookByTitle(String title) {
        for (Book book : library.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.display();
                return book;
            }
        }

        System.out.println("Book not found.");
        return null;
    }

    public Book searchBookById(String id) {
        for (Book book : library.getBooks()) {
            if (book.getBookID().equalsIgnoreCase(id)) {
                book.display();
                return book;
            }
        }
        System.out.println("Book not found.");
        return null;
    }

    public List<Book> searchBookByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : library.getBooks()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                book.display();
                foundBooks.add(book);
            }
        }
        if (foundBooks.isEmpty()) {
            System.out.println("Book not found.");
            return null;
        } else {
            return foundBooks;
        }
    }

    public MemberRecord verifyMember(String name) {
        for (MemberRecord member : library.getMembers()) {
            if (member.getMemberName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }

    public void issueBook(Book book, MemberRecord reader, LocalDate date) {
        if (book.getStatus()) {
            issuedBooks.put(book, reader);
            System.out.println("Issued: " + book.getTitle() + " to " + reader.getMemberName());
            saveBorrowDate(book, date);
            createBill(book, reader);
        } else {
            System.out.println("Book is currently borrowed.");
        }
    }

    public void returnBook(Book book, MemberRecord reader, LocalDate date) {
        if (issuedBooks.containsKey(book) && issuedBooks.get(book).equals(reader)) {
            issuedBooks.remove(book);
            System.out.println(reader.getMemberName() + " Returned: " + book.getTitle());
            refundBill(book, reader, date);
        } else {
            System.out.println("Book is not issued to you.");
        }
    }

    public void showAllMembersAndBorrowedBooks() {
        for (MemberRecord member : library.getMembers()) {
            System.out.println("Member: " + member.getMemberName() + " has borrowed the following books:");
            for (Book book : issuedBooks.keySet()) {
                if (issuedBooks.get(book).equals(member)) {
                    book.display();
                }
            }
            System.out.println();
        }
    }

    public void createBill(Book book, MemberRecord member) {
        System.out.println("A deposit of " + df.format(0.3 * book.getPrice()) + "$ has been charged for the book \"" + book.getTitle() + "\" rented by " + member.getMemberName() + ". A daily fee of " + df.format(0.02 * book.getPrice()) + "$ will be charged for each day the book is borrowed. You will receive a full refund of the deposit upon returning the book. Thank you for choosing our library!");
    }

    public void refundBill(Book book, MemberRecord member, LocalDate returnDate) {
        long daysBorrowed = ChronoUnit.DAYS.between(borrowDates.get(book), returnDate);
        double borrowFee = Math.round(daysBorrowed * (book.getPrice() * 0.02));
        double deposit = Math.round((book.getPrice() * 0.3));
        if (borrowFee > deposit) {
            System.out.println("You have held the book titled " + book.getTitle() + " for " + daysBorrowed + " days. You must pay an additional fee of " + (borrowFee - deposit) + "$.");
        } else {
            System.out.println("You have held the book titled " + book.getTitle() + " for " + daysBorrowed + " days. Your deposit refund after deducting the borrowing fee is " + (deposit - borrowFee) + "$");
        }
        member.getReader().returnBook(book, borrowFee);
        member.payBill(deposit, borrowFee);
    }

    public void saveBorrowDate(Book book, LocalDate borrowDate) {
        borrowDates.put(book, borrowDate);
    }

    public void addMember(String Status, String memberId, String memberName, String memberAddress, String memberEmail) {
        if (Status.equalsIgnoreCase("Faculty")) {
            MemberRecord newMember = new Faculty(memberId, LocalDate.now(), memberName, memberAddress, memberEmail, new Reader(memberName));
            library.newMember(newMember);
        } else if (Status.equalsIgnoreCase("Student")) {
            MemberRecord newMember = new Student(memberId, LocalDate.now(), memberName, memberAddress, memberEmail, new Reader(memberName));
            library.newMember(newMember);
        }
    }

    @Override
    public void whoyouare() {
        System.out.println("I am Librarian: " + this.name);
    }
}
