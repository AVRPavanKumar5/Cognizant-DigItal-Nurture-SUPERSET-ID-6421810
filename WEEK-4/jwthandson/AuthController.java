package com.example.jwthandson;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @PostMapping("/authenticate")
    public String authenticate(@RequestBody String user) {
        // Simulate JWT creation
        return "JWT-TOKEN-FOR-" + user;
    }
}
