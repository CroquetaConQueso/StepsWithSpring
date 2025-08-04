package com.proyectospring.proyecto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    // @RequestMapping vincula este método a la URL "/index" (value es un alias de
    // path) y lo asocia al método HTTP GET.
    // GET → Solicita datos al servidor (ej: obtener una página o recurso).
    // POST → Envía datos al servidor (ej: enviar un formulario).
    // PUT → Actualiza un recurso existente en el servidor.
    // DELETE → Elimina un recurso del servidor.
    // @RequestParam indica que se debe recibir un parámetro de la query string
    // (?param=valor)
    // y lo asignará a la variable 'param'.
    //Tengamos en cuenta también que value es basicamente path (es literalmente este)

    //También se podría hacer GetMapping , el cual es una anotación con RequestMapping ya en si
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {

        // Esto devuelve el nombre de la vista (index.html) que Spring buscará en
        // src/main/resources/templates usando el motor de plantillas configurado (p.ej.
        // Thymeleaf)

        model.addAttribute("titulo", "LA EMPRESA WAWA");
        return "index";
    }


}
