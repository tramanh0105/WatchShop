package com.example.watchshop.warenkorb;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users/{userId}/warenkorbs")
public class WarenkorbController {
    private WarenkorbService warenkorbService;

    public WarenkorbController(WarenkorbService warenkorbService) {
        this.warenkorbService = warenkorbService;
    }

    /**
     * Get all Warenkorb by userId
     * @param userId
     * @return
     */
    @GetMapping("")
    public List<Warenkorb> getWarenkorbsByUserId(@PathVariable int userId) {
        return this.warenkorbService.getWarenkorbsByUserId(userId);
    }

    /**
     * Create new Warenkorb
     * @param artikelId
     * @param userId
     * @param anzahl
     * @return
     */
    @PostMapping("/artikels/{artikelId}/{anzahl}")
    public Warenkorb createWarenkorb(@PathVariable int artikelId, @PathVariable int userId, @PathVariable int anzahl){
        return this.warenkorbService.createWarenkorb(artikelId, userId, anzahl);
    }

    /**
     * Update a Warenkorb by userId, artikelId
     * @param artikelId
     * @param userId
     * @param anzahl
     * @return
     */
    @PutMapping("/artikels/{artikelId}/{anzahl}")
    public Warenkorb updateWarenkorb(@PathVariable int artikelId, @PathVariable int userId, @PathVariable int anzahl){
        return this.warenkorbService.updateWarenkorb(artikelId, userId, anzahl);
    }

    /**
     * Delete a Warekorb by userId, artikelId
     * @param artikelId
     * @param userId
     * @return
     */
    @DeleteMapping("/artikels/{artikelId}")
    public Warenkorb deleteWarenkorb(@PathVariable int artikelId, @PathVariable int userId){
        return this.warenkorbService.deleteWarenkorb(artikelId, userId);
    }

}
