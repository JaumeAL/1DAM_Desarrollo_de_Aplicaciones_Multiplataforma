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
class Cotxe extends Vehicle implements interficieConduir,interficieHabitabilitat {
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
        return 180; //velocitat màxima de 180 km/h
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

//Classe Moto
class Moto extends Vehicle implements interficieConduir,interficieHabitabilitat {
    private int capacitat;
    
    public Moto(String nom, int capacitat) {
        super(nom);
        this.capacitat = capacitat >= 2 ? capacitat : 2; //com a mínim 4 places

    }

    @Override
    public void conduir() {
        System.out.println("Estic conduint la moto " + nom + ".");
    }

    @Override
    public int obtenirVelocitatMaxima() {
        return 200; //velocitat màxima de 150 km/h
    }

    @Override
    public void albergarPersones(int nombre) {
        if (nombre <= capacitat) {
            System.out.println("La moto " + nom + " alberga " + nombre + " persones.");
        } else {
            System.out.println("La moto " + nom + " no pot albergar més de " + capacitat + " persones.");
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
        //Cream un cotxe
        Cotxe miCotxe = new Cotxe("Ferrari F40", 5);
        miCotxe.descriure();
        miCotxe.albergarPersones(4);

        //Cream una moto
        Moto miMoto = new Moto("Yamaha R1",2);
        miMoto.descriure();
        miMoto.albergarPersones(2);

    }
}