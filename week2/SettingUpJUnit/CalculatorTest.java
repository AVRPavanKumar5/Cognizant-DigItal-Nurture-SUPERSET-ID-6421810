package SettingUpJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void testCalculateInvoiceTotal() {
        Calculator calc = new Calculator();
        double subtotal = 100.0;
        double taxRate = 0.18;
        double expected = 118.0;
        assertEquals(expected, calc.calculateInvoiceTotal(subtotal, taxRate), 0.001);
    }
}
