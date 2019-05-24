package com.example.watchshop.lagerHasArtikel;

import com.example.watchshop.artikel.Artikel;
import com.example.watchshop.lager.Lager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LagerHasArtikelRepo extends CrudRepository<LagerHasArtikel,Integer> {
    List<LagerHasArtikel> findAllByArtikel(Artikel artikel);
    LagerHasArtikel findByArtikelAndLager(Artikel artikel, Lager lager);
}
