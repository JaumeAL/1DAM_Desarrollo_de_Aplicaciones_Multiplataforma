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
        super(1.0, 0.0,5); // Valores de ejemplo
    }

    public armaDAcer(double pes, double valorArtefacte, int contingutArtefacte) {
        super(pes, valorArtefacte, contingutArtefacte);
    }

    @Override
    public void valorRandomArtefacte() {
        setValorArtefacte(1 + (15 - 1) * rand.nextDouble()); //valor del artefacto entre 1 y 15
    }

}
