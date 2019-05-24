package com.example.watchshop.lager;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LagerController {
    private LagerService lagerService;

    public LagerController(LagerService lagerService) {
        this.lagerService = lagerService;
    }


    //get all the existed warehouses
    @GetMapping("/lagers/")
    public List<Lager> getAllLagers(){
        return this.lagerService.getAllLager();
    }

    @GetMapping("/lagers/{lagerId}")
    public Lager getLager(@PathVariable int lagerId){
        /**
         * Get the warehouse by id
         */
        return this.lagerService.getLager(lagerId);

    }
    /**
     * Create new Lager
     */
    @PostMapping("/lagers")
    public Lager createLager(@RequestBody Lager lager){
        return this.lagerService.createLager(lager);
    }
}
