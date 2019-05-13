package com.example.watchshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/users")
    public String getUsers() {
        return "test";
    }
}
