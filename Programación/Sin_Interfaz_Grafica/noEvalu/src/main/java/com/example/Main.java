package com.example;

public class Main {
    public static void main(String[] args) {
        int tamanyArray = 0;
        int valorMax = 0;
        int posicioMax = 0;
        int posicioMin = 0;
        int valorMin = 10000;
        int valorMedio = 0;
        int sumaArray = 0;

        int[] miArray = { 10, 3, 30, 54, 2, 43, 60, 20 };

        tamanyArray = miArray.length;

        for (int i = 0; i < tamanyArray; i++) {
            if (miArray[i] > valorMax) {
                valorMax = miArray[i];
                posicioMax = i;
            }
            if (miArray[i] < valorMin) {
                valorMin = miArray[i];
                posicioMin = i;
            }
            sumaArray += miArray[i];
            
            
            
            
        }
        System.out.println("El valor maximo es " + valorMax + " que esta en la posicion " + posicioMax);
        System.out.println("El valor Minimo es " + valorMin + " que esta en la posicion " + posicioMin);
        System.out.println("El valor Medio es " + valorMedio);

    }

}