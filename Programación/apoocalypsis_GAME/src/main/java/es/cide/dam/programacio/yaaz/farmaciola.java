/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class farmaciola extends artefacte {
    Random rand = new Random();

    public farmaciola() {
        super.setValorArtefacte(rand.nextInt(1, 16)); // Aplicar valor random automáticamente
    }


}
