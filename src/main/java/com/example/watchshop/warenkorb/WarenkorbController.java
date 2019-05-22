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

    @GetMapping("/")
    public List<Warenkorb> getWarenkorbsByUserId(@PathVariable int userId) {
        return this.warenkorbService.getWarenkorbsByUserId(userId);
    }

}
