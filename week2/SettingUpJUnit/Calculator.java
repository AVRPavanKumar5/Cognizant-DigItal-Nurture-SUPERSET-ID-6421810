package SettingUpJUnit;

public class Calculator {
    // Calculates the total invoice amount after applying tax
    public double calculateInvoiceTotal(double subtotal, double taxRate) {
        return subtotal + (subtotal * taxRate);
    }
}
