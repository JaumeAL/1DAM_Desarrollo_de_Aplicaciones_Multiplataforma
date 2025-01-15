/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class armaDeFoc extends artefacte {
    Random rand = new Random();

    public armaDeFoc() {
        super.setValorArtefacte(rand.nextDouble(0.9, 1.6)); // Aplicar valor random automáticamente
    }


}
