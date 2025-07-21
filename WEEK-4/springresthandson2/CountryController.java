package com.example.springresthandson2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    @GetMapping("/country")
    public String getCountry() {
        return "REST - Country Web Service";
    }

    @GetMapping("/country/{code}")
    public String getCountryByCode(@PathVariable String code) {
        return "REST - Get country based on country code: " + code;
    }
}
