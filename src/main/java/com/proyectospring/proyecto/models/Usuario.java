package com.proyectospring.proyecto.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Usuario {
    @Value("${usuario.nombre}")
    private String nombre;
    @Value("${usuario.apellido}")
    private String apellido;
    private String email;

    public Usuario(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Usuario(){}

    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getEmail(){
        return this.email;
    }
    
    public void setApellido (String apellido){
        this.apellido = apellido;
    }
    public String getApellido(){
        return this.apellido;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
