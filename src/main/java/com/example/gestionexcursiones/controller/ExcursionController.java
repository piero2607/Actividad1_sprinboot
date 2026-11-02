package com.example.gestionexcursiones.controller;

import com.example.gestionexcursiones.model.Excursion;
import com.example.gestionexcursiones.repository.ExcursionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ExcursionController {

    @Autowired
    private ExcursionDao excursionDao;

    @GetMapping
    public List<Excursion> obtenerTodas(){
        return excursionDao.findByActivos();
    }

    @GetMapping("excursion/detalle/{id}")
    public Excursion verDetalle(@PathVariable("id") int id){
        Excursion excursion=excursionDao.findById(id);
        return excursion;
    }

    @GetMapping("excursion/cancelar/{id}")
    public String cancelarExcursion(@PathVariable("id") int id){
        Excursion excursion=excursionDao.findById(id);
        if (excursion!=null){
            excursion.setEstado("CANCELADO");
            excursionDao.updateOne(excursion);
            return "Excursion con ID: " +id+ " Cancelado.";
        }
        return "no se encontro la excursion con ID: " +id;
    }

    @GetMapping("/excursion/modificar/{id}")
    public Excursion formularioModificar(@PathVariable("id") int id){
        return excursionDao.findById(id);
    }

    @PostMapping("excursion/modificar/{id}")
    public String modificarExcursion(@PathVariable("id") int id, @RequestBody Excursion excursionModificada){
        Excursion existente = excursionDao.findById(id);
        if (existente != null){
            excursionModificada.setIdExcursion(id);
            int resultado = excursionDao.updateOne(excursionModificada);
            if (resultado == 1){
                return "Datos de la excursión modificados con éxito";
            }
            return "No se pudo modificar la excursión";
        }
        return "Error: no existe una excursión con la Id proporcionada";
    }

    @GetMapping("/excursion/destacados")
    public List<Excursion> obtenerDestacados(){
        return excursionDao.findByDestacados();
    }

    @GetMapping("/excursion/creados")
    public List<Excursion> obtenerCreados(){
        return excursionDao.findByActivos();
    }

    @GetMapping("/excursion/terminados")
    public List<Excursion> obtenerTerminado(){
        return excursionDao.findAll().stream().filter(excursion -> "TERMINADO".equalsIgnoreCase(excursion.getEstado())).toList();

    }

    @GetMapping("/excursion/alta")
    public Excursion formularioAlta(){
        return new Excursion();
    }

    @PostMapping("/excursion/alta")
        public String darDeAlta(@RequestBody Excursion nuevaExcursion){
            int resultado=excursionDao.insertOne(nuevaExcursion);
            if (resultado==1){
                return "Excursion dada de alta con exito";
            }
        return "Error ya existe la excursion con ese ID";
    }

}
