package com.example;

public class Main {
    public static void main(String[] args) {
        
        int[] numero = {10, 14, 33, 2};
        int posiciones = numero.length;
        int max = numero[0];
        int min = numero[0];
        int suma = 0;
        int media = 0;
        int fraseInvertida = 0;
        

        for(int i= 0; i< posiciones;i++){
            if (numero[i] > max) { 
                max = numero[i];
            }
            if (numero[i] < min) {
                min = numero[i];
            }
            suma += numero[i];
        }
        media = (  suma / posiciones);
      
        for (int i = numero.length-1; i >= 0; i--) {
            fraseInvertida = numero[i];
            System.out.println(fraseInvertida+",");
        }
        
    }
}