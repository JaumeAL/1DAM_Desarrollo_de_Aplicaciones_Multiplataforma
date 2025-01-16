/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package es.cide.dam.programacio.yaaz; // Package común a todos los archivos de este programa.

import java.util.Scanner; // Se importa la libreria Scanner.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Se inicializa un objeto Scanner.
        
        // Pedir datos al usuario
        System.out.println("Introduce el nombre de la ciudad: ");
        String nomCiutat = sc.next(); // Se lee el nombre de la ciudad.
        System.out.println("Introduce el tamaño de la ciudad: ");
        int tamanyCiutat = sc.nextInt(); // Se lee el tamaño de la ciudad, que corresponde al número de zombies.
        System.out.println("Introduce el nombre del superviviente: ");
        String nomSuperviviente = sc.next(); // Se lee el nombre del superviviente.

        // Crear nuevaCiudad y superviviente con los datos ingresados por el usuario
        novaCiutat ciutat = new novaCiutat(nomCiutat, tamanyCiutat);
        supervivient supervivivent = new supervivient(nomSuperviviente); 

        // Inicio del juego
        System.out.println("----Comienza la batalla en " + ciutat.getNom() + "----");

        // Bucle que recorre cada posición de la ciudad, mientras el jugador tenga vida.
        for (int i = 0; i < tamanyCiutat && supervivivent.getSalut() > 0; i++) {
            zombie zombieActual = ciutat.posicio(i); // Se obtiene el zombie actual a partir de la posición correspondiente de la ciudad.
            System.out.println("\n--------Combate contra el " + (i + 1) + "º zombie--------");

            Lucha.luchar(supervivivent, zombieActual, ciutat, i); // Se llama al método luchar de la clase Lucha (que representa el combate entre el superviviente y el zombie)
        }

        if (supervivivent.getSalut() > 0) { // Si el superviviente sobrevive a todos los zombies, muestra un mensaje.
            System.out.println("\n--- El joven y apuesto " + supervivivent.getNom() + " ha conseguido matar a los " + tamanyCiutat + " Zombies de " + ciutat.getNom() + " y se ha quedado con " + supervivivent.getSalut() + " de vida ---");
        } else {
            // Si el superviviente muere, muestra un mensaje de derrota.
            System.out.println("\n--- El juego ha terminado. El superviviente no logró sobrevivir ---");
        }
        sc.close(); // Se cierra el Scanner.
    }
}