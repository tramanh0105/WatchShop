package com.example.watchshop.bestellposition;

import com.example.watchshop.bestellung.BestellungService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BestellpostionController {
    private BestellpositionService bestellpositionService;

    public BestellpostionController(BestellpositionService bestellpositionService) {
        this.bestellpositionService = bestellpositionService;
    }

    @GetMapping("/bestellpositions")
    public List<Bestellposition> getAllBestellposition (){
        return this.bestellpositionService.getBestellpositions();
    }

    @GetMapping("/bestellpositions/{bestellungId}")
    public List<Bestellposition> findBestellpositionById(@PathVariable int bestellungId){
        return this.bestellpositionService.findBestellpostionById(bestellungId);
    }

    @PostMapping("/bestellpositions/{bestellungId}/{artikelId}/{anzahl}")
    public Bestellposition createBestellposition(@PathVariable int bestellungId, @PathVariable int artikelId, @PathVariable int anzahl){
        return this.bestellpositionService.creeatBestellposition(bestellungId,artikelId,anzahl);
    }
    @PutMapping("/bestellpositions/{bestellpositionId}/{anzahl}")
    public Bestellposition  updateBestellpostition (@PathVariable int bestellpositionId, @PathVariable int anzahl){
        return this.bestellpositionService.updateBestellposition(bestellpositionId,anzahl);
    }
    @DeleteMapping("/bestellpositions/{bestellpositionId}")
    public Bestellposition deleteBestellposition (@PathVariable int bestellpositionId){
        return this.bestellpositionService.deleteBestellposition(bestellpositionId);
    }


}
