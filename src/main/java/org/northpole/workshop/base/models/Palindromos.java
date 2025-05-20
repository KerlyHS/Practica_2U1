package org.northpole.workshop.base.models;


import java.util.List;

public class Palindromos {

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();

        buscarPalindromos("src/data.txt");

        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long fin = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución");
        System.out.println((fin - inicio) / 1000.0 + " segundos");
    }

    public static String[] leer(String ruta) {
        StringBuilder contenido = new StringBuilder();
        try {
            java.io.BufferedReader lector = new java.io.BufferedReader(new java.io.FileReader(ruta));
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.trim().matches("\\d+")) {
                    contenido.append(linea.trim()).append(",");
                }
            }
            lector.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return contenido.toString().split(",");
    }

    public static boolean verificarPalindromo(String numero) {
        StringBuilder invertido = new StringBuilder(numero).reverse();
        return numero.equals(invertido.toString());
    }

    public static void buscarPalindromos(String rutaArchivo) {
        String[] numeros = leer(rutaArchivo);
        java.util.List<String> palindromos = new java.util.ArrayList<>();

        for (String num : numeros) {
            if (verificarPalindromo(num)) {
                palindromos.add(num);
            }
        }

        resultados(palindromos);
    }

    public static void resultados(List<String> palindromos) {
        if (!palindromos.isEmpty()) {
            System.out.println("Palíndromos encontrados:");
            System.out.println(String.join(", ", palindromos));
        } else {
            System.out.println("No hay números palíndromos.");
        }
        System.out.println("Contador: " + palindromos.size());
    }
}
