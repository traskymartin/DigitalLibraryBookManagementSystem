package org.example.serviceImpl.services;


import org.example.entity.Book;
import org.example.serviceImpl.LibraryServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class LibraryService implements LibraryServiceImpl {

    private final Map<String, Book> bookCatalog = new HashMap<String, Book>();
    @Override
    public boolean addBook(Book book) {
        if(bookCatalog.containsKey(book.getId())) return false;
        else bookCatalog.put(book.getId(), book);
        return true;
    }

    @Override
    public void viewAllBooks() {
        if(bookCatalog.isEmpty())  System.out.println("No books found");
        else bookCatalog.values().forEach(book -> System.out.println(book.toString()));
    }

    @Override
    public Book searchBook(String query) {

        return bookCatalog.values().stream()
                .filter(book ->
                        book.getId().equalsIgnoreCase(query) || book.getTitle().equalsIgnoreCase(query))
                .findFirst().
                orElse(null);
    }

    @Override
    public boolean updateBook(Book book) {
        Book oldBook = bookCatalog.get(book.getId());
        if (oldBook == null) return false;
        if (!book.getTitle().isEmpty())oldBook.setTitle(book.getTitle());
        if (!book.getAuthor().isEmpty())oldBook.setAuthor(book.getAuthor());
        if(!book.getGenre().isEmpty())oldBook.setGenre(book.getGenre());
        if(book.getAvailabilityStatus()!=null) oldBook.setAvailabilityStatus(book.getAvailabilityStatus());
        return true;
    }

    @Override
    public boolean deleteBook(String id) {
        return bookCatalog.remove(id) != null;
    }
}
