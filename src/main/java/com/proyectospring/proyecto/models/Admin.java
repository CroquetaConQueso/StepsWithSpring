package com.proyectospring.proyecto.models;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Admin {
    private String name;
    private double cash;

    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public Admin(String name, double cash){
        this.name = name;
        this.cash = cash;
    }

    public Admin(){}

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    
    public double getCash(){
        return this.cash;
    }

    public void setCash(double cash){
        this.cash = cash;
    }

    public ArrayList<Usuario> getLista(){
        return listaUsuarios;
    }
}
