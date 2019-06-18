package com.example.watchshop.authenticate;

import com.example.watchshop.singletonLogger.Logger;
import com.example.watchshop.user.User;
import com.example.watchshop.user.UserDTO;
import com.example.watchshop.user.UserRepo;
import com.example.watchshop.user.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class AuthenticateService {
    private UserRepo userRepo;
    private UserService userService;

    public AuthenticateService(UserRepo userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    public UserDTO login(UserLogin userLogin) {
        User foundUser = this.userRepo.findByBenutzerNameAndPasswort(userLogin.getUserName(), userLogin.getPassword());
        if (foundUser == null) {
            return null;
        } else {
            UserDTO user = this.userService.dao2dto(foundUser);
            Logger.getInstance().loginLog(user,LocalDateTime.now().toString());
            return user;
        }
    }

}
