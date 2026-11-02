package com.example.gestionexcursiones.config;

import com.example.gestionexcursiones.model.Excursion;
import com.example.gestionexcursiones.repository.ExcursionDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class DataConfig {

    @Bean
    public boolean cargarDatosIniciales(ExcursionDao excursionDao){

        excursionDao.insertOne(new Excursion(
                1, "Visita guiada a la Alhambra", "Granada", "Alhambra", new Date(),
                4, "CREADO", "S", 30, 10, 25.0, "Alhambra.jpg", new Date()
        ));

        excursionDao.insertOne(new Excursion(
                2, "Senderismo Caminito del Rey", "Málaga", "Ardales", new Date(),
                5, "CREADO", "N", 20, 5, 18.5, "Caminito.jpg", new Date()
        ));

        excursionDao.insertOne(new Excursion(
                3, "Ruta del Cares", "León", "Picos de Europa", new Date(),
                8, "TERMINADO", "S", 25, 10, 40.0, "Cares.jpg", new Date()
        ));

        excursionDao.insertOne(new Excursion(
                4, "Senderismo por la Sierra de Grazalema", "Cádiz", "Grazalema", new Date(),
                6, "CANCELADO", "N", 15, 5, 15.0, "Grazalema.jpg", new Date()
        ));

        excursionDao.insertOne(new Excursion(
                5, "Lagos de Covadonga", "Asturias", "Covadonga", new Date(),
                7, "CREADO", "S", 40, 15, 35.0, "Covadonga.jpg", new Date()
        ));

        excursionDao.insertOne(new Excursion(
                6, "Visita al Delta del Ebro", "Tarragona", "Delta del Ebro", new Date(),
                3, "TERMINADO", "N", 50, 20, 12.0, "DeltaEbro.jpg", new Date()
        ));

        return true;
    }
}