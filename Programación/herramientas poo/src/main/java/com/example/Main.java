/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package com.example;

public class Main {
    // Método estático para mostrar información sobre una herramienta.
    public static void mostrarEina(herramienta unaEina) { // Metodo que mostrará la accion de utilizar herramienta y la info de la herramienta

        unaEina.utilizar();//Usar polimorfismo para llamar al método "utilizar()"" de la herramienta. 
        System.out.println("Eina: " + unaEina.getNombre() + ", Pes: " + unaEina.getPeso() + " kg, Material: " + unaEina.getMaterial()); //Mostrar el nombre, peso y material de la herramienta.<
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        System.out.println("Bienvenido al taller");

        // Crear objetos de cada herramienta
        // Creamos cada objeto indicando su peso y su material
        herramienta martillo = new martillo(2, "madera"); 
        herramienta destornillador = new destornillador(0.5, "metal");
        herramienta sierra = new sierra(3, "metal");

        // Llamamos al método mostrarEina para cada herramienta
        mostrarEina(martillo);
        mostrarEina(destornillador);
        mostrarEina(sierra);
    }

}
