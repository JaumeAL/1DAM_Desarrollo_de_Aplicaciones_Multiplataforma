/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class armaDeFoc extends artefacte{
    Random rand = new Random();

    public armaDeFoc() {
        super(1.0, 0.0); // Valores de ejemplo
    }
    public armaDeFoc(double pes, double valorArtefacte){ //constructor de la clase armaDeFoc
        super(pes, valorArtefacte);
        
    }
    
    @Override
    public void valorRandomArtefacte() {
        setValorArtefacte(0.9 + (1.5 - 0.9) * rand.nextDouble()); //valor del artefacto entre 0.9 y 1.5
    }
    

}
