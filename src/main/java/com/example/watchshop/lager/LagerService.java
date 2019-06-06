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
     *
     * @param lager
     * @return
     */
    public Lager createLager(Lager lager) {
        return this.lagerRepo.save(lager);
    }

    /**
     * update new Lager
     *
     * @param newLager
     * @return
     */
    public Lager updateLager(int lagerId, Lager newLager) {
        Lager oldLager = this.lagerRepo.findById(lagerId).get();
        newLager.setId(lagerId);
        this.lagerRepo.delete(oldLager);
        return this.lagerRepo.save(newLager);
    }

    /**
     * deleteLager
     * @param lagerId
     * @return
     */
    public Lager deleteLager(int lagerId) {
        Lager deletedLager = this.lagerRepo.findById(lagerId).get();
        this.lagerRepo.delete(deletedLager);
        return deletedLager;
    }
}
