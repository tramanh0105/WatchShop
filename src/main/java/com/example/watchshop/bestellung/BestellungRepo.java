package com.example.watchshop.bestellung;

import com.example.watchshop.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BestellungRepo extends CrudRepository<Bestellung,Integer> {
    List<Bestellung> findBestellungByUser(User user);
}
