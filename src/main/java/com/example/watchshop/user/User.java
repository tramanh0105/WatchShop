package com.example.watchshop.user;

import com.example.watchshop.adresse.Adresse;

import javax.persistence.*;

@Entity
public class User {
    /**
     * Model to be mapped to Database
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String benutzerName;
    private String passwort;
    private String email;
    private String geburtsdatum;
    private String phoneNumer;
    private String name;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Adresse adresse;

    public User() {}

    public User(String benutzerName, String passwort, String email, String geburtsdatum, String phoneNumer, String name) {
        this.benutzerName = benutzerName;
        this.passwort = passwort;
        this.email = email;
        this.geburtsdatum = geburtsdatum;
        this.phoneNumer = phoneNumer;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBenutzerName() {
        return benutzerName;
    }

    public void setBenutzerName(String benutzerName) {
        this.benutzerName = benutzerName;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getPhoneNumer() {
        return phoneNumer;
    }

    public void setPhoneNumer(String phoneNumer) {
        this.phoneNumer = phoneNumer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
