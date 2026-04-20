/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.restauranteelbuensabor;

import java.util.Scanner;

/**
 *
 * @author alfre
 */
public class RestauranteElBuenSabor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean ejecutando = true;

        imprimirEncabezado();

        while (ejecutando) {
            mostrarMenu();
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Imprimir.mostrarCarta();
                    break;

                case 2:
                    agregarProducto(sc);
                    break;

                case 3:
                    verPedido();
                    break;

                case 4:
                    generarFactura();
                    break;

                case 5:
                    nuevaMesa();
                    break;

                case 0:
                    ejecutando = false;
                    System.out.println("Hasta luego!");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

            System.out.println();
        }

        sc.close();
    }

    // ================= MÉTODOS =================

    private static void imprimirEncabezado() {
        System.out.println("========================================");
        System.out.println("    " + Datos.nombreRestaurante);
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println("========================================");
    }

    private static void mostrarMenu() {
        System.out.println("1. Ver carta");
        System.out.println("2. Agregar producto al pedido");
        System.out.println("3. Ver pedido actual");
        System.out.println("4. Generar factura");
        System.out.println("5. Nueva mesa");
        System.out.println("0. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
    }

    private static void agregarProducto(Scanner sc) {

        System.out.println("--- AGREGAR PRODUCTO ---");
        System.out.print("Numero de producto (1-" + Datos.getProductos().size() + "): ");
        int numero = sc.nextInt();

        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();

        if (numero <= 0 || numero > Datos.getProductos().size()) {
            System.out.println("Producto no existe.");
            return;
        }

        if (cantidad <= 0) {
            System.out.println("Cantidad invalida.");
            return;
        }

        if (Datos.estado == 0) {
            System.out.print("Ingrese numero de mesa: ");
            Datos.mesa = sc.nextInt();

            if (Datos.mesa <= 0) {
                Datos.mesa = 1;
            }

            Datos.estado = 1;
        }

        Producto p = Datos.getProductos().get(numero - 1);
        p.setCantidad(p.getCantidad() + cantidad);

        System.out.println("Producto agregado:");
        System.out.println("  -> " + p.getNombre() + " x" + cantidad);
    }

    private static void verPedido() {
        if (Utilidades.validar()) {
            Imprimir.mostrarPedido();
        } else {
            System.out.println("No hay productos en el pedido.");
        }
    }

    private static void generarFactura() {
        if (Utilidades.validar()) {
            Proceso.hacerTodo();
            Imprimir.imprimirFacturaCompleta();
        } else {
            System.out.println("No hay productos para facturar.");
        }
    }

    private static void nuevaMesa() {
        Utilidades.reiniciar();
        System.out.println("Mesa reiniciada.");
    }
}
