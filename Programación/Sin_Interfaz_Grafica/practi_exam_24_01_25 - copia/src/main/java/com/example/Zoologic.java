/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package com.example;

import java.util.Random;

interface Terrestre{
    void caminar();
}
interface Volador{
    void volar();
}
interface Acuatic{
    void nedar();
}


abstract class Animal{
    protected String nom;
    protected String tipus;
    public Animal(String nom,String tipus){
        this.nom = nom;
        this.tipus = tipus;
    }
    public String getTipus() {
        return tipus;
    }
    public void mostrarInformacio(){
        System.out.println(nom+" y soy de tipo: "+tipus);
    }
    abstract void emetreSo();
}
class Gos extends Animal implements Terrestre{
    public Gos(String nom,String tipus){
        super(nom, "Terrestre");
    }
    @Override
    public void caminar(){
        System.out.println(nom+" : Estic caminant");
    }
    @Override
    public void emetreSo(){
        System.out.println(nom+" : guau guau");
    }
}
class Àguila extends Animal implements Volador{
    public Àguila(String nom, String tipus){
        super(nom, "Volador");
    }
    @Override
    public void volar(){
        System.out.println(nom+" Estic volant");
    }
    @Override
    public void emetreSo(){
        System.out.println(nom + " Shreer");
    }
}
class Peix extends Animal implements Acuatic{
    public Peix(String nom, String tipus){
        super(nom, "Acuatic");
    }
    @Override
    public void nedar(){
        System.out.println(nom+" Estic nedant");
    }
    @Override
    public void emetreso(){
        System.out.println(nom+" glugluu");
    }
}

public class Zoologic {
    private static final int TAMANY_ZOOLOGIC = 10;

    public class Main {
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
}