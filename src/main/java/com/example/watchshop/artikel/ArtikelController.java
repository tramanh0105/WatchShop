package com.example.watchshop.artikel;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtikelController {

    private ArtikelService artikelService;

    public ArtikelController(ArtikelService artikelService) {
        this.artikelService = artikelService;
    }

    @GetMapping("/articles/ping")
    public String artikelTest() {
        return "ping";
    }

    //get all articles back
    @GetMapping("artikels")
    public List<Artikel> getArtikels() {
        return this.artikelService.getArtikels();
    }

    @GetMapping("artikels/{artikelId}")
    public Artikel getArtikelByID(@PathVariable int artikelId) {
        return this.artikelService.findById(artikelId);
    }

    @DeleteMapping("artikels/{artikelId}")
    public Artikel deleteArtikel (@PathVariable int artikelId){
        return this.artikelService.deleteArtikel(artikelId);
    }

}
