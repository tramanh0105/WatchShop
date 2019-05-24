package com.example.watchshop.lager;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LagerService {
    private LagerRepo lagerRepo;

    public LagerService(LagerRepo lagerRepo) {
        this.lagerRepo = lagerRepo;
    }

    //get all the warehouses
    public List<Lager> getAllLager() {
        return (List<Lager>) this.lagerRepo.findAll();
    }

    /**
     * Get the warehouse by id
     */
    public Lager getLager(int id) {

        return this.lagerRepo.findById(id).get();
    }

    /**
     * Create new lager
     * @param lager
     * @return
     */
    public Lager createLager(Lager lager) {
        return this.lagerRepo.save(lager);
    }
}
