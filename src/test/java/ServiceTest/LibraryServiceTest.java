import org.example.entity.Book;
import org.example.enums.AvailabilityStatus;
import org.example.serviceImpl.services.LibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class LibraryServiceTest {
    private static  LibraryService libraryService ;

    @BeforeEach
    void setUp() {
        libraryService = new LibraryService();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("1", "Java Programming", "John Doe", "Programming", AvailabilityStatus.AVAILABLE);
        assertTrue(libraryService.addBook(book));
        assertFalse(libraryService.addBook(book)); // Duplicate should return false
    }

    @Test
    public void testSearchBook() {
        Book book = new Book("2", "Spring Boot Guide", "Jane Doe", "Technology", AvailabilityStatus.AVAILABLE);
        libraryService.addBook(book);
        assertEquals(book, libraryService.searchBook("2"));
        assertEquals(book, libraryService.searchBook("Spring Boot Guide"));
        assertNull(libraryService.searchBook("Nonexistent Book"));
    }

    @Test
    public void testUpdateBook() {
        Book book = new Book("3", "Python Basics", "Alice", "Programming", AvailabilityStatus.AVAILABLE);
        libraryService.addBook(book);
        Book updatedBook = new Book("3", "Advanced Python", "Alice", "Data Science", AvailabilityStatus.CHECKED_OUT);
        assertTrue(libraryService.updateBook(updatedBook));
        Book retrievedBook = libraryService.searchBook("3");
        assertEquals("Advanced Python", retrievedBook.getTitle());
        assertEquals("Data Science", retrievedBook.getGenre());
        assertEquals(AvailabilityStatus.CHECKED_OUT, retrievedBook.getAvailabilityStatus());
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book("4", "Effective Java", "Joshua Bloch", "Programming", AvailabilityStatus.AVAILABLE);
        libraryService.addBook(book);
        assertTrue(libraryService.deleteBook("4"));
        assertFalse(libraryService.deleteBook("4")); // Book is already deleted
    }

    @Test
    public void testViewAllBooks() {
        Book book1 = new Book("5", "Java 8 in Action", "Raoul-Gabriel Urma", "Programming", AvailabilityStatus.AVAILABLE);
        Book book2 = new Book("6", "Clean Code", "Robert C. Martin", "Software Engineering", AvailabilityStatus.AVAILABLE);

        libraryService.addBook(book1);
        libraryService.addBook(book2);

        libraryService.viewAllBooks(); // This should print the books to the console
    }
}
