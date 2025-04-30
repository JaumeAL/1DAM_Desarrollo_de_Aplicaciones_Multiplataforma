package com.example;

public class Main {
    public static void main(String[] args) {

        int[][] matriu = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        int filas = matriu.length;
        int columnas = 0;
        int suma = 0;
        int media = 0;
        int celdas = 0;
        int max = 0;
        int min = 10000;

        for (int i = 0; i < filas; i++) {
            columnas = matriu[i].length;

            for (int j = 0; j < columnas; j++) {
                suma += matriu[i][j];
                celdas = filas * columnas;
                media = suma / celdas;

                if (matriu[i][j] > max) {
                    max = matriu[i][j];
                }
                if (matriu[i][j] < min) {
                    min = matriu[i][j];
                }
            }
        }
        System.out.println("La suma es: " + suma);
        System.out.println("La media es:" + media);
        System.out.println("El valor maximo es: " + max);
        System.out.println("El valor minimo es: " + min);
    }
}