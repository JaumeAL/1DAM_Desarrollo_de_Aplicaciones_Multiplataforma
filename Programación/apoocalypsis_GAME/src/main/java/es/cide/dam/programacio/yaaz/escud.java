/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class escud extends artefacte {
    Random rand = new Random();
    public escud() {
        super(1.0, 0.0, 5); // Valores de ejemplo
    }

    public escud(double pes, double valorArtefacte, int contingutArtefacte) {//constructor de la clase escud
        super(pes, valorArtefacte, contingutArtefacte);

    }
    
    @Override
    public void valorRandomArtefacte() {
        setValorArtefacte(0.9 + (1.5 - 0.9) * rand.nextDouble()); //valor del artefacto entre 0.9 y 1.5
    }
    

}
