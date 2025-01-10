package com.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        boolean quieresJugar = true;
        
            while (quieresJugar) {
                
                Random random = new Random();
                int numeroAleatorio = random.nextInt(100) + 1; 
                Scanner sc = new Scanner(System.in);

                int intento = 0;
                int numeroIngresado;
                int contadorIntentos = 0;
                String siNo = "n";
        
                System.out.println("Adivina el número del 1 al 100");
        
                while (intento != numeroAleatorio) {
                    System.out.print("Inserte el numero: ");
                    numeroIngresado = sc.nextInt();
                    contadorIntentos++; 
                    
                    if (numeroIngresado < numeroAleatorio) {
                        System.out.println("Demasiado bajo. Intenta de nuevo.");
                    } else if (numeroIngresado > numeroAleatorio) {
                        System.out.println("Demasiado alto. Intenta de nuevo.");
                    } else {
                        System.out.println("Felicidades guapo, has adivinado el número en " + contadorIntentos + " intentos");
                        intento = numeroAleatorio; 
                    }
                }
                    System.out.println("Quieres volver a jugar? s/n");
                    siNo = sc.next();
                    if (siNo == "n" ) {
                        quieresJugar = false;
                    }
            }
        }
}
