package com.example.gestionexcursiones.repository;

import com.example.gestionexcursiones.model.Excursion;

import java.util.List;

public interface ExcursionDao {
    Excursion findById(int idExcursion);
    List<Excursion> findAll();
    int insertOne(Excursion excursion);
    int updateOne(Excursion excursion);
    List<Excursion> findByActivos();
    List<Excursion> findByCancelados();
    List<Excursion> findByDestacados();

}
