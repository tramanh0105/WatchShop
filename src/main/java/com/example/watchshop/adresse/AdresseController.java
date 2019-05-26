package com.example.watchshop.adresse;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/users/{userId}/adresse")
public class AdresseController {
    /**
     * Create endpoints for Client
     */
    private AdresseService adresseService;

    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @GetMapping("")
    public Adresse getAdresse(@PathVariable int userId) {
        return this.adresseService.getAdresse(userId);
    }

    @PostMapping("")
    public Adresse createAdresse(@PathVariable int userId, @RequestBody Adresse adresse ) {
        return this.adresseService.createAdresse(userId, adresse);
    }

    @PutMapping("")
    public Adresse updateAdresse(@PathVariable int userId, @RequestBody Adresse adresse ) {
        return this.adresseService.updateAdresse(userId, adresse);
    }

    @DeleteMapping("")
    public Adresse updateAdresse(@PathVariable int userId) {
        return this.adresseService.deleteAdresse(userId);
    }
}
