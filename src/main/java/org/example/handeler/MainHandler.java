package org.example.handeler;

import org.example.entity.Book;
import org.example.serviceImpl.LibraryServiceImpl;
import org.example.serviceImpl.services.LibraryService;

public class MainHandler {
    private static final LibraryServiceImpl libraryService = new LibraryService();
    public  void addBook() {
        Book book = new Book();
        book.setId(InputHandler.getString("Enter Book ID: "));
        book.setTitle(InputHandler.getString("Enter Title: "));
        book.setAuthor(InputHandler.getString("Enter Author: "));
        book.setGenre(InputHandler.getString("Enter Genre: "));
        book.setAvailabilityStatus(InputHandler.getAvailabilityStatus("Enter Availability (AVAILABLE, CHECKED_OUT, UNAVAILABLE): "));

        if (book.getTitle().isEmpty() || book.getAuthor().isEmpty()) {
            System.out.println("Title and Author cannot be empty.");
            return;
        }
        if (libraryService.addBook(book)) {
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Book ID already exists.");
        }
    }

    public  void searchBook() {
        String query = InputHandler.getString("Enter Book ID or Title to search: ");
        Book book = libraryService.searchBook(query);
        System.out.println(book != null ? book : "Book not found.");
    }

    public  void updateBook() {
        Book book = new Book();
        book.setId(InputHandler.getString("Enter Book ID to update: "));
        book.setTitle(InputHandler.getString("Enter new Title (leave blank to keep current): "));
        book.setAuthor( InputHandler.getString("Enter new Author (leave blank to keep current): "));
        book.setGenre(InputHandler.getString("Enter new Genre (leave blank to keep current): "));
        book.setAvailabilityStatus(InputHandler.getAvailabilityStatus("Enter new Availability (AVAILABLE, CHECKED_OUT, UNAVAILABLE): "));
        if (libraryService.updateBook(book)) {
            System.out.println("Book details updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public  void deleteBook() {
        String id = InputHandler.getString("Enter Book ID to delete: ");
        if (libraryService.deleteBook(id)) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public  void viewBook() {
        libraryService.viewAllBooks();
    }
}
