package com.example.watchshop.artikel;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Artikel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double preis;
    private String beschreibung;
    private String hersteller;

    public Artikel() {
    }

    public Artikel(double preis, String beschreibung, String hersteller) {
        this.preis = preis;
        this.beschreibung = beschreibung;
        this.hersteller = hersteller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }
}
