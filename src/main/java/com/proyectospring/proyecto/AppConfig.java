package com.proyectospring.proyecto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proyectospring.proyecto.controllers.StoreController;
import com.proyectospring.proyecto.models.services.IServicio;
import com.proyectospring.proyecto.models.services.Service;

@Configuration("appConfig")
public class AppConfig {

    @Bean("registrarServicio") 
    public IServicio registrarServicio(){
        return new Service();
    }

    @Bean("registrarServicioComplejo")
    public IServicio registrarServicioComplejo(){
        return new StoreController();
    }
}
