package com.example.watchshop.artikel;

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
    public String artikelTest(){
        return "ping";
    }
    //get all articles back
    @GetMapping("artikels")
    public List<Artikel> getArtikels(){
        return this.artikelService.getArtikels();
    }
    //find article by bezeichnung
    @GetMapping("/artikel/{bezeichnung}")
    public List<Artikel> getArtikelsByBezeichnung(@PathVariable String bezeichnung){
        return this.artikelService.findByBeschreibung(bezeichnung);
    }
    //find article by ID
    @GetMapping("artikel/{articleId}")
    public Artikel getArtikelByID(@PathVariable int id){
       return this.artikelService.findById(id);
    }


}
