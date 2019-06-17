package com.example.watchshop.user;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin
public class UserController {
    /**
     * Create endpoints for Client
     */

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    /**
     * Return all users from database
     */
    public List<UserDTO> getUsers(){
        return this.userService.getUsers();
    }

    @GetMapping("/users/{userId}")
    public UserDTO getUser(@PathVariable int userId){
        return this.userService.getUser(userId);
    }

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody User user){
        return this.userService.createUser(user);
    }

    @PutMapping("/users/{userId}")
    public UserDTO updateUser(@RequestBody UserDTO user, @PathVariable int userId){
        return this.userService.updateUser(user, userId);
    }
}
