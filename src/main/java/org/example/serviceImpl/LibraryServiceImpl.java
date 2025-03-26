package org.example.serviceImpl;


import org.example.entity.Book;

public interface LibraryServiceImpl {
    public boolean addBook(Book book);
    public void viewAllBooks();
    public Book searchBook(String query);
    public boolean updateBook(Book book);
    public boolean deleteBook(String id);
}
