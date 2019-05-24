package com.example.watchshop.lagerHasArtikel;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/artikels/{artikelId}/lagerHasArtikels")
public class LagerHasArtikelController {
    private LagerHasArtikelService lagerHasArtikelService;

    public LagerHasArtikelController(LagerHasArtikelService lagerHasArtikelService) {
        this.lagerHasArtikelService = lagerHasArtikelService;
    }

    /**
     * Get all warehouse by article id
     */

    @GetMapping("")
    public List<LagerHasArtikel> getLagers(@PathVariable int artikelId) {
        return this.lagerHasArtikelService.getAllLagerHasArtikelByArtikelId(artikelId);
    }

    /**
     * Create new LagerHasArtikel
     */
    @PostMapping("/lagers/{lagerId}/{bestand}")
    public LagerHasArtikel createLagerHasArtikel(@PathVariable int artikelId, @PathVariable int lagerId, @PathVariable int bestand) {
        return this.lagerHasArtikelService.createLagerHasArtikel(artikelId, lagerId, bestand);
    }

    /**
     * Update new value for bestand
     */
    @PutMapping("/lagers/{lagerId}/{bestand}")
    public LagerHasArtikel updateBestand(@PathVariable int artikelId, @PathVariable int lagerId, @PathVariable int bestand) {
        return this.lagerHasArtikelService.updateBestand(artikelId, lagerId, bestand);
    }


}
