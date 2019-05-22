package com.example.watchshop.warenkorb;

import com.example.watchshop.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarenkorbRepo extends CrudRepository<Warenkorb, Integer> {
    List<Warenkorb> findWarenkorbsByUser(User user);
}
