package com.proyectospring.proyecto.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectospring.proyecto.models.Admin;
import com.proyectospring.proyecto.models.Factura;
import com.proyectospring.proyecto.models.Product;
import com.proyectospring.proyecto.models.Usuario;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;



@Controller
@RequestMapping
public class SecondController {

    @Autowired
    private Factura factura;
    private Product producto;
    private Admin admin;

    @GetMapping("/wiwi")
    public String index(Model model) {
        ArrayList<Product> listaProducts = new ArrayList<>();
        ArrayList<Admin> listaAdmins = new ArrayList<>();

        listaProducts.add(new Product("Cafe",20.2));
        listaProducts.add(new Product("Chocolate",2.27));
        listaProducts.add(new Product("Tostada",15.4));
        listaAdmins.add(new Admin("Gil", 200));
        listaAdmins.add(new Admin("Marco", 300));
        listaAdmins.add(new Admin("Carmen", 20));

        model.addAttribute("listillaproducts",listaProducts);
        model.addAttribute("listaadmins", listaAdmins);

        producto = new Product("Roca", 3);
        
        model.addAttribute("producto",producto);

        return "wiwi";
    }

    @GetMapping("/factura")
    public String ver(Model model) {

        model.addAttribute("factura",factura);
        model.addAttribute("titulo","Ejemplo Factura con inyección de dependencias");

        return "factura";
    }
    
    @ModelAttribute("admin")
    public Admin mainAdmin(){
        admin = new Admin("Carlos", 4000);

        admin.getLista().add(new Usuario("Jose","Martin"));
        admin.getLista().add(new Usuario("Miriam","Pepi"));
        admin.getLista().add(new Usuario("Mari","Lo"));

        return admin;
    }
}
