/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Proceso {

    public static double hacerTodo() {

        final double iva = 0.19;
        final double propina = 0.10;
        final double descuento = 0.05;
        final double limitePropina = 50000;
        final int limiteProductos = 3;

        double subtotal = 0;
        int cantidadItems = 0;
        int i = 0;

        while (i < Datos.getProductos().size()) {

            Producto prod = Datos.getProductos().get(i);

            if (prod.getCantidad() > 0) {
                subtotal += prod.getPrecio() * prod.getCantidad();
                cantidadItems++;
            }

            i++;
        }

        double base = subtotal;

        if (cantidadItems > limiteProductos && subtotal > 0) {
            base = subtotal - (subtotal * descuento);
        }

        double total = base + (base * iva);

        if (base > limitePropina) {
            total += total * propina;
        }

        Datos.estado = 1;
        Datos.total = total;

        return total;
    }

    public static double procesar(
            double precio,
            double cantidad,
            double descuento,
            double ivaPorcentaje,
            double propinaPorcentaje,
            int numeroProductos,
            boolean aplicaPropina
    ) {

        double resultado = precio * cantidad;

        if (descuento > 0) {
            resultado -= resultado * descuento;
        }

        double iva = resultado * ivaPorcentaje;
        resultado += iva;

        if (aplicaPropina) {
            double propina = resultado * propinaPorcentaje;
            resultado += propina;
        }

        if (numeroProductos > 3) {
            resultado -= resultado * 0.01;
        }

        return resultado;
    }
}