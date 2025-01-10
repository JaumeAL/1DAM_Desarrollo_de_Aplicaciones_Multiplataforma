/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package com.example;

public class martillo extends herramienta { // Clase "martillo" que extiende de la clase "herramienta" para reutilizar los atributos y métodos comunes. 

    private String nombre;
    //Constructor donde se inicializan los valores
    public martillo(double peso, String material) {
        super(peso, material); // Usar "super" para inicializar los atributos comunes definidos en la clase "herramienta".
        this.nombre = "Martillo"; // Nombre predeterminado para objetos de tipo "martillo".
    }

    //Permite mostrar el valor de nombre
    public String getNombre() {
        return this.nombre;
    }

    //Permite modificar el valor de nombre
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    // Implementación del método "utilizar" de la clase "herramienta"
    @Override
    public void utilizar() {//Dar un comportamiento diferente al de su clase padre al ser utilizado.
        System.out.println("\nUtilizando el martillo");
    }

}
