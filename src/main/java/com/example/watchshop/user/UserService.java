package com.example.watchshop.user;

import com.example.watchshop.warenkorb.Warenkorb;
import com.example.watchshop.warenkorb.WarenkorbRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    /**
     * Create helper-methods for UserController
     */
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserDTO dao2dto(User user) {
        /**
         * Map a user DAO object to a user DTO object
         */

        UserDTO userDTO = new UserDTO();
        userDTO.setBenutzerName(user.getBenutzerName());
        userDTO.setEmail(user.getEmail());
        userDTO.setGeburtsdatum(user.getGeburtsdatum());
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPhoneNumer(user.getPhoneNumer());

        return userDTO;
    }
    public User dto2dao (UserDTO userDTO, int userId){
        User userDAO = this.userRepo.findById(userId).get();
        userDAO.setBenutzerName(userDTO.getBenutzerName());
        userDAO.setEmail(userDTO.getEmail());
        userDAO.setGeburtsdatum(userDTO.getGeburtsdatum());
        userDAO.setPhoneNumer(userDTO.getPhoneNumer());
        userDAO.setName(userDTO.getName());
        return userDAO;
    }

    public List<UserDTO> getUsers() {
        List<User> users = (List<User>) this.userRepo.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        users.forEach(user -> userDTOS.add(this.dao2dto(user)));

        return userDTOS;
    }

    public UserDTO createUser(User user) {
        this.userRepo.save(user);
        return this.dao2dto(user);
    }

    public UserDTO getUser(int userId) {
        User user = this.userRepo.findById(userId).get();
        return this.dao2dto(user);
    }

    public UserDTO updateUser(UserDTO user, int userId) {
        User userDAO = dto2dao(user,userId);
        this.userRepo.save(userDAO);
        return this.dao2dto(userDAO);
    }

}
