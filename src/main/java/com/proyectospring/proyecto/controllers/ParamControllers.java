package com.proyectospring.proyecto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;


//Acordarse siempre de que al establecer un Controlador en Springboot debemos de añadir la anotación Controller
@Controller
@RequestMapping("/params")
public class ParamControllers {
    @GetMapping("/string")
    // Para poder obtener un valor por http, vamos a tener que establecer en el
    // parametro que el valor que se va a tomar va a ser tomado por el tipo GET para
    // eso vamos a usar @RequestParam. Tambien en vez de @ResquestParam String
    // texto,
    // se puede hacer RequestParam(name="texto")
    public String param(@RequestParam(required = false, defaultValue = " Algún valor...") String texto, Model model) {
        model.addAttribute("resultado", "El texto empleado es: " + texto);
        return "params/ver";
    }

    // A diferencia de obtener un parametro mediante la accion de escribir en el
    // navegador, en este caso vamos a tomar los parametros mediante el uso del
    // hipervinculo. Estos se podran ver en la clase index dentro de la carpeta
    // params
    @GetMapping("/")
    public String index() {
        return "params/index";
    }

    //Esta vez, vamos a pasar varios parametros en vez de uno, pasando más parametros al método
    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
        //debemos de acordarnos de que para que los valores que pasamos se consideren como un string/texto han de estar con comillas simples
        model.addAttribute("resultado", "Hola: '"+ saludo + "' tu numero es: '"+numero+"'");
        return "params/ver";
    }

    //La toma de valores se puede hacer de otra manera, en este caso con HttpServletRequest
    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model) {
        //Para tomar los parametros podemos hacer:
        String saludo = request.getParameter("saludo");
        Integer numero;
        try{
            numero = Integer.parseInt(request.getParameter("numero")); //Acordarse de poner el nombre de la variable
        }catch(NumberFormatException e){
            numero = 0;
        }
        model.addAttribute("resultado", "Hola: '"+ saludo + "' tu numero es: '"+numero+"'");
        return "params/ver";
    }
}
