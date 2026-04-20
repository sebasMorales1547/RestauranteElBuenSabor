/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Utilidades {

    public static double calcular(
            double precio,
            double cantidad,
            double descuento,
            double ivaPorcentaje,
            double propinaPorcentaje,
            int numeroItems,
            boolean aplicaPropina
    ) {

        double resultado = precio * cantidad;

        if (descuento > 0) {
            resultado -= resultado * descuento;
        }

        double iva = resultado * ivaPorcentaje;
        resultado += iva;

        if (aplicaPropina) {
            resultado += resultado * propinaPorcentaje;
        }

        System.out.println(Datos.nombreRestaurante + " - calculo aplicado");

        return resultado;
    }

    public static boolean validar() {
        int cont = 0;
        int i = 0;

        while (i < Datos.getProductos().size()) {

            Producto prod = Datos.getProductos().get(i);

            if (prod.getCantidad() > 0) {
                cont++;
            }

            i++;
        }

        return cont > 0;
    }

    public static void reiniciar() {

        int i = 0;

        while (i < Datos.getProductos().size()) {
            Datos.getProductos().get(i).setCantidad(0);
            i++;
        }

        Datos.total = 0;
        Datos.estado = 0;
        Datos.mesa = 0;
        Datos.mensajeTemporal = "";
    }
}