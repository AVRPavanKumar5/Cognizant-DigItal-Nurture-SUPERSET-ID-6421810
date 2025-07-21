package com.example.loan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
    @GetMapping("/")
    public String home() {
        return "Loan Microservice is running!";
    }

    @GetMapping("/loan")
    public String getLoan() {
        return "Loan details from Loan Microservice";
    }
}
