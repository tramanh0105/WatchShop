package com.example.watchshop.authenticate;

import com.example.watchshop.user.UserDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthenticateController {

    private AuthenticateService authenticateService;

    public AuthenticateController(AuthenticateService authenticateService) {
        this.authenticateService = authenticateService;
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody UserLogin userLogin) {
        return this.authenticateService.login(userLogin);
    }

    @PostMapping("/register")
    public UserDTO register(@RequestBody UserLogin userLogin) {
        return this.authenticateService.register(userLogin);
    }
}
