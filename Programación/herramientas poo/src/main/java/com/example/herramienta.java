/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package com.example;

public class herramienta {
    private double peso;
    private String material;
    private String nombre;
    //Constructor donde se inicializan los valores
    public herramienta(double nuevoPeso, String nuevomMterial) { // Peso y material se tendrán que poner a la hora de crear el objeto en el main.
        this.peso = nuevoPeso;
        this.material = nuevomMterial;
        this.nombre = "";
    }

    //Permite mostrar el valor de peso
    public double getPeso() {
        return this.peso;
    }
    //Permite mostrar el valor de material
    public String getMaterial() {
        return this.material;
    }
    //Permite mostrar el valor de nombre
    public String getNombre() {
        return this.nombre;
    }

    //Permite modificar el valor de peso
    public void setPeso(double nuevoPeso) {
        this.peso = nuevoPeso;
    }
    //Permite modificar el valor de material
    public void setMaterial(String nuevomMterial) {
        this.material = nuevomMterial;
    }
    //Permite modificar el valor de nombre
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    // Funcion que devuelve una cadena de caracteres
    public void utilizar() {
        System.out.println("Utilizando una herramienta genérica");
    }

}
