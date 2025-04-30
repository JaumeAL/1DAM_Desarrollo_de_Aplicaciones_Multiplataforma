/**************************************/
/* Nom: Jaume Salas Pastor            */
/* DNI/NIE: 451 917 32K               */
/* Data: 14 10 2024                   */
/* Exercici: PROU2EX02                */
/**************************************/
package com.example;

import java.util.Scanner; // Importamos la librería Scanner.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double primerNumero = 0;
        double segundoNumero = 0;

        for (int i = 0; i < 5; i++) {
            // Bucle que permite continuar hasta que el usuario decida salir.
            System.out.println("Menú de opciones: "); // Mostramos el menú de opciones.
            System.out.println("1-> Sumar");
            System.out.println("2-> Restar");
            System.out.println("3-> Multiplicar");
            System.out.println("4-> Dividir");
            System.out.println("5-> Salir");
            System.out.println("Elige una opción : "); // Pedimos al usuario que ingrese una opción del 1 al 5.
            int opcion = sc.nextInt(); // Lo que ingrese el usuario será el valor de "opcion".

            switch (opcion) { // El programa ejecutará la opción que elija el usuario.
                case 1:
                    System.out.print("Introduce el primer número a sumar: "); // Pedimos al usuario que ingrese el primer número a calcular.
                    primerNumero = sc.nextInt(); // Lo que ingrese el usuario será el valor de "primerNumero".
                    System.out.print(primerNumero + " Sumado por: "); // Pedimos al usuario que ingrese el segundo número a calcular.
                    segundoNumero = sc.nextInt(); // Lo que ingrese el usuario será el valor de "segundoNumero".
                    System.out.println(primerNumero +" + "+  segundoNumero + " = " + (primerNumero + segundoNumero)); // En la primera opción se sumarán los dos números.
                    break;
                case 2:
                    System.out.print("Introduce el primer número a restar: "); // Pedimos al usuario que ingrese el primer número a calcular.
                    primerNumero = sc.nextInt(); // Lo que ingrese el usuario será el valor de "primerNumero".
                    System.out.print(primerNumero + " Restado por: "); // Pedimos al usuario que ingrese el segundo número a calcular.
                    segundoNumero = sc.nextInt(); // Lo que ingrese el usuario será el valor de "segundoNumero".
                    System.out.println(primerNumero +" - "+  segundoNumero + " = " + (primerNumero - segundoNumero)); // En la segunda opción se restarán los números.
                    break;
                case 3:
                    System.out.print("Introduce el primer número: "); // Pedimos al usuario que ingrese el primer número a calcular.
                    primerNumero = sc.nextInt(); // Lo que ingrese el usuario será el valor de "primerNumero".
                    System.out.print(primerNumero + " Multiplicado por: "); // Pedimos al usuario que ingrese el segundo número a calcular.
                    segundoNumero = sc.nextInt(); // Lo que ingrese el usuario será el valor de "segundoNumero".
                    System.out.println(primerNumero +" * "+  segundoNumero + " = " + (primerNumero * segundoNumero)); // En la tercera opción se multiplicarán los números.
                    break;
                case 4:
                    System.out.print("Introduce el primer número: "); // Pedimos al usuario que ingrese el primer número a calcular.
                    primerNumero = sc.nextInt(); // Lo que ingrese el usuario será el valor de "primerNumero".
                    System.out.print(primerNumero + " Dividido por: "); // Pedimos al usuario que ingrese el segundo número a calcular.
                    segundoNumero = sc.nextInt(); // Lo que ingrese el usuario será el valor de "segundoNumero".
                    if (segundoNumero != 0) { // En la cuarta opción, si el segundo número no es cero, se dividirá el primer número por el segundo.
                        System.out.println(primerNumero +" / "+  segundoNumero + " = " + (primerNumero / segundoNumero));
                    } else {
                        System.out.println("No se puede dividir :("); // Si no, no se dividirá.
                    }
                    break;
                case 5:
                    i = 5; // Si el usuario elige el caso 5 "i" tendrá el valor de 5, por lo que el bucle finalizará.
                    System.out.println("Fin del programa :( ");
                    break; // Break para finalizar la ejecución del bucle.
                default:
                    System.out.println("Opción no válida.");
                    i = 5; // Opción predeterminada para salir en caso de error.
                    break;
            }
            if (i < 4) { // Controlamos que el mensaje de "Deseas realizar otra..." no salga despues de las 5 operaciones que nos deja hacer el bucle.
                System.out.println("¿Deseas realizar otra operación? S/N"); // Preguntamos al usuario si desea realizar otra operación.
                char continuar = sc.next().charAt(0); // Leemos la primera letra de la respuesta.
                if (continuar == 'N' || continuar == 'n') { // Aceptamos mayúscula y minúscula.
                    i = 5; // Si el usuario elige 'N', se cierra el programa.
                    System.out.println("Fin del programa.");
                }
            }
        }
    }
}