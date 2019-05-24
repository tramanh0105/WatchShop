package com.example.watchshop.lagerHasArtikel;

import com.example.watchshop.artikel.Artikel;
import com.example.watchshop.lager.Lager;

import javax.persistence.*;

@Entity
public class LagerHasArtikel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Artikel artikel;
    @ManyToOne
    private Lager lager;

    private int bestand;

    public LagerHasArtikel() {
    }

    public LagerHasArtikel(Artikel artikel, Lager lager, int bestand) {
        this.artikel = artikel;
        this.lager = lager;
        this.bestand = bestand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Lager getLager() {
        return lager;
    }

    public void setLager(Lager lager) {
        this.lager = lager;
    }

    public int getBestand() {
        return bestand;
    }

    public void setBestand(int bestand) {
        this.bestand = bestand;
    }
}
