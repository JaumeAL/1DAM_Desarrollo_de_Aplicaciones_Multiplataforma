/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class armaDAcer extends artefacte {
    Random rand = new Random();

    public armaDAcer() {
        super.setValorArtefacte(rand.nextInt(1, 16)); // Aplicar valor random automáticamente
    }


}
