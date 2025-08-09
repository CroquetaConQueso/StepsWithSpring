package com.proyectospring.proyecto.models;


public class ItemFactura {
    private Product producto;
    private Integer cantidad;

    public ItemFactura(Product product, int cantidad){
        this.producto = product;
        this.cantidad = cantidad;
    }

    public ItemFactura(){}

    public Product getProducto(){
        return this.producto;
    }
    public void setProducto(Product producto){
        this.producto = producto;
    }

    public Integer getCantidad(){
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad){
        this.cantidad = cantidad;
    }
}
