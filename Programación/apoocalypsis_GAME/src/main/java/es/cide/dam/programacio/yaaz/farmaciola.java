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
        super(1.0, 0.0, 5); // Valores de ejemplo
    }

    public farmaciola (double pes, double valorArtefacte, int contingutArtefacte) { //constructor de la clase farmaciola
        super(pes, valorArtefacte, contingutArtefacte);
    }

    @Override 
    public void valorRandomArtefacte() { //metodo que establece el valor del artefacto entre 1 y 15
        setValorArtefacte(1 + (15 - 1) * rand.nextDouble());
    }

}
