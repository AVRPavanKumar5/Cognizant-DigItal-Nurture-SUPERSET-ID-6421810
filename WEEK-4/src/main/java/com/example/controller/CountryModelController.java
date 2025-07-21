package com.example.controller;

import com.example.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryModelController {
    @GetMapping("/country")
    public Country getCountry() {
        return new Country("IN", "India");
    }
}
