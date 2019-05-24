package com.example.watchshop.seeding;

import com.example.watchshop.artikel.Artikel;
import com.example.watchshop.artikel.ArtikelRepo;
import com.example.watchshop.user.User;
import com.example.watchshop.user.UserRepo;
import com.example.watchshop.warenkorb.Warenkorb;
import com.example.watchshop.warenkorb.WarenkorbRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SeedingService {
    private ArtikelRepo artikelRepo;
    private UserRepo userRepo;
    private WarenkorbRepo warenkorbRepo;

    private List<Artikel> artikels = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Warenkorb> warenkorbs = new ArrayList<>();

    public SeedingService(ArtikelRepo artikelRepo, UserRepo userRepo, WarenkorbRepo warenkorbRepo) {
        this.artikelRepo = artikelRepo;
        this.userRepo = userRepo;
        this.warenkorbRepo = warenkorbRepo;
    }

    public void createUsers() {
        /**
         * Create fake users and save to database
         */
        this.users.add(new User("Nghiem", "", "nghiem@gmail.com", "01.01.2034", "0123456789", "Nghiem"));
        this.users.add(new User("Anh", "", "anh@yahoo.com", "03.03.2046", "0456874256", "Tram Anh"));
        this.users.add(new User("Duc", "", "duc@outlook.com", "24.12.2568", "0568987562", "Duc Vu"));

        this.userRepo.saveAll(this.users);
    }

    public void createArtikels() {
        /**
         * Create fake articles and save to database
         */
        this.artikels.add(new Artikel(120.0, "damenuhr", "Fossil"));
        this.artikels.add(new Artikel(90.0, "damenuhr", "Fossil"));
        this.artikels.add(new Artikel(200.0, "herrenuhr", "Michael Kors"));
        this.artikels.add(new Artikel(240.0, "damenuhr", "Marc Jacob"));
        this.artikels.add(new Artikel(160.0, "damenuhr", "Casio"));
        this.artikels.add(new Artikel(280.0, "herrenuhr", "DW"));
        this.artikels.add(new Artikel(300.0, "herrenuhr", "Catier"));

        this.artikelRepo.saveAll(this.artikels);
    }

    public void createWarenkorbs() {
        /**
         * Create fake warenkorbs and save to database
         */
        for (User user : this.users) {
            for (Artikel artikel : this.artikels) {
                Random random = new Random();

                // Simulate 50% that a user would pick an article to warenkorb
                if (random.nextInt(10) >= 5) {
                    this.warenkorbs.add(new Warenkorb(user, artikel, random.nextInt(10) + 1));
                }
            }
        }
        this.warenkorbRepo.saveAll(this.warenkorbs);

    }

    public void seeding() {
        /**
         * Create fake data and save to database
         */

        this.createArtikels();
        this.createUsers();
        this.createWarenkorbs();
    }
}
