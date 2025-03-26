import org.example.entity.Book;
import org.example.enums.AvailabilityStatus;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTestTest {
    @Test
    public void testBookConstructorAndGetters() {
        Book book = new Book("1", "Effective Java", "Joshua Bloch", "Programming", AvailabilityStatus.AVAILABLE);

        assertEquals("1", book.getId());
        assertEquals("Effective Java", book.getTitle());
        assertEquals("Joshua Bloch", book.getAuthor());
        assertEquals("Programming", book.getGenre());
        assertEquals(AvailabilityStatus.AVAILABLE, book.getAvailabilityStatus());
    }

    @Test
    public void testSetters() {
        Book book = new Book();
        book.setId("2");
        book.setTitle("Clean Code");
        book.setAuthor("Robert C. Martin");
        book.setGenre("Software Engineering");
        book.setAvailabilityStatus(AvailabilityStatus.NOT_AVAILABLE);

        assertEquals("2", book.getId());
        assertEquals("Clean Code", book.getTitle());
        assertEquals("Robert C. Martin", book.getAuthor());
        assertEquals("Software Engineering", book.getGenre());
        assertEquals(AvailabilityStatus.NOT_AVAILABLE, book.getAvailabilityStatus());
    }

    @Test
    public void testToString() {
        Book book = new Book("3", "Refactoring", "Martin Fowler", "Software Design", AvailabilityStatus.AVAILABLE);
        String expected = "Book{id='3', title='Refactoring', author='Martin Fowler', genre='Software Design', availabilityStatus=AVAILABLE}";
        assertEquals(expected, book.toString());
    }
}