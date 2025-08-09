package com.proyectospring.proyecto.controllers;

import org.springframework.stereotype.Component;

import com.proyectospring.proyecto.models.services.IServicio;

//Cuando pasamos el mismo metodo o valor a varias posibles clases, ya que debido a la lógica de autowired estas se
//  cargaran automáticamente en el contenedor de Springboot, debemos de especificar que va a donde. Para esto, 
// debemos de usar la anotacion Primary en la clase que deseemos que esta sea la que defina el valor o deberemos de utilizar
// Qualifier en la clase que toma ese valor para especificar que valor va a desear
@Component("storeController") // Cuando son diferentes anotaciones se ha de usar Qualifier ya que Primary solo
                              // funciona si las anotaciones son las mismas, Component con Component,...
public class StoreController implements IServicio {

    // Como podemos ver al intentar ejecutar el servidor, hemos obtenido el error ya
    // que un espacio de nombre esta usando un valor asociado a un metodo el cual
    // tiene dos posibles metodos el cual obtener. Debido a la implementacion de la
    // interfaz IServicio en varias clases. Para evitar estodebemos de establecer
    // cual de estas va a ser la primaria
    private IServicio service;

    @Override
    public String operacion() {
        return "Ejecutando una aplicacion en el store...";
    }
}
