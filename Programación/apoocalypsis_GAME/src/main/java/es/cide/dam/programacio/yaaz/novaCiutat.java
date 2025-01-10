/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class novaCiutat extends ciutat {
    private artefacte[] artefactes;
    private Random rand = new Random();

    public novaCiutat(String nom, int tamany) {
        super(nom, tamany);
        this.artefactes = new artefacte[tamany];
        posicionarArtefactes();
    }

    private void posicionarArtefactes() {     //metodo para posicionar los artefactos
        boolean armaDeFocPosicionada = false; // Variable para controlar si ya se ha posicionado un arma

        for (int i = 0; i < artefactes.length; i++) { //bucle para recorrer el array de artefactos
            int probabilidad = rand.nextInt(100) + 1; // Generamos un número aleatorio entre 1 y 100

            if (!armaDeFocPosicionada && probabilidad <= constantesProbabilidades.armaDeFoc) { // Si no se ha posicionado un arma y la probabilidad es menor o igual a 1 (1%)
                artefactes[i] = new armaDeFoc();                              // Creamos un nuevo artefacto de tipo armaDeFoc
                armaDeFocPosicionada = true;                                  // Marcamos que ya se ha posicionado un arma ya que solo puede haber una
            } else if (probabilidad <= constantesProbabilidades.armaDAcer) {  // Si la probabilidad es menor o igual a 4 
                artefactes[i] = new armaDAcer();                              // Creamos un nuevo artefacto de tipo armaDAcer
            } else if (probabilidad <= constantesProbabilidades.FARMACIOLA) { // Si la probabilidad es menor o igual a 9 
                artefactes[i] = new farmaciola();                             // Creamos un nuevo artefacto de tipo farmaciola
            } else if (probabilidad <= constantesProbabilidades.ESCUD) {      // Si la probabilidad es menor o igual a 19
                artefactes[i] = new escud();                                  // Creamos un nuevo artefacto de tipo escud
            } else {                                                          // Si no se cumple ninguna de las condiciones anteriores
                artefactes[i] = null;                                         // No hay artefacto en esta posición
            }
        }
    }

    public artefacte getArtefacte(int posicio) {
        return artefactes[posicio];
    }
}