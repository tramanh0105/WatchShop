package com.example.watchshop.seeding;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SeedingController {
    private SeedingService seedingService;

    public SeedingController(SeedingService seedingService) {
        this.seedingService = seedingService;
    }

    @GetMapping("/seeding")
    public String seeding() {
        this.seedingService.seeding();
        return "seeding successful...";
    }
}
