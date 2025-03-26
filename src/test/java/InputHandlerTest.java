import org.example.enums.AvailabilityStatus;
import org.example.handeler.InputHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputHandlerTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testGetAvailabilityStatus() {
        String input = "AVAILABLE\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        AvailabilityStatus status = InputHandler.getAvailabilityStatus("Enter availability status: ");
        assertEquals(AvailabilityStatus.AVAILABLE, status);
    }
}