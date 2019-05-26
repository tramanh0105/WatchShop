package com.example.watchshop.bestellposition;

import com.example.watchshop.bestellung.Bestellung;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BestellpositionRepo extends CrudRepository<Bestellposition,Integer> {
    List<Bestellposition> findAllByBestellung(Bestellung bestellung);
}
