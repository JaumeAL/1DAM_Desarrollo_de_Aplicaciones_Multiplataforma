package com.example;

// Interfície Cordes
interface Cordes {
    void afinarCordes();

    void tocarArpegis();
}

// Interfície Percussio
interface Percussio {
    void afinarTambor();

    void colpejarTambor();
}

// Interfície Vent
interface Vent {
    void afinarVent();

    void ferSonar();
}

// Subclasse Guitarra
class Guitarra extends instrument implements Cordes {
    public Guitarra(String nom) {
        super(nom, "Cordes");
    }

    @Override
    public void afinarCordes() {
        System.out.println(nom + ": Afinant les cordes.");
    }

    @Override
    public void tocarArpegis() {
        System.out.println(nom + ": Tocant un arpegi.");
    }

    @Override
    public void interpretar() {
        System.out.println(nom + ": Tocant una melodia amb la guitarra.");
    }
}

// Subclasse Tambor
class Tambor extends instrument implements Percussio {
    public Tambor(String nom) {
        super(nom, "Percussió");
    }

    @Override
    public void afinarTambor() {
        System.out.println(nom + ": Afinant el tambor.");
    }

    @Override
    public void colpejarTambor() {
        System.out.println(nom + ": Colpejant el tambor.");
    }

    @Override
    public void interpretar() {
        System.out.println(nom + ": Interpretant un ritme amb el tambor.");
    }
}

// Subclasse Flauta
class Flauta extends instrument implements Vent {
    public Flauta(String nom) {
        super(nom, "Vent");
    }

    @Override
    public void afinarVent() {
        System.out.println(nom + ": Afinant la flauta.");
    }

    @Override
    public void ferSonar() {
        System.out.println(nom + ": Fent sonar la flauta.");
    }

    @Override
    public void interpretar() {
        System.out.println(nom + ": Tocant una melodia amb la flauta.");
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        Guitarra guitarra = new Guitarra(" Stratocaster");
        Tambor tambor = new Tambor("Tambor Yamaha");
        Flauta flauta = new Flauta("Flauta travesera");
        
        System.out.println("Bienvenido a mi orquesta");

        System.out.println("\n");
        guitarra.mostrarInformacio();
        guitarra.afinarCordes();
        guitarra.tocarArpegis();
        guitarra.interpretar();

        System.out.println("\n");
        tambor.mostrarInformacio();
        tambor.afinarTambor();
        tambor.colpejarTambor();
        tambor.interpretar();

        System.out.println("\n");
        flauta.mostrarInformacio();
        flauta.afinarVent();
        flauta.ferSonar();
        flauta.interpretar();
    }
}