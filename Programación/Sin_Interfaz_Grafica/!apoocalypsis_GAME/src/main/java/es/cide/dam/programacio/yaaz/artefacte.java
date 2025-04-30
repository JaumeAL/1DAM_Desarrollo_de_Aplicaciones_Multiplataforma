/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package es.cide.dam.programacio.yaaz;

public abstract class artefacte { // clase abstracta artefacto
    private double pes;
    public double valorArtefacte;


    public artefacte() { // constructor de la clase artefacto
        this.pes = 0; // inicializamos el peso a 0
        this.valorArtefacte = 1; // inicializamos el valor del artefacto a 1 (luego el valor se establecerá en las clases hijas)
    }

    // Getters
    public double getPes() { // metodo que devuelve el peso
        return pes;
    }

    public double getValorArtefacte() { // metodo que devuelve el valor del artefacto
        return valorArtefacte;
    }

    // Setters
    public void setPes(double pes) { // metodo que establece el peso
        this.pes = pes;
    }

    public void setValorArtefacte(double valorArtefacte) {// metodo que establece el valor del artefacto
        this.valorArtefacte = valorArtefacte;
    }

    public String tipoArtefacto() { // metodo que devuelve el tipo de artefacto
        return "Artefacto";
    }



}
