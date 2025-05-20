package org.northpole.workshop.base.models;

import org.northpole.workshop.base.controller.datastruct.list.LinkedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PracticaUno {

    public static void main(String[] args) {
        String archivo = "src/data.txt";
        // PROCESO CON ARREGLO
        long tiempoInicioArreglo = System.nanoTime();
        int capacidadInicial = 1500;

        int[] datos = new int[capacidadInicial];
        int totalLeidos = 0;
        int[][] conteoArreglo = new int[capacidadInicial][2];
        int totalUnicosArreglo = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                int valor = Integer.parseInt(linea.trim());
                if (totalLeidos == datos.length) {
                    int[] ampliado = new int[datos.length * 2];
                    System.arraycopy(datos, 0, ampliado, 0, datos.length);
                    datos = ampliado;
                }
                datos[totalLeidos++] = valor;

                boolean encontrado = false;
                for (int i = 0; i < totalUnicosArreglo; i++) {
                    if (conteoArreglo[i][0] == valor) {
                        conteoArreglo[i][1]++;
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    if (totalUnicosArreglo == conteoArreglo.length) {
                        int[][] nuevoConteo = new int[conteoArreglo.length * 2][2];
                        for (int i = 0; i < conteoArreglo.length; i++) {
                            nuevoConteo[i][0] = conteoArreglo[i][0];
                            nuevoConteo[i][1] = conteoArreglo[i][1];
                        }
                        conteoArreglo = nuevoConteo;
                    }
                    conteoArreglo[totalUnicosArreglo][0] = valor;
                    conteoArreglo[totalUnicosArreglo][1] = 1;
                    totalUnicosArreglo++;
                }
                
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }
        long tiempoFinArreglo = System.nanoTime();
        // ---------------------------------------------------------
        // PROCESO CON LISTA ENLAZADA
        long tiempoInicioLista = System.nanoTime();
        LinkedList<Integer> listaDatos = new LinkedList<>();
        int[][] conteoLista = new int[capacidadInicial][2];
        int totalUnicosLista = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                int valor = Integer.parseInt(linea.trim());
                try {
                    listaDatos.add(valor);
                } catch (Exception e) {
                    System.err.println("Error al agregar valor a la lista: " + e.getMessage());
                }

                boolean encontrado = false;
                for (int i = 0; i < totalUnicosLista; i++) {
                    if (conteoLista[i][0] == valor) {
                        conteoLista[i][1]++;
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    if (totalUnicosLista == conteoLista.length) {
                        int[][] nuevoConteo = new int[conteoLista.length * 2][2];
                        for (int i = 0; i < conteoLista.length; i++) {
                            nuevoConteo[i][0] = conteoLista[i][0];
                            nuevoConteo[i][1] = conteoLista[i][1];
                        }
                        conteoLista = nuevoConteo;
                    }

                    conteoLista[totalUnicosLista][0] = valor;
                    conteoLista[totalUnicosLista][1] = 1;
                    totalUnicosLista++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }
        long tiempoFinLista = System.nanoTime();
        // ---------------------------------------------------------

        // CONTAR NÚMEROS REPETIDOS
        int repetidosEnLista = 0;
        for (int i = 0; i < totalUnicosLista; i++) {
            if (conteoLista[i][1] > 1) {
                repetidosEnLista++;
            }
        }

        int repetidosEnArreglo = 0;
        for (int i = 0; i < totalUnicosArreglo; i++) {
            if (conteoArreglo[i][1] > 1) {
                repetidosEnArreglo++;
            }
        }

        // MOSTRAR RESULTADOS
        System.out.println("\n==============================================");
        System.out.println(" RESULTADOS DE NÚMEROS REPETIDOS EN LAS ESTRUCTURAS ");
        System.out.println("==============================================");
        System.out.println("\tArreglo");
        System.out.println("--> " + repetidosEnArreglo);
        System.out.println("\tLista Enlazada");
        System.out.println("--> " + repetidosEnLista);

        System.out.println("\n==============================================");
        System.out.println("\t\tTIEMPOS DE EJECUCIÓN");
        System.out.println("==============================================\n");
        System.out.printf("Tiempo de ejecución con Arreglos: %.2f ms\n",
                (tiempoFinArreglo - tiempoInicioArreglo) / 1_000_000.0);
        System.out.printf("Tiempo de ejecución con Listas: %.2f ms\n",
                (tiempoFinLista - tiempoInicioLista) / 1_000_000.0);
        System.out.println("==============================================");

    }
}
