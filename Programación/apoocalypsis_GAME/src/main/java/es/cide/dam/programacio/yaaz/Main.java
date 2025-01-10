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

        artefacte miEscud = new escud(5.0, 0.0); // Se crea un objeto de la clase escud.
        miEscud.valorRandomArtefacte(); // Se le asigna un valor aleatorio al escudo.
        System.out.println("Valor del escudo: " + miEscud.getValorArtefacte()); // Se muestra el valor del escudo.
        

        // Pedir datos al usuario
        System.out.println("Introduce el nombre de la ciudad: ");
        String nomCiutat = sc.next(); // Se lee el nombre de la ciudad.
        System.out.println("Introduce el tamaño de la ciudad: ");
        int tamanyCiutat = sc.nextInt(); // Se lee el tamaño de la ciudad, que corresponde al número de zombies.
        System.out.println("Introduce el nombre del superviviente: ");
        String nomSuperviviente = sc.next(); // Se lee el nombre del superviviente.

        // Crear ciudad y superviviente con los datos del usuario
        ciutat ciutat = new ciutat(nomCiutat, tamanyCiutat); 
        supervivient supervivivent = new supervivient(nomSuperviviente); 


        // Inicio del juego
        System.out.println("----Comienza la batalla en " + ciutat.getNom() + "----");

        // Bucle que recorre cada posición de la ciudad, mientras el jugador tenga vida.
        for (int i = 0; i < tamanyCiutat && supervivivent.getSalut() > 0; i++) {
        
            zombie zombieActual = ciutat.posicio(i); // Se obtiene el zombie actual a partir de la posición correspondiente de la ciudad.
            System.out.println("\n--------Combate contra el " + (i + 1) + "º zombie--------");

            while (supervivivent.getSalut() > 0 && zombieActual.getSalut() > 0) { // Mientras el superviviente y el zombie actual tengan salud, lucharán.
                // Turno del superviviente.
                int atacSuperviviente = supervivivent.ataca() - zombieActual.defensat(); // Calcula el daño que inflige al zombie restando el ataque menos la defensa.

                if (atacSuperviviente > 0) { // Si el ataque supera la defensa del zombie, se le resta la salud correspondiente.
                    System.out.println(supervivivent.getNom() + " le quita " + atacSuperviviente + " de daño al zombie");
                    zombieActual.setSalut(zombieActual.getSalut() - atacSuperviviente);
                    System.out.println("Y el Zombie se queda con " + zombieActual.getSalut() + " de vida");
                } else { // Si el ataque no supera la defensa, el zombie bloquea el ataque.
                    System.out.println(supervivivent.getNom() + " ha atacado pero el zombie ha parado el ataque!");
                }

                if (zombieActual.getSalut() > 0) { // Si el zombie sigue vivo, realiza su turno.
                    int atacZombie = zombieActual.ataca() - supervivivent.defensat(); // Calcula el daño que inflige al superviviente restando el ataque menos la defensa.

                    if (atacZombie > 0) { // Si el ataque supera la defensa del superviviente, se le resta la salud correspondiente.
                        System.out.println("El Zombie le quita " + atacZombie + " de daño a " + supervivivent.getNom());
                        supervivivent.setSalut(supervivivent.getSalut() - atacZombie);
                        System.out.println(supervivivent.getNom() + " se queda con " + supervivivent.getSalut() + " de vida");
                    } else { // Si el ataque no supera la defensa, el superviviente bloquea el ataque.
                        System.out.println("El Zombie ha atacado pero " + supervivivent.getNom() + " ha parado el ataque!");
                    }
                } else {
                    System.out.println("El zombie ha muerto!");// Si el zombie muere, se muestra un mensaje y no realiza su turno.
                }
            }
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