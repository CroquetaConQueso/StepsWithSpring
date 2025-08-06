package com.proyectospring.proyecto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/variables")
public class PathVariables {

    @GetMapping("/string/{texto}")
    // Utilizamos PathVariable por que vamos a obtener un tramo/etapa variable,
    // acordarse de que el nombre del parametro sea igual al nombre de la variable
    // pasada como argumento a la anotacion
    public String variables(@PathVariable String texto, Model model) {
        model.addAttribute("titulo", "Recibir parametros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado en la ruta es: "+texto);
        return "variables/ver";
    }

}
