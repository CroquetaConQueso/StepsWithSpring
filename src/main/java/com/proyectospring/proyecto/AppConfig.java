package com.proyectospring.proyecto;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proyectospring.proyecto.controllers.StoreController;
import com.proyectospring.proyecto.models.Factura;
import com.proyectospring.proyecto.models.ItemFactura;
import com.proyectospring.proyecto.models.Product;
import com.proyectospring.proyecto.models.Usuario;
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

    @Bean("devolverFactura")
    public List<ItemFactura> devolverFactura(){

        ItemFactura ifo = new ItemFactura( new Product("Comida Gato",20.0f),4);
        ItemFactura ifa = new ItemFactura( new Product("Comida Perra",30.0f),5);
        ItemFactura ife = new ItemFactura( new Product("Comida Rata",40.0f),3);

        Factura f = new Factura("Factura de las comidas", new Usuario("Carlos","Torres"));
        f.getItemFactura().add(ifo);
        f.getItemFactura().add(ifa);
        f.getItemFactura().add(ife);
        
        return f.getItemFactura();
        
    }
}
