/**************************************/
/* Nom: Jaume Salas Pastor            */
/* DNI/NIE: 451 917 32K               */
/* Data: 25 10 2024                   */
/* Exercici: PROU2EX03                */
/**************************************/
package com.example;

import java.util.Scanner; // Importamos la librería Scanner.

public class Main {

    //---Declaración de constantes de conversión.---
    private static final double USD_EUR = 0.85; 
    private static final double USD_MXN = 20;   
    private static final double EUR_USD = 1.18;
    private static final double EUR_MXN = 23.50;
    private static final double MXN_USD = 0.05;    
    private static final double MXN_EUR = 0.042;   
    private static final double EUR_PTS = 166.386;
    private static final double PTS_EUR = 0.006; 
    private static final double USD_PTS = 141.43;  
    private static final double PTS_USD = 0.00709; 
    private static final double MXN_PTS = 7.08;    
    private static final double PTS_MXN = 0.1412;  

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creamos el objeto Scanner para recibir input del usuario.
        
        double valor = 0;     // Variable para guardar el valor a convertir.
        boolean salir = true; // Controla la ejecución del bucle principal.

        // Bucle que muestra el menú de opciones mientras "salir" sea true.
        while (salir) { 
            System.out.println("----CONVERSOR DE MONEDAS----");
            System.out.println("Menú de opciones:");
            System.out.println("1-> Dólar a Euros");
            System.out.println("2-> Dólar a Pesos Mexicano");
            System.out.println("3-> Euros a Dólar");
            System.out.println("4-> Euros a Pesos Mexicano");
            System.out.println("5-> Pesos Mexicano a Dólar");
            System.out.println("6-> Pesos Mexicano a Euros");
            System.out.println("7-> Euros a Pesetas");
            System.out.println("8-> Pesetas a Euros");
            System.out.println("9-> Dolar a Peseta");
            System.out.println("10-> Peseta a Dolar");
            System.out.println("11-> Pesos Mexicano a Peseta");
            System.out.println("12-> Peseta a Pesos Mexicano");
            System.out.println("13-> Salir");

            int opcion = sc.nextInt(); // Recibimos la opción del usuario.

            switch (opcion) { // En cada caso, si el valor es mayor que 0, hará la conversión; si no, no.
                case 1:
                    System.out.print("Introduce el valor en Dólares: ");
                    valor = sc.nextInt();
                    if (valor > 0) {
                        System.out.println(valor + " USD son " + (valor * USD_EUR) + " EUR");
                    } else {
                        System.out.println("Valor incorrecto, prueba con otro valor");
                    }
                    break;

                case 2:
                    System.out.print("Introduce el valor en Dólares: ");
                    valor = sc.nextInt();
                    if (valor > 0) {
                        System.out.println(valor + " USD son " + (valor * USD_MXN) + " MXN");
                    } else {
                        System.out.println("Valor incorrecto, prueba con otro valor");
                    }
                    break;

                case 3:
                    System.out.print("Introduce el valor en Euros: ");
                    valor = sc.nextInt();
                    if (valor > 0) {
                        System.out.println(valor + " EUR son " + (valor * EUR_USD) + " USD");
                    } else {
                        System.out.println("Valor incorrecto, prueba con otro valor");
                    }
                    break;

                case 4:
                    System.out.print("Introduce el valor en Euros: ");
                    valor = sc.nextInt();
                    if (valor > 0) {
                        System.out.println(valor + " EUR son " + (valor * EUR_MXN) + " MXN");
                    } else {
                        System.out.println("Valor incorrecto, prueba con otro valor");
                    }
                    break;

                case 5:
                    System.out.print("Introduce el valor en Pesos Mexicanos: ");
                    valor = sc.nextInt();
                    if (valor > 0) {
                        System.out.println(valor + " MXN son " + (valor * MXN_USD) + " USD");
                    } else {
                        System.out.println("Valor incorrecto, prueba con otro valor");
                    }
                    break;

                case 6:
                    System.out.print("Introduce el valor en Pesos Mexicanos: ");
                    valor = sc.nextInt();
                    if (valor > 0) {
                        System.out.println(valor + " MXN son " + (valor * MXN_EUR) + " EUR");
                    } else {
                        System.out.println("Valor incorrecto, prueba con otro valor");
                    }
                    break;

                case 7:
                    System.out.print("Introduce el valor en Euros: ");
                    valor = sc.nextInt();
                    if (valor > 0) {
                        System.out.println(valor + " EUR son " + (valor * EUR_PTS) + " PTS");
                    } else {
                        System.out.println("Valor incorrecto, prueba con otro valor");
                    }
                    break;

                case 8:
                    System.out.print("Introduce el valor en Pesetas: ");
                    valor = sc.nextInt();
                    if (valor > 0) {
                        System.out.println(valor + " PTS son " + (valor * PTS_EUR) + " EUR");
                    } else {
                        System.out.println("Valor incorrecto, prueba con otro valor");
                    }
                    break;

                case 9:
                    System.out.print("Introduce el valor en Dólares: ");
                    valor = sc.nextInt();
                    if (valor > 0) {
                        System.out.println(valor + " USD son " + (valor * USD_PTS) + " PTS");
                    } else {
                        System.out.println("Valor incorrecto, prueba con otro valor");
                    }
                    break;

                case 10:
                    System.out.print("Introduce el valor en Pesetas: ");
                    valor = sc.nextInt();
                    if (valor > 0) {
                        System.out.println(valor + " PTS son " + (valor * PTS_USD) + " USD");
                    } else {
                        System.out.println("Valor incorrecto, prueba con otro valor");
                    }
                    break;

                case 11:
                    System.out.print("Introduce el valor en Pesos Mexicanos: ");
                    valor = sc.nextInt();
                    if (valor > 0) {
                        System.out.println(valor + " MXN son " + (valor * MXN_PTS) + " PTS");
                    } else {
                        System.out.println("Valor incorrecto, prueba con otro valor");
                    }
                    break;

                case 12:
                    System.out.print("Introduce el valor en Pesetas: ");
                    valor = sc.nextInt();
                    if (valor > 0) {
                        System.out.println(valor + " PTS son " + (valor * PTS_MXN) + " MXN");
                    } else {
                        System.out.println("Valor incorrecto, prueba con otro valor");
                    }
                    break;

                case 13:
                    System.out.println("Fin del programa :("); // Termina la ejecución del programa.
                    salir = false;
                    break;

                default:
                    System.out.println("Opción no válida :("); // Mensaje en caso de valor incorrecto.
                    salir = false;
                    break;
            }

        }
    }
}
