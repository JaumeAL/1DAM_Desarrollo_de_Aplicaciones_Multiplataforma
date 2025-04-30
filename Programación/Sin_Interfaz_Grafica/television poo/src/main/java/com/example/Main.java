package com.example;

public class Main {
    public static void main(String[] args) {
        // Tele
        TV teleDelSalon = new TV();
        // Patinetes
        Patin patinete1 = new Patin();
        Patin patinete2 = new Patin();

        System.out.println("---PATINETE1---");
        // Arrancar
        patinete1.arrancar();
        // Apagar
        patinete1.apagar();
        // Volver a arrancar
        patinete1.arrancar();
        // Girar a la derecha x2
        patinete1.girarDerecha();
        patinete1.girarDerecha();
        // Girar a la izquierda x1
        patinete1.girarIzquierda();
        // Acelero x5
        patinete1.acelerar();
        patinete1.acelerar();
        patinete1.acelerar();
        patinete1.acelerar();
        patinete1.acelerar();
        // Desacelero x2
        patinete1.frenar();
        patinete1.frenar();
        // Get
        int miVelocidad = patinete1.getVelocidad();
        System.out.println("Tu velocidad es: " + miVelocidad);
        // Set
        patinete1.setVelocidad(100);
        miVelocidad = patinete1.getVelocidad();
        System.out.println("Tu velocidad es: " + miVelocidad);

        System.out.println("---PATINETE2---");

        patinete1.setNombre("patinete2");
        String nombre = patinete1.getNombre();
        System.out.println(nombre);

    }
}