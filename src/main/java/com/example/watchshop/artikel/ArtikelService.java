package com.example.watchshop.artikel;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArtikelService {
    private ArtikelRepo artikelRepo;

    public ArtikelService(ArtikelRepo artikelRepo) {
        this.artikelRepo = artikelRepo;
    }

    public ArtikelRepo getArtikelRepo() {
        return artikelRepo;
    }

    public void setArtikelRepo(ArtikelRepo artikelRepo) {
        this.artikelRepo = artikelRepo;
    }

    // return all the articles back to ArtikelController
    public List<Artikel> getArtikels(){
        return (List<Artikel>) this.artikelRepo.findAll();
    }

    //find articles by beschreibung
//    public List<Artikel> findByBeschreibung(String beschreibung) {
//        return this.artikelRepo.findArtikelsByBeschreibung(beschreibung);
//    }

    //find aricle by aricleID
    public Artikel findById(int id){
        return this.artikelRepo.findById(id).get();
    }

    /**
     * Delete Artikel by Id and its association
     * @param artikelId
     */
    public Artikel deleteArtikel(int artikelId) {
        Artikel artikel = this.artikelRepo.findById(artikelId).get();
        this.artikelRepo.delete(artikel);
        return artikel;
    }
}
