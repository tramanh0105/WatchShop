package com.example.watchshop.adresse;

import com.example.watchshop.user.User;
import com.example.watchshop.user.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class AdresseService {
    /**
     * Create helper-methods for UserController
     */

    private AdresseRepo adresseRepo;
    private UserRepo userRepo;

    public AdresseService(AdresseRepo adresseRepo, UserRepo userRepo) {
        this.adresseRepo = adresseRepo;
        this.userRepo = userRepo;
    }

    //get the address of an user
    public Adresse getAdresse(int userId) {
        User user = this.userRepo.findById(userId).get();
        return this.adresseRepo.findAdresseByUser(user);
    }

    //create or update a new address for an user
    public Adresse createAdresse(int userId, Adresse adresse) {
        User user = this.userRepo.findById(userId).get();
        adresse.setUser(user);
        return this.adresseRepo.save(adresse);
    }

    //update a address for an user
    public Adresse updateAdresse(int userId, Adresse neueAdresse) {
        User user = this.userRepo.findById(userId).get();
        Adresse adresse = this.adresseRepo.findAdresseByUser(user);
        neueAdresse.setId(adresse.getId());
        neueAdresse.setUser(user);
        return this.adresseRepo.save(neueAdresse);
    }

    //delete the address of an user
    public Adresse deleteAdresse(int userId) {
        User user = this.userRepo.findById(userId).get();
        return this.adresseRepo.deleteAdresseByUser(user);
    }


}
