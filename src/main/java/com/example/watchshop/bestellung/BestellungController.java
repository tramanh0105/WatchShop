package com.example.watchshop.bestellung;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BestellungController {
    private BestellungService bestellungService;

    public BestellungController(BestellungService bestellungService) {
        this.bestellungService = bestellungService;
    }


    @GetMapping("/bestellungs")
    public List<Bestellung> getAllBestellungs() {
        return this.bestellungService.getBestellungs();
    }


    @GetMapping("/users/{userId}/bestellungs")
    public List<Bestellung> getBestellungsByUser(@PathVariable int userId) {
        return this.bestellungService.getBestellungsByUser(userId);
    }


    @GetMapping("/bestellungs/{bestellungId}")
    public Bestellung findBestellungById(@PathVariable int bestellungId) {
        return this.bestellungService.getBestellungById(bestellungId);
    }

    @PostMapping("/bestellungs/{userId}")
    public Bestellung createBestellung (@PathVariable int userId){
        return this.bestellungService.createBestellung(userId);
    }

    @PutMapping("/bestellungs/{bestellungId}")
    public Bestellung updateBestellung(@PathVariable int bestellungId){
        return this.bestellungService.updateBestellung(bestellungId);
    }

    @DeleteMapping("/bestellungs/{bestellungId}")
    public Bestellung deleteBestellung(@PathVariable int bestellungId){
        return this.bestellungService.deleteBestellung(bestellungId);

    }



}
