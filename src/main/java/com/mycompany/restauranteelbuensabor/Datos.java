/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

import java.util.ArrayList;

/**
 *
 * @author alfre
 */
public class Datos {

    private static ArrayList<Producto> productos = new ArrayList<>();

    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    static {
        productos.add(new Producto("Bandeja Paisa", 32000));
        productos.add(new Producto("Sancocho de Gallina", 28000));
        productos.add(new Producto("Arepa con Huevo", 8000));
        productos.add(new Producto("Jugo Natural", 7000));
        productos.add(new Producto("Gaseosa", 4500));
        productos.add(new Producto("Cerveza Poker", 6000));
        productos.add(new Producto("Agua Panela", 3500));
        productos.add(new Producto("Arroz con Pollo", 25000));
    }

    public static int mesa = 0;
    public static int estado = 0;
    public static double total = 0;
    public static int numeroFactura = 1;
    public static String nombreRestaurante = "El Buen Sabor";
    public static String mensajeTemporal = "";

}
