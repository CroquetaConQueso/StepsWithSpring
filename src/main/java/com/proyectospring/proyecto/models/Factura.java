package com.proyectospring.proyecto.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Factura {
    @Value("${factura.descripcion}")
    private String descripcion;

    @Autowired
    private Usuario usuario;
    // Una lista puede estar dentro de un @Component o declararse como @Bean,
    // dependiendo de su uso.
    //
    // 1) Si la lista es parte del estado interno del objeto (por ejemplo, los
    // usuarios que gestiona un Admin),
    // se declara directamente como propiedad de la clase con @Component.
    // En este caso, la lista solo es accesible a través de la instancia de ese
    // componente.
    //
    // 2) Si la lista debe estar disponible para inyección de forma independiente en
    // otros beans,
    // se declara como @Bean en una clase @Configuration.
    // Esto permite inyectarla directamente con @Autowired sin depender de otro
    // objeto.
    //
    // Regla práctica:
    // - Dentro de un @Component → cuando forma parte natural de ese objeto.
    // - Como @Bean → cuando es un recurso compartido entre varios componentes.

    @Autowired
    @Qualifier("devolverFactura")
    private List<ItemFactura> items;

    public Factura(String descripcion,Usuario usuario){
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.items = new ArrayList<>();
    }

    public Factura(){}

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemFactura> getItemFactura() {
        return this.items;
    }
}
