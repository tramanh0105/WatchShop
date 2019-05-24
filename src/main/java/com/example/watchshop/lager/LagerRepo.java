package com.example.watchshop.lager;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LagerRepo extends CrudRepository<Lager,Integer> {
}
