// Elejir un unmero del 1 al 7 y dice que dia de la semana es 

package com.example;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true; 
        while (continuar) {
            System.out.println("Dame un número del 1 al 7");
            int dia = sc.nextInt();
            
            switch (dia) {
                case 1:
                    System.out.println("Lunes");
                    break;
                case 2:
                    System.out.println("Martes");
                    break;
                case 3:
                    System.out.println("Miércoles");
                    break;
                case 4:
                    System.out.println("Jueves");
                    break;
                case 5:
                    System.out.println("Viernes");
                    break;
                case 6:
                    System.out.println("Sábado");
                    break;
                case 7:
                    System.out.println("Domingo");
                    break;
                default:
                    System.out.println("Esto no es un día de la semana, mentiroso");
                    break;
            }

            
            if (dia >= 1 && dia <= 7) {
                if (dia < 6) {
                    System.out.println("Entre semana");
                } else {
                    System.out.println("Fin de semana");
                }
            }

           
            System.out.println("¿Quieres continuar? (s/n)");
            char respuesta = sc.next().charAt(0); 
            
            if (respuesta != 's') {
                continuar = false; 
            }
        }

        System.out.println("¡Hasta la próxima!");
    }
}
