/**************************************/
/* Nom: Jaume Salas Pastor 			  */
/* DNI/NIE: 451 917 32K 			  */
/* Data: 10 10 2024 				  */
/* Exercici: PROU2EX01				  */
/**************************************/

package com.example;

import java.util.Scanner; //Importar librería scanner.

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); //Declarar Scanner "sc".
        
        int numero = 0; //Declarar variable "numero" y le damos un valor inical de 0.

        System.out.print("Intoduce un numero entero positivo: "); //Le pedimos un número al usuario.
        numero = sc.nextInt(); //Cambiamos el valor de "numero" por lo que inserte el usuari gracias al Scanner.
        
        for (int i =1; i <= numero; i++){ //Bucle que recorre desde "1", se incrementa en uno hasta llegar al número del usuario.
            if (i % 2 == 0) { 
                System.out.println(i + " Par"); // Si el resto de la división del numero es igual a cero, imprime ese numero y muestra que es par.
            }else{
                System.out.println(i + " Impar"); // Sino, imprime el numero y muestra que es impar.
            }
        } 
    }
}