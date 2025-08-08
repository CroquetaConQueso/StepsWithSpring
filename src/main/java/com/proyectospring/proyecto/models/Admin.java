package com.proyectospring.proyecto.models;

public class Admin {
        private String name;
    private double cash;

    public Admin(String name, double cash){
        this.name = name;
        this.cash = cash;
    }

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
}
