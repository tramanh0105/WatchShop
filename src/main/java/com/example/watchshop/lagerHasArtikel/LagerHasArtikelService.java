package com.example.watchshop.lagerHasArtikel;

import com.example.watchshop.artikel.Artikel;
import com.example.watchshop.artikel.ArtikelRepo;
import com.example.watchshop.lager.Lager;
import com.example.watchshop.lager.LagerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LagerHasArtikelService {
    private LagerHasArtikelRepo lagerHasArtikelRepo;
    private ArtikelRepo artikelRepo;
    private LagerRepo lagerRepo;
    public LagerHasArtikelService(LagerHasArtikelRepo lagerHasArtikelRepo) {
        this.lagerHasArtikelRepo = lagerHasArtikelRepo;
    }

    public List<LagerHasArtikel> getAllLagerHasArtikelByArtikelId(int artikelId) {
        Artikel artikel = this.artikelRepo.findById(artikelId).get();

        return this.lagerHasArtikelRepo.findAllByArtikel(artikel);
    }

    /**
     * Create new LagerHasArtikel
     * @return
     */
    public LagerHasArtikel createLagerHasArtikel(int artikelId,int lagerId, int bestand ) {
        Artikel artikel = this.artikelRepo.findById(artikelId).get();
        Lager lager = this.lagerRepo.findById(lagerId).get();
       return this.lagerHasArtikelRepo.save(new LagerHasArtikel(artikel,lager,bestand));
    }

    public LagerHasArtikel updateBestand(int artikelId, int lagerId, int newbestand) {
        Artikel artikel = this.artikelRepo.findById(artikelId).get();
        Lager lager = this.lagerRepo.findById(lagerId).get();
        LagerHasArtikel lagerHasArtikel = this.lagerHasArtikelRepo.findByArtikelAndLager(artikel,lager);
        lagerHasArtikel.setBestand(newbestand);
        return this.lagerHasArtikelRepo.save(lagerHasArtikel);
    }
}
