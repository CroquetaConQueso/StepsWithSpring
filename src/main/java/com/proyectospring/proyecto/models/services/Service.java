package com.proyectospring.proyecto.models.services;

import org.springframework.stereotype.Component;

// Al añadir la anotación @Component, esta clase se registra como un bean dentro del contenedor de Spring.
// Esto permite que Spring la instancie automáticamente y la inyecte donde se necesite.
// También es posible usar anotaciones más específicas como @Service para indicar que esta clase representa
// una capa de servicio, lo cual ayuda a la legibilidad y a la organización del código.
// A estos componentes se les puede dar un identificador / id con un parentesis y un string dentro de este

// Para añadir, una clase Component tiene que tener unas ciertas características como por ejemplo un constructor vacio, como no tenemos uno, lo va a tomar por defecto. 
// Si tenemos un constructor con valores, tendremos que tener uno sin parametros, si no lanzará error

// Component es para controladores MVC, Service para servicios de logica de negocio, Repository para DAOs. Componentes y beans son lo mismo. 
// Cualquier component bajo el package base(es decir tienen Component) deben de estar instanciados y manejados por el contenedor DI de Spring.
// Por eso debemos de tener siempre estas anotadas, y en paquete o el subpaquete donde el main se encuentra


// Se puede establecer un @Bean a un constructor o metodo para que todas estas creaciones devuelvan / conviertan esto en un bean.
// Permitiendo registrar estos objetos en el contenedor y usando por supuesto new.

@Component("miServicioSimple")
public class Service implements IServicio {

    @Override
    public String operacion() {
        return "ejecutando algun proceso importante";
    }
}
