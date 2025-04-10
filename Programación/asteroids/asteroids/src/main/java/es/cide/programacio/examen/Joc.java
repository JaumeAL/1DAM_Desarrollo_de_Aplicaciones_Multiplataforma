/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package es.cide.programacio.examen;

import javax.swing.*;

public class Joc {
    public static void main(String[] args) {
        // Crea la finestra principal
        JFrame finestra = new JFrame("El corredor de Kessel");
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setSize(700, 600); // Mida de la finestra (me pareix més coherent 700x600)
        finestra.add(new JocPanel()); // Afegeix el panell del joc
        finestra.setLocationRelativeTo(null); // Centra la finestra
        finestra.setVisible(true); // Fa que la finestra sigui visible
        finestra.setResizable(false); //La pantalla no es pot redimensionar
    }
}