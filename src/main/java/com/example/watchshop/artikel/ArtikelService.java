package com.example.watchshop.artikel;

import com.example.watchshop.lager.Lager;
import com.example.watchshop.lagerHasArtikel.LagerHasArtikel;
import com.example.watchshop.lagerHasArtikel.LagerHasArtikelRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtikelService {
    private ArtikelRepo artikelRepo;
    private LagerHasArtikelRepo lagerHasArtikelRepo;

    public ArtikelService(ArtikelRepo artikelRepo, LagerHasArtikelRepo lagerHasArtikelRepo) {
        this.artikelRepo = artikelRepo;
        this.lagerHasArtikelRepo = lagerHasArtikelRepo;
    }

    public ArtikelRepo getArtikelRepo() {
        return artikelRepo;
    }

    public void setArtikelRepo(ArtikelRepo artikelRepo) {
        this.artikelRepo = artikelRepo;
    }

    // return all the articles back to ArtikelController
    public List<Artikel> getArtikels() {
        return (List<Artikel>) this.artikelRepo.findAll();
    }

    //find articles by beschreibung
//    public List<Artikel> findByBeschreibung(String beschreibung) {
//        return this.artikelRepo.findArtikelsByBeschreibung(beschreibung);
//    }

    //find aricle by aricleID
    public Artikel findById(int id) {
        return this.artikelRepo.findById(id).get();
    }

    /**
     * Delete Artikel by Id and its association
     *
     * @param artikelId
     */
    public Artikel deleteArtikel(int artikelId) {
        Artikel artikel = this.artikelRepo.findById(artikelId).get();
        List<LagerHasArtikel> list = this.lagerHasArtikelRepo.findAllByArtikel(artikel);
        for (LagerHasArtikel lagerHasArtikel : list) {
            this.lagerHasArtikelRepo.delete(lagerHasArtikel);
        }
        this.artikelRepo.delete(artikel);
        return artikel;
    }
}
