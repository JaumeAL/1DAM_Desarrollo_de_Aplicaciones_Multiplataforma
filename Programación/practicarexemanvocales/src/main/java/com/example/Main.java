package com.example;

import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa una frase:");
        String frase = sc.nextLine();
        int contadorVocales = 0;
        int contadorConsonantes = 0;
        boolean salir = true;

        for (int i = 0; i < frase.length(); i++) {
            char c = Character.toLowerCase(frase.charAt(i)); 
            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    contadorVocales++;
                } else {
                    contadorConsonantes++;
                }
            }
        }

        while (salir) {
            System.out.println("---Menu de opciones---");
            System.out.println("1-> mostrar numero de vocales");
            System.out.println("2-> mostrar numero de consonantes");
            System.out.println("3-> Convertir la frase a mayusculas");
            System.out.println("4-> Convertir la frase a minusculas");
            System.out.println("5-> Invertir la frase");
            System.out.println("6-> Salir");
            int opcion = sc.nextInt();
            
    
            switch (opcion) {
                case 1:
                    System.out.println("El numero de vocales es: " + contadorVocales);
                    break;
                case 2:
                    System.out.println("El numero de consonantes es: " + contadorConsonantes);
                    break;
                case 3:
                    System.out.println("Frase a mayusculas: " + frase.toUpperCase());
                    break;
                case 4:
                    System.out.println("Frase a minusculas: " + frase.toLowerCase());
                    break;
                case 5:
                    System.out.println("Frase a minusculas: " + new StringBuilder(frase).reverse().toString());
                    break;
                case 6:
                    System.out.println("Fin del programa... ");
                    salir = false;
                    break;
                default:
                    System.out.println("Opción no valida");
            }
        }
    }
}