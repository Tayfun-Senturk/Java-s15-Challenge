package main;

import models.*;
import services.Library;
import users.Librarian;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        Librarian librarian = new Librarian("admin", "password", library);

        Map<String, Author> authors = new HashMap<>();

        authors.putIfAbsent("John", new Author("John"));
        authors.putIfAbsent("Linda", new Author("Linda"));
        authors.putIfAbsent("David", new Author("David"));
        authors.putIfAbsent("Sophia", new Author("Sophia"));
        authors.putIfAbsent("Michael", new Author("Michael"));
        authors.putIfAbsent("Emma", new Author("Emma"));
        authors.putIfAbsent("Henry", new Author("Henry"));
        authors.putIfAbsent("Oliver", new Author("Oliver"));
        authors.putIfAbsent("James", new Author("James"));
        authors.putIfAbsent("William", new Author("William"));

        Book book1 = new Journals("B01", authors.get("John"), "Mystery of Worlds", 100, "1st Edition", LocalDate.of(2018, 1, 3));
        Book book2 = new Magazines("B02", authors.get("John"), "Science Today", 50, "2nd Edition", LocalDate.of(2015, 5, 15));
        Book book3 = new StudyBooks("B03", authors.get("Linda"), "Physics Fundamentals", 75, "3rd Edition", LocalDate.of(2018, 2, 20));
        Book book4 = new Journals("B04", authors.get("Linda"), "Medical Research", 120, "1st Edition", LocalDate.of(2016, 10, 5));
        Book book5 = new Magazines("B05", authors.get("David"), "Fashion Trends", 30, "2nd Edition", LocalDate.of(2019, 8, 12));
        Book book6 = new StudyBooks("B06", authors.get("David"), "Organic Chemistry", 80, "4th Edition", LocalDate.of(2013, 3, 25));
        Book book7 = new Journals("B07", authors.get("Sophia"), "Fluid Dynamics", 110, "1st Edition", LocalDate.of(2020, 1, 15));
        Book book8 = new Magazines("B08", authors.get("Sophia"), "Car Magazine", 40, "3rd Edition", LocalDate.of(2014, 6, 10));
        Book book9 = new StudyBooks("B09", authors.get("Michael"), "Advanced Calculus", 70, "5th Edition", LocalDate.of(2011, 7, 30));
        Book book10 = new Journals("B10", authors.get("Michael"), "Life on Earth", 125, "1st Edition", LocalDate.of(2017, 4, 8));
        Book book11 = new Journals("B11", authors.get("Emma"), "Culinary Secrets", 130, "2nd Edition", LocalDate.of(2021, 9, 17));
        Book book12 = new StudyBooks("B12", authors.get("Emma"), "Quantum Mechanics", 150, "1st Edition", LocalDate.of(2010, 11, 3));
        Book book13 = new Magazines("B13", authors.get("Henry"), "Entertainment Weekly", 60, "1st Edition", LocalDate.of(2013, 7, 7));
        Book book14 = new StudyBooks("B14", authors.get("Henry"), "Engineering Thermodynamics", 90, "2nd Edition", LocalDate.of(2009, 5, 25));
        Book book15 = new Journals("B15", authors.get("Oliver"), "Medical Ethics", 140, "1st Edition", LocalDate.of(2014, 1, 29));
        Book book16 = new Magazines("B16", authors.get("Oliver"), "Automobile Trends", 45, "4th Edition", LocalDate.of(2018, 10, 1));
        Book book17 = new StudyBooks("B17", authors.get("James"), "Mathematical Theories", 80, "3rd Edition", LocalDate.of(2020, 3, 15));
        Book book18 = new Journals("B18", authors.get("James"), "Scientific Innovations", 115, "2nd Edition", LocalDate.of(2015, 7, 21));
        Book book19 = new Magazines("B19", authors.get("William"), "Physics Monthly", 60, "1st Edition", LocalDate.of(2016, 9, 10));
        Book book20 = new StudyBooks("B20", authors.get("William"), "Fluid Mechanics", 95, "1st Edition", LocalDate.of(2018, 12, 11));


        MemberRecord member1 = new Faculty("M01", LocalDate.now(), "Dr.Alex", "New Jersey", "alex@university.com", new Reader("Dr.Alex"));
        MemberRecord member2 = new Faculty("M02", LocalDate.now(), "Dr.Beth", "California", "beth@university.com", new Reader("Dr.Beth"));
        MemberRecord member3 = new Student("M03", LocalDate.now(), "Catherine", "Texas", "catherine@university.com", new Reader("Catherine"));
        MemberRecord member4 = new Student("M04", LocalDate.now(), "Derek", "Florida", "derek@university.com", new Reader("Derek"));

        library.newMember(member1);
        library.newMember(member2);
        library.newMember(member3);
        library.newMember(member4);

        library.newBook(book1);
        library.newBook(book2);
        library.newBook(book3);
        library.newBook(book4);
        library.newBook(book5);
        library.newBook(book6);
        library.newBook(book7);
        library.newBook(book8);
        library.newBook(book9);
        library.newBook(book10);
        library.newBook(book11);
        library.newBook(book12);
        library.newBook(book13);
        library.newBook(book14);
        library.newBook(book15);
        library.newBook(book16);
        library.newBook(book17);
        library.newBook(book18);
        library.newBook(book19);
        library.newBook(book20);

        book3.getAuthor().whoyouare();
        book4.getAuthor().showBook();

        book20.use();
        book19.use();
        book18.use();

        System.out.print("Enter your name: ");
        String enteredName = scanner.nextLine();
        System.out.println("Enter your password:");
        String enteredPassword = scanner.nextLine();
        if (librarian.getName().equalsIgnoreCase(enteredName) && librarian.getPassword().equalsIgnoreCase(enteredPassword)) {
            boolean running = true;

            while (running) {
                System.out.println("\n--- Library System Menu ---");
                System.out.println("1. Add new book");
                System.out.println("2. Select book");
                System.out.println("3. Show all books");
                System.out.println("4. Search by category");
                System.out.println("5. Search by author");
                System.out.println("6. Show all members and borrowed books");
                System.out.println("7. Add new member");
                System.out.println("8. Exit");
                System.out.print("Select an option: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("Enter the book type (1:Journals/2:Magazines/3:StudyBook): ");
                        String type = scanner.nextLine();
                        System.out.println("Enter bookID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.println("Enter edition: ");
                        String edition = scanner.nextLine();
                        System.out.print("Enter price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();

                        Book newBook;
                        if ("1".equalsIgnoreCase(type)) {
                            newBook = new Journals(id, new Author(author), title, price, edition, LocalDate.now());
                        } else if ("2".equalsIgnoreCase(type)) {
                            newBook = new Magazines(id, new Author(author), title, price, edition, LocalDate.now());
                        } else if ("3".equalsIgnoreCase(type)) {
                            newBook = new StudyBooks(id, new Author(author), title, price, edition, LocalDate.now());
                        } else {
                            System.out.println("Invalid book type.");
                            break;
                        }

                        library.newBook(newBook);
                        break;

                    case 2:
                        System.out.println("Search by (1: ID / 2: Name / 3: Author): ");
                        String searchType = scanner.nextLine();
                        String searchValue = "";

                        switch (searchType) {
                            case "1":
                                System.out.print("Enter book ID: ");
                                searchValue = scanner.nextLine();
                                Book foundBookById = librarian.searchBookById(searchValue);
                                if (foundBookById != null) {
                                    handleBookOptions(foundBookById, librarian, library);
                                }
                                break;
                            case "2":
                                System.out.print("Enter book name: ");
                                searchValue = scanner.nextLine();
                                Book foundBookByTitle = librarian.searchBookByTitle(searchValue);
                                if (foundBookByTitle != null) {
                                    handleBookOptions(foundBookByTitle, librarian, library);
                                }
                                break;
                            case "3":
                                System.out.print("Enter author name: ");
                                searchValue = scanner.nextLine();
                                List<Book> foundBooksByAuthor = librarian.searchBookByAuthor(searchValue);
                                if (foundBooksByAuthor != null && !foundBooksByAuthor.isEmpty()) {
                                    for (int i = 0; i < foundBooksByAuthor.size(); i++) {
                                        System.out.println((i + 1) + ". " + foundBooksByAuthor.get(i).getTitle());
                                    }

                                    System.out.print("Choose a book number: ");
                                    int bookChoice = scanner.nextInt();
                                    scanner.nextLine();

                                    if (bookChoice > 0 && bookChoice <= foundBooksByAuthor.size()) {
                                        handleBookOptions(foundBooksByAuthor.get(bookChoice - 1), librarian, library);
                                    } else {
                                        System.out.println("Invalid choice.");
                                    }
                                }
                                break;
                            default:
                                System.out.println("Invalid search type.");
                        }
                        break;


                    case 3:
                        library.showBooks();
                        break;

                    case 4:
                        System.out.println("Select category to list books (1: StudyBooks / 2: Magazines / 3: Journals): ");
                        String category = scanner.nextLine();
                        List<Book> booksByCategory = null;
                        switch (category) {
                            case "1":
                                booksByCategory = library.getBooksByCategory("StudyBooks");
                                break;
                            case "2":
                                booksByCategory = library.getBooksByCategory("Magazines");
                                break;
                            case "3":
                                booksByCategory = library.getBooksByCategory("Journals");
                                break;
                            default:
                                System.out.println("Invalid category.");
                                break;
                        }
                        if (booksByCategory != null) {
                            for (Book book : booksByCategory) {
                                book.display();
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Enter author name: ");
                        String authorName = scanner.nextLine();
                        librarian.searchBookByAuthor(authorName);
                        break;
                    case 6:
                        librarian.showAllMembersAndBorrowedBooks();
                        break;
                    case 7:
                        System.out.println("Enter the member type (1: Faculty/2: Student): ");
                        String memberType = scanner.nextLine();
                        System.out.print("Enter member ID: ");
                        String memberId = scanner.nextLine();
                        System.out.print("Enter member name: ");
                        String memberName = scanner.nextLine();
                        System.out.print("Enter member address: ");
                        String memberAddress = scanner.nextLine();
                        System.out.print("Enter member email: ");
                        String memberEmail = scanner.nextLine();

                        if ("1".equalsIgnoreCase(memberType)) {
                            librarian.addMember("Faculty",memberId,memberName,memberAddress,memberEmail);
                        } else if ("2".equalsIgnoreCase(memberType)) {
                            librarian.addMember("Student",memberId,memberName,memberAddress,memberEmail);
                        } else {
                            System.out.println("Invalid member type.");
                            break;
                        }
                        break;
                    case 8:
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            }
        } else {
            System.out.println("Librarian not found.");
        }

        scanner.close();
    }

    public static void handleBookOptions(Book book, Librarian librarian, Library library) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Book Options Menu ---");
            if (book.getStatus()) {
                System.out.println("1. Borrow book");
            } else {
                System.out.println("1. Return book");
            }
            System.out.println("2. Purchase book");
            System.out.println("3. Delete book");
            System.out.println("4. Update book");
            System.out.println("5. Cancel");

            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter the member name: ");
                    String memberName = scanner.nextLine();
                    System.out.println("Enter the date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    if (book.getStatus() && librarian.verifyMember(memberName) != null) {
                        if (librarian.verifyMember(memberName).incBookIssued()) {
                            librarian.issueBook(book, librarian.verifyMember(memberName), date);
                            librarian.verifyMember(memberName).getReader().borrowBook(book);
                        }
                    } else {
                        librarian.returnBook(book, librarian.verifyMember(memberName), date);
                        librarian.verifyMember(memberName).decBookIssued();
                    }
                    running = false;
                    break;

                case 2:
                    System.out.println("Enter the member name: ");
                    String member = scanner.nextLine();
                    if ((book.getStatus() && librarian.verifyMember(member) != null) || librarian.getIssuedBooks().get(book).equals(librarian.verifyMember(member))) {
                        librarian.verifyMember(member).getReader().purchaseBook(book);
                        library.deleteBook(book);
                    } else {
                        System.out.println("Book currently borrowed by someone else.");
                    }
                    running = false;
                    break;
                case 3:
                    library.deleteBook(book);
                    running = false;
                    break;
                case 4:
                    System.out.println("Enter the updated book details.");
                    System.out.println("Enter book type (1:Journals/2:Magazines/3:StudyBook): ");
                    String type = scanner.nextLine();
                    System.out.println("Enter bookID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter edition: ");
                    String edition = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Enter date of purchase (YYYY-MM-DD): ");
                    String dateOfPurchase = scanner.nextLine();
                    LocalDate purchaseDate = LocalDate.parse(dateOfPurchase);

                    Book updatedBook;
                    if ("1".equalsIgnoreCase(type)) {
                        updatedBook = new Journals(id, new Author(author), title, price, edition, purchaseDate);
                    } else if ("2".equalsIgnoreCase(type)) {
                        updatedBook = new Magazines(id, new Author(author), title, price, edition, purchaseDate);
                    } else if ("3".equalsIgnoreCase(type)) {
                        updatedBook = new StudyBooks(id, new Author(author), title, price, edition, purchaseDate);
                    } else {
                        System.out.println("Invalid book type.");
                        break;
                    }

                    library.updateBook(book, updatedBook);
                    running = false;
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
