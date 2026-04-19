package com.mycompany.restauranteelbuensabor;

public class Producto {

    String nombre;
    double precio;
    int cantidad;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = 0;
    }
}