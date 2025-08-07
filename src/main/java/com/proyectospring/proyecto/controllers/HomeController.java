package com.proyectospring.proyecto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Esta clase realiza una redirección desde la raíz ("/") hacia "/app/".
// En lugar de usar @RequestMapping, utilizamos @GetMapping para indicar
// que esta redirección responde específicamente a peticiones GET.
// La redirección con "redirect:" provoca una nueva petición HTTP del cliente,
// a diferencia de un forward interno, donde la solicitud no cambia y se transfiere
// el control directamente a otro controlador o vista sin cambiar la URL del navegador.
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // Tambien se puede hacer un forward para mandar directamente a una ruta y no
        // redirigir, al hacer esto no se reinician los valores si no que se hace un
        // dispatch a una ruta. Manteniendo todos los parametros del request
        return "redirect:/app/";

        //Para establecer un main o home, es mejor tener un forward para que no cambie la ruta de esa pagina principal
    }
}
