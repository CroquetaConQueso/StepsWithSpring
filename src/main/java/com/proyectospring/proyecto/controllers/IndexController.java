package com.proyectospring.proyecto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app") // Cuando se establece esto como anotación de la clase se esta estableciendo que
                        // esto va a ser una ruta comun para este controlador, proporcionandola a todos
                        // los métodos miembros de esta clase. Estableciendo esta como ruta de primer
                        // nivel mientras que las rutas establecidas en los metodos serían de segundo
                        // nivel
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
    // Tengamos en cuenta también que value es basicamente path (es literalmente
    // este)

    // También se podría hacer GetMapping , el cual es una anotación con
    // RequestMapping ya en si, si no se puede usr RequestMethod como use con anterioridad
    @GetMapping(value = { "/index", "/", "/home" })
    public String index(Model model) {

        // Esto devuelve el nombre de la vista (index.html) que Spring buscará en
        // src/main/resources/templates usando el motor de plantillas configurado (p.ej.
        // Thymeleaf)

        model.addAttribute("titulo", "LA EMPRESA WAWA");
        // Se tiene que tener en cuenta de que cuando se está trabajando con un espacio
        // de nombre se ha de establecer que valores este va a poder leer, ya que los
        // espacios de nombre no se cargaran si no se establece que tambien toma la raiz

        // Model es una interfaz mientras que ModelMap es una class, esta implementa
        // .map de java por lo que nos permite utilizar las capacidades de esta interfaz
        // funcional
        return "index";
    }

}
