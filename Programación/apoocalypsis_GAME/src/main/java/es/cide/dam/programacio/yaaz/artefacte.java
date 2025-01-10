/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package es.cide.dam.programacio.yaaz;

public abstract class artefacte { //clase abstracta artefacto
    private double pes;
    public double valorArtefacte;
    
    public artefacte(double pes, double valorArtefacte){ //constructor de la clase artefacto
        this.pes = pes;
        this.valorArtefacte = valorArtefacte;
    }
    //Getters
    public double getPes() { //metodo que devuelve el peso
        return pes;
    }
    public double getValorArtefacte() { //metodo que devuelve el valor del artefacto
        return valorArtefacte;
    }
    //Setters
    public void setPes(double pes) { //metodo que establece el peso
        this.pes = pes;
    }
    public void setValorArtefacte(double valorArtefacte) {//metodo que establece el valor del artefacto
        this.valorArtefacte = valorArtefacte;
    }

    public abstract void valorRandomArtefacte();
    
    
}
