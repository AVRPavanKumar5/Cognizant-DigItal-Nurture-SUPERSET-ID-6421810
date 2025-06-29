package AAA_Fixtures_Setup_Teardown;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;

class SampleTest {
    List<String> cart;

    @BeforeEach
    void setup() {
        cart = new ArrayList<>();
    }

    @Test
    void testAddToCart() {
        cart.add("Laptop");
        Assertions.assertTrue(cart.contains("Laptop"));
    }

    @Test
    void testRemoveFromCart() {
        cart.add("Phone");
        cart.remove("Phone");
        Assertions.assertFalse(cart.contains("Phone"));
    }

    @AfterEach
    void teardown() {
        cart.clear();
    }
}
