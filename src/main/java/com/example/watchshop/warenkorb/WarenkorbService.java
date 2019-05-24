package com.example.watchshop.warenkorb;

import com.example.watchshop.artikel.Artikel;
import com.example.watchshop.artikel.ArtikelRepo;
import com.example.watchshop.user.User;
import com.example.watchshop.user.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarenkorbService {
    private WarenkorbRepo warenkorbRepo;
    private UserRepo userRepo;
    private ArtikelRepo artikelRepo;

    public WarenkorbService(WarenkorbRepo warenkorbRepo, UserRepo userRepo, ArtikelRepo artikelRepo) {
        this.warenkorbRepo = warenkorbRepo;
        this.userRepo = userRepo;
        this.artikelRepo = artikelRepo;
    }

    /**
     * Get all warenkorbs by userId
     * @param userId
     * @return
     */
    public List<Warenkorb> getWarenkorbsByUserId(int userId) {
        User user = this.userRepo.findById(userId).get();
        return this.warenkorbRepo.findAllByUser(user);
    }

    /**
     * Create new warenkorb and save to database
     * @param artikelId
     * @param userId
     * @param anzahl
     * @return
     */
    public Warenkorb createWarenkorb(int artikelId, int userId, int anzahl) {
        Artikel artikel = this.artikelRepo.findById(artikelId).get();
        User user = this.userRepo.findById(userId).get();
        Warenkorb warenkorb = new Warenkorb(user, artikel, anzahl);
        this.warenkorbRepo.save(warenkorb);
        return warenkorb;
    }

    /**
     * Update a Warenkorb by artikelId and userId
     * @param artikelId
     * @param userId
     * @param anzahl
     * @return
     */
    public Warenkorb updateWarenkorb(int artikelId, int userId, int anzahl) {
        Artikel artikel = this.artikelRepo.findById(artikelId).get();
        User user = this.userRepo.findById(userId).get();
        Warenkorb warenkorb = this.warenkorbRepo.findByUserAndArtikel(user, artikel);
        warenkorb.setAnzahl(anzahl);
        this.warenkorbRepo.save(warenkorb);
        return warenkorb;
    }

    /**
     * Delete a Warenkorb by artikelId and userId
     * @param artikelId
     * @param userId
     * @return
     */
    public Warenkorb deleteWarenkorb(int artikelId, int userId) {
        Artikel artikel = this.artikelRepo.findById(artikelId).get();
        User user = this.userRepo.findById(userId).get();
        Warenkorb warenkorb = this.warenkorbRepo.findByUserAndArtikel(user, artikel);
        this.warenkorbRepo.delete(warenkorb);
        return warenkorb;
    }
}
