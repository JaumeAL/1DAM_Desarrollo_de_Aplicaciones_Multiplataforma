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
        super(1.0, 0.0); // Valores de ejemplo
    }

    public farmaciola (double pes, double valorArtefacte) {
        super(pes, valorArtefacte);
    }

    @Override
    public void valorRandomArtefacte() {
        setValorArtefacte(1 + (15 - 1) * rand.nextDouble());
    }

}
