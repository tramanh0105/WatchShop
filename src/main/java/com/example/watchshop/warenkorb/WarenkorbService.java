package com.example.watchshop.warenkorb;

import com.example.watchshop.user.User;
import com.example.watchshop.user.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarenkorbService {
    private WarenkorbRepo warenkorbRepo;
    private UserRepo userRepo;

    public WarenkorbService(WarenkorbRepo warenkorbRepo, UserRepo userRepo) {
        this.warenkorbRepo = warenkorbRepo;
        this.userRepo = userRepo;
    }

    public List<Warenkorb> getWarenkorbsByUserId(int userId) {
        User user = this.userRepo.findById(userId).get();
        return this.warenkorbRepo.findWarenkorbsByUser(user);
    }

}
