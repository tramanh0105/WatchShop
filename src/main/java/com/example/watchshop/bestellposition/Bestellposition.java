package com.example.watchshop.bestellposition;

import com.example.watchshop.artikel.Artikel;
import com.example.watchshop.bestellung.Bestellung;

import javax.persistence.*;

@Entity
public class Bestellposition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Bestellung bestellung;

    @ManyToOne
    private Artikel artikel;

    private int anzahl;

    public Bestellposition() {
    }

    public Bestellposition(Bestellung bestellung, Artikel artikel, int anzahl) {
        this.bestellung = bestellung;
        this.artikel = artikel;
        this.anzahl = anzahl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bestellung getBestellung() {
        return bestellung;
    }

    public void setBestellung(Bestellung bestellung) {
        this.bestellung = bestellung;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }
}
