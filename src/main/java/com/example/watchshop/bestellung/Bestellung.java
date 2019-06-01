package com.example.watchshop.bestellung;

import com.example.watchshop.user.User;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Entity
public class Bestellung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    private String bestelldatum;

    @Enumerated(EnumType.STRING)
    private BestellungStatus bestellstatus;

    public Bestellung() {
    }
    public Bestellung(User user){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String datum = formatter.format(date);
        this.bestelldatum = datum;
        this.user = user;
        this.bestellstatus = BestellungStatus.Bearbeitet;
    }

    public Bestellung(User user, String bestelldatum) {

        this.user = user;
        this.bestelldatum = bestelldatum;
        this.bestellstatus =BestellungStatus.Bearbeitet;
//        this.bestellstatus = bestellstatus;
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

    public String getBestelldatum() {
        return bestelldatum;
    }

    public void setBestelldatum(String bestelldatum) {
        this.bestelldatum = bestelldatum;
    }

    public BestellungStatus getBestellstatus() {
        return bestellstatus;
    }

    public void setBestellstatus(BestellungStatus bestellstatus) {
        this.bestellstatus = bestellstatus;
    }


}
