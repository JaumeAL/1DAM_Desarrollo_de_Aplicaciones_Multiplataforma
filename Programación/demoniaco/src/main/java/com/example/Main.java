package com.example;

interface interficieConduir {
    void conduir();
    int obtenirVelocitatMaxima();
    
}
interface interficieHabitabilitat {
    void albergarPersones(int nombre);
    int obtenirCapacitat();

}
abstract class Vehicle {
    protected String nom;
    
    public Vehicle(String nom) {
        this.nom = nom;
    }
    public void descriure() {
        System.out.println("Soc el vehicle " + nom + ".");
    }
}
//Classe Cotxe
class Cotxe extends vehicle implements interficieConduir,interficieHabitabilitat {
    private int capacitat;
    
    public Cotxe(String nom, int capacitat) {
        super(nom);
        this.capacitat = capacitat >= 4 ? capacitat : 4; //com a mínim 4 places
    }

    @Override
    public void conduir() {
        System.out.println("Estic conduint el cotxe " + nom + ".");
    }

    @Override
    public int obtenirVelocitatMaxima() {
        return 200; //velocitat màxima de 200 km/h
    }

    @Override 
    public void albergarPersones(int nombre) { 
        if (nombre <= capacitat) {
            System.out.println("El cotxe " + nom + " alberga " + nombre + " persones.");
        } else {
            System.out.println("El cotxe " + nom + " no pot albergar més de " + capacitat + " persones.");
        }
    }

    @Override
    public int obtenirCapacitat() {
        return capacitat;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        cotxe miCotxe = new Cotxe("Ferrari F40", 5);
        miCotxe.descriure();
        miCotxe.albergarPersones(4);

    }
}