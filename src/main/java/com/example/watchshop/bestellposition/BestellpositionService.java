package com.example.watchshop.bestellposition;

import com.example.watchshop.artikel.Artikel;
import com.example.watchshop.artikel.ArtikelRepo;
import com.example.watchshop.bestellung.Bestellung;
import com.example.watchshop.bestellung.BestellungRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BestellpositionService {
    private BestellpositionRepo bestellpositionRepo;
    private BestellungRepo bestellungRepo;
    private ArtikelRepo artikelRepo;

    public BestellpositionService(BestellpositionRepo bestellpositionRepo, BestellungRepo bestellungRepo, ArtikelRepo artikelRepo) {
        this.bestellpositionRepo = bestellpositionRepo;
        this.bestellungRepo = bestellungRepo;
        this.artikelRepo = artikelRepo;
    }

    /**
     * Get all Bestellpositions
     *
     * @return
     */
    public List<Bestellposition> getBestellpositions() {
        return (List<Bestellposition>) this.bestellpositionRepo.findAll();
    }

    /**
     * Find bestellungspositionById
     *
     * @param bestellungId
     * @return
     */
    public List<Bestellposition> findBestellpostionById(int bestellungId) {
        Bestellung bestellung = this.bestellungRepo.findById(bestellungId).get();
        return this.bestellpositionRepo.findAllByBestellung(bestellung);
    }

    public Bestellposition creeatBestellposition(int bestellungId, int artikelId, int anzahl) {
        Bestellung bestellung = this.bestellungRepo.findById(bestellungId).get();
        Artikel artikel = this.artikelRepo.findById(artikelId).get();
        Bestellposition neu = new Bestellposition(bestellung,artikel,anzahl);
        this.bestellpositionRepo.save(neu);
        return neu;

    }

    /**
     * change the number of purchasing article
     * @param bestellpositionId
     * @param anzahl
     * @return
     */
    public Bestellposition updateBestellposition(int bestellpositionId, int anzahl) {
        Bestellposition bestellposition = this.bestellpositionRepo.findById(bestellpositionId).get();
        bestellposition.setAnzahl(anzahl);
        this.bestellpositionRepo.save(bestellposition);
        return bestellposition;

    }

    /**
     * delete bestellposition by id
     * @param bestellpositionId
     * @return
     */
    public Bestellposition deleteBestellposition(int bestellpositionId) {
        Bestellposition bestellposition = this.bestellpositionRepo.findById(bestellpositionId).get();
        this.bestellpositionRepo.delete(bestellposition);
        return bestellposition;
    }
}
