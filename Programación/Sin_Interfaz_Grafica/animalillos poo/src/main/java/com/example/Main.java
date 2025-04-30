package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido");

        animal Animal = new animal(15);
        animal scooby = new perro(88);
        animal garfild = new gato(20);

        Animal.hazRuido();
        //PERRO
        scooby.hazRuido();
        double pesoPerro = scooby.getPeso();
        System.out.println(pesoPerro);

        //GATO
        garfild.hazRuido();
        double pesoGato = garfild.getPeso();
        System.out.println(pesoGato);


    }
}