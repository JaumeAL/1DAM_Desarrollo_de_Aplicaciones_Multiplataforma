/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package com.example;
//Interficie Terrestre
interface Terrestre {
    void caminar();
} 
//Interficie Terrestre
interface Volador {
    void volar();
} 
//Interficie Terrestre
interface Aquatic {
    void nedar();
} 
//Clase abstracta Animal
abstract class Animal{
    protected String nom;
    protected String tipus;

    public Animal(String nom, String tipus){
        this.nom = nom;
        this.tipus = tipus;
    }
    public String getTipus() {
        return tipus;
    }

    public void mostrarInformacio(){
        System.out.println("Me llamo: "+nom+" y soy de tipo: "+tipus);
    }
    abstract void emetreSo();

}

//SubClase Gos
class Gos extends Animal implements Terrestre{

    public Gos(String nom){
        super(nom, "Terrestre");
    }

    @Override
    public void caminar(){
        System.out.println("Soy el perro: "+nom+" y estoy caminando");
    }
    @Override
    public void emetreSo(){
        System.out.println("Guau Guau!");
    }
}
//SubClase Àguila
class Àguila extends Animal implements Volador{

    public Àguila(String nom){
        super(nom, "Volador");
    }

    @Override
    public void volar(){
        System.out.println("Soy el aguila: "+nom+" y estoy volando");
    }
    @Override
    public void emetreSo(){
        System.out.println("Sshhher!");
    }
}
//SubClase Peix
class Peix extends Animal implements Aquatic{

    public Peix(String nom){
        super(nom, "Aquatic");
    }

    @Override
    public void nedar(){
        System.out.println("Soy el pez: "+nom+" y estoy nadando");
    }
    @Override
    public void emetreSo(){
        System.out.println("Gluugluu!");
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}