package com.example.watchshop.bestellung;


import com.example.watchshop.bestellposition.Bestellposition;
import com.example.watchshop.user.User;
import com.example.watchshop.user.UserRepo;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class BestellungService {
    private BestellungRepo bestellungRepo;
    private UserRepo userRepo;

    public BestellungService(BestellungRepo bestellungRepo, UserRepo userRepo) {
        this.bestellungRepo = bestellungRepo;
        this.userRepo = userRepo;
    }

    /**
     * Get all bestellungs
     *
     * @return
     */
    public List<Bestellung> getBestellungs() {
        return (List<Bestellung>) this.bestellungRepo.findAll();
    }

    /**
     * find bestellung by Id
     */
    public Bestellung getBestellungById(int bestellungId) {
        return this.bestellungRepo.findById(bestellungId).get();
    }

    /**
     * find all bestellungs from a user
     */
    public List<Bestellung> getBestellungsByUser(int userId) {
        User user = this.userRepo.findById(userId).get();
        return this.bestellungRepo.findBestellungByUser(user);
    }

    /**
     * create bestellungs
     *
     * @param userId
     * @return
     */
    public Bestellung createBestellung(int userId) {
        User user = this.userRepo.findById(userId).get();
//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String datum = formatter.format(date);
        Bestellung bestellung = new Bestellung(user);
        this.bestellungRepo.save(bestellung);
        return bestellung;
    }

    /**
     * update bestellungstatus by bestellungId
     *
     * @param bestellungId
     * @return
     */
    public Bestellung updateBestellung(int bestellungId) {
        Bestellung bestellung = this.bestellungRepo.findById(bestellungId).get();
        BestellungStatus status =bestellung.getBestellstatus().changeState();
        bestellung.setBestellstatus(status);
        return this.bestellungRepo.save(bestellung);

    }

    /**
     * Delete Bestellung by BestellungId
     * @param bestellungId
     * @return
     */
    public Bestellung deleteBestellung(int bestellungId) {
        Bestellung bestellung = this.bestellungRepo.findById(bestellungId).get();
        this.bestellungRepo.delete(bestellung);
        return bestellung;

    }


}
