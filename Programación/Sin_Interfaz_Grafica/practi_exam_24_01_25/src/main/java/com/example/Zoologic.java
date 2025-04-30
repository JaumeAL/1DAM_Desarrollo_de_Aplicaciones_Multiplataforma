/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package com.example;

import java.util.Random;

//Interficie Terrestre
interface Terrestre {
    void caminar();
}

// Interficie Terrestre
interface Volador {
    void volar();
}

// Interficie Terrestre
interface Aquatic {
    void nedar();
}

// Clase abstracta Animal
abstract class Animal {
    protected String nom;
    protected String tipus;

    public Animal(String nom, String tipus) {
        this.nom = nom;
        this.tipus = tipus;
    }

    public String getTipus() {
        return tipus;
    }

    public void mostrarInformacio() {
        System.out.println("Me llamo: " + nom + " y soy de tipo: " + tipus);
    }

    abstract void emetreSo();

}

// SubClase Gos
class Gos extends Animal implements Terrestre {

    public Gos(String nom) {
        super(nom, "Terrestre");
    }

    @Override
    public void caminar() {
        System.out.println(nom + " : estoy caminando");
    }

    @Override
    public void emetreSo() {
        System.out.println(nom + " :Guau Guau!");
    }
}

// SubClase Àguila
class Àguila extends Animal implements Volador {

    public Àguila(String nom) {
        super(nom, "Volador");
    }

    @Override
    public void volar() {
        System.out.println( nom + " : estoy volando");
    }

    @Override
    public void emetreSo() {
        System.out.println(nom + " :Sshhher!");
    }
}

// SubClase Peix
class Peix extends Animal implements Aquatic {

    public Peix(String nom) {
        super(nom, "Aquatic");
    }

    @Override
    public void nedar() {
        System.out.println( nom + " : estoy nadando");
    }

    @Override
    public void emetreSo() {
        System.out.println(nom + " :Gluugluu!");
    }
}

public class Zoologic {
    private static final int TAMANY_ZOOLOGIC = 10;
        public static void main(String[] args) {
            Random rand = new Random();
            Animal[] animals = new Animal[TAMANY_ZOOLOGIC];
            //Llenar el array de animales de manera random
            for (int i = 0; i < TAMANY_ZOOLOGIC; i++) {
                int tipus = rand.nextInt(3);

                switch (tipus) {
                    case 0:
                        animals[i] = new Gos("Gos " + (i + 1));
                        break;
                    case 1:
                        animals[i] = new Àguila("Àguila " + (i + 1));
                        break;
                    case 2:
                        animals[i] = new Peix("Peix " + (i + 1));
                        break;
                }
            }

            for (int i = 0; i < TAMANY_ZOOLOGIC; i++) {
                Animal animal = animals[i];
                animal.mostrarInformacio();
                animal.emetreSo();
                // Determinar la acción basada en el tipo de anima
                switch (animal.getTipus()) {
                    case "Volador":
                        ((Volador) animal).volar();
                        break;
                    case "Aquatic":
                        ((Aquatic) animal).nedar();
                        break;
                    case "Terrestre":
                        ((Terrestre) animal).caminar();
                        break;
                    default:
                        System.out.println("Accion no definida");
                        break;
                }
                System.out.println();
            }

        }
}