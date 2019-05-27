package com.example.watchshop.warenkorb;

import com.example.watchshop.artikel.Artikel;
import com.example.watchshop.user.User;

import javax.persistence.*;

@Entity
public class Warenkorb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Artikel artikel;

    private int anzahl;

    public Warenkorb() {
    }

    public Warenkorb(User user, Artikel artikel, int anzahl) {
        this.user = user;
        this.artikel = artikel;
        this.anzahl = anzahl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
