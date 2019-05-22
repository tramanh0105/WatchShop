package com.example.watchshop.artikel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtikelRepo extends CrudRepository<Artikel, Integer> {
    /**
     * Provide convenient methods for ArtikelService to query Database
     */
//     List<Artikel> findArtikelsByBeschreibung(String beschreibung);
}
