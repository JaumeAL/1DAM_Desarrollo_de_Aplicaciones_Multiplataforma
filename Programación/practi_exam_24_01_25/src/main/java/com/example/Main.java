/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package com.example;
//Interficie Terrestre
interface InnerMain {
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
    
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}