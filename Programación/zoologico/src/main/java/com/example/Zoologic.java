package com.example;

import java.util.Random;


//Interficie Terrestre
interface Terrestre {
    void caminar();
}
//Interficie Volador
interface Volador {
    void volar();
}
//Interficie Aquatic
interface Aquatic {
    void nedar();
}

//Clase abstracta Animal
abstract class Animal {
    protected String nom;
    protected String tipus;

    public Animal(String nom, String tipus){ // Constructor de la clse Animal
        this.nom = nom;
        this.tipus = tipus;
    }
    public String getTipus() {
        return tipus;
    }
    public void mostrarInformacio(){ //Metodo que muestra el nombre y tipo del animal
        System.out.println("Me llamo:"+nom +" y soy de tipo: "+ tipus);
    }

    abstract public void emetreSo(); //Metodo abstacto que cada animal implementará con su sonido especifico
    
}  
//Clase Gos, es un mamifero terrestre
class Gos extends Animal implements Terrestre{

    public Gos(String nom) { //Constructor
        super(nom, "Terrestre");
    }

    @Override
    public void caminar() { //Metodo de la interficie caminar para el perro
        System.out.println("soy el perro "+nom+ " y estoy caminano");        
    }
    @Override
    public void emetreSo() { //Metodo emitir sonido para el perro
        System.out.println("Bup bup");        
    }
} 
//Clase Àguila, es un mamifero terrestre
class Àguila extends Animal implements Volador{

    public Àguila(String nom) { //Constructor
        super(nom, "Volador");
    }

    @Override
    public void volar() { //Metodo de la iterficie volar para el aguila
        System.out.println("soy el aguila "+nom+ " y estoy volando");        
    }
    @Override
    public void emetreSo() { //Metodo emitir sonido para el aguila
        System.out.println("Screech");        
    }
} 
//Clase Peix, es un mamifero terrestre
class Peix extends Animal implements Aquatic{

    public Peix(String nom) { //Constructor
        super(nom, "Aquatic");
    }

    @Override
    public void nedar() { //Metodo de la iterficie volar para el pez
        System.out.println("soy el pez "+nom+ " y estoy volando");        
    }
    @Override
    public void emetreSo() { //Metodo emitir sonido para el pez
        System.out.println("Blub blub");        
    }
} 


// Clase principal Zoologic
public class Zoologic {
    private static final int TAMANY_ZOOLOGIC = 10; // Tamaño del zoológico

    public static void main(String[] args) {
        Animal[] animals = new Animal[TAMANY_ZOOLOGIC];
        Random rand = new Random();

        // Crear animales aleatorios y agregarlos al array
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

        // Recorrer el array y hacer actuar a los animales
        for (int i = 0; i < TAMANY_ZOOLOGIC; i++) {
            Animal animal = animals[i];
            animal.mostrarInformacio();
            animal.emetreSo();

            // Determinar la acción basada en el tipo de animal
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
                    System.out.println("Acció no definida per aquest tipus d'animal.");
            }

            System.out.println(); // Separador entre animales
        }
    }
}