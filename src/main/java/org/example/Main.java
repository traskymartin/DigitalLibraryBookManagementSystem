package org.example;

import org.example.entity.Book;
import org.example.handeler.InputHandler;
import org.example.handeler.MainHandler;
import org.example.serviceImpl.LibraryServiceImpl;
import org.example.serviceImpl.services.LibraryService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private  static final MainHandler mainHandler = new MainHandler();
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID or Title");
            System.out.println("4. Update Book Details");
            System.out.println("5. Delete a Book Record");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                continue;
            }

            switch (choice) {
                case 1 -> mainHandler.addBook();
                case 2 ->mainHandler.viewBook();
                case 3 -> mainHandler.searchBook();
                case 4 -> mainHandler.updateBook();
                case 5 -> mainHandler.deleteBook();
                case 6 -> {
                    System.out.println("Exiting system...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }


}
