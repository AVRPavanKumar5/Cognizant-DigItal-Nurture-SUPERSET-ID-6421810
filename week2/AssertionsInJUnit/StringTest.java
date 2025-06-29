package AssertionsInJUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    public void testValidEmail() {
        String email = "user@example.com";
        assertTrue(email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"));
    }
}
