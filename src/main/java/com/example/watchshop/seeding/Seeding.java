package com.example.watchshop.seeding;

import com.example.watchshop.artikel.Artikel;
import com.example.watchshop.artikel.ArtikelRepo;

import java.util.ArrayList;

public class Seeding {
    private ArtikelRepo artikelRepo;

    public Seeding() {
    }
    public void seeding (){
        // create an array to store all of article objects
        ArrayList<Artikel> artikelist = new ArrayList<Artikel>();

        //create articles
        Artikel a1 = new Artikel(300.0,"damenuhr","Fossil");
        Artikel a2 = new Artikel(300.0,"damenuhr","Fossil");
        Artikel a3 = new Artikel(300.0,"herrenuhr","Michael Kors");
        Artikel a4 = new Artikel(300.0,"damenuhr","Marc Jacob");
        Artikel a5 = new Artikel(300.0,"damenuhr","Casio");
        Artikel a6 = new Artikel(300.0,"herrenuhr","DW");
        Artikel a7 = new Artikel(300.0,"herrenuhr","Catier");

        //adding the articles to array list and ArtikelRepo
        artikelist.add(a1);
        artikelist.add(a2);
        artikelist.add(a3);
        artikelist.add(a4);
        artikelist.add(a5);
        artikelist.add(a6);
        artikelist.add(a7);

        this.artikelRepo.saveAll(artikelist);
    }
}
