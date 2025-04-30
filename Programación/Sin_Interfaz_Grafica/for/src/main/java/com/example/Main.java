package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean repetir = true;
        
        while (repetir) {
            
            Scanner sc = new Scanner(System.in);
    
            int numero = 0 ;
    
            System.out.print("Intoduce un numero: ");
            numero = sc.nextInt();
    
            int suma = 0;
            int contador = 0;
            String noRepetir;
    
            for (int i =1; i <= numero; i++){
                
                if (i % 2 == 0) {
                    System.out.println(i);
                    suma +=i;
                    contador ++;
                }
            } 
            
            if (numero <= 0) {
                System.out.println("Numero no valido.");
            } else {
                System.out.println("Suma de pares: " + suma);
                System.out.println("Total de pares: " + contador);
            }

            System.out.println("Volver a jugar? S/N : ");
            noRepetir = sc.next();

            if (noRepetir.equals("n") ) {
                repetir = false;
            }
        }
         

    }
}