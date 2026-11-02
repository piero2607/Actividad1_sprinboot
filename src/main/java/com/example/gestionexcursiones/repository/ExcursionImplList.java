package com.example.gestionexcursiones.repository;

import com.example.gestionexcursiones.model.Excursion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ExcursionImplList implements  ExcursionDao{

    private final List<Excursion>lista=new ArrayList<>();
    @Override
    public Excursion findById(int idExcursion) {
        return lista.stream().filter(excursion -> excursion.getIdExcursion()== idExcursion).findFirst().orElse(null);
    }

    @Override
    public List<Excursion> findAll() {
        return lista;
    }

    @Override
    public int insertOne(Excursion excursion) {
        if (findById(excursion.getIdExcursion())!=null){
            return 0;
        }
        lista.add(excursion);
        return 1;
    }

    @Override
    public int updateOne(Excursion excursion) {
        Excursion encontrada=findById(excursion.getIdExcursion());
        if (encontrada!=null){
            int indice=lista.indexOf(encontrada);
            lista.set(indice,excursion);
            return 1;
        }
        return 0;
    }

    @Override
    public List<Excursion> findByActivos() {
        return lista.stream().filter(excursion -> "CREADO".equalsIgnoreCase(excursion.getEstado())).collect(Collectors.toList());
    }

    @Override
    public List<Excursion> findByCancelados() {
        return lista.stream().filter(excursion -> "CANCELADO".equalsIgnoreCase(excursion.getEstado())).collect(Collectors.toList());
    }

    @Override
    public List<Excursion> findByDestacados() {
        return lista.stream().filter(excursion -> "S".equalsIgnoreCase(excursion.getDestacado())).collect(Collectors.toList());
    }
}
