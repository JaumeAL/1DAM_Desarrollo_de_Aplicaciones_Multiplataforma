/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class supervivient {
    Random rand = new Random();
    // Aqui instancio mis variables
    private int salut;
    private int atac;
    private int defensa;
    private String nom;

    public supervivient(String nom) {
        // Constructor donde le doy un valor inicial a las variables
        this.salut = 100;
        this.atac = 10;
        this.defensa = 10;
        this.nom = nom;
    }

    // Metodo para mostrar la salud
    public int getSalut() {
        return salut;
    }

    // Metodo para mostrar el ataque
    public int getAtaque() {
        return atac;
    }

    // Metodo para mostrar la defensa
    public int getDefensa() {
        return defensa;
    }

    // Metodo para mostrar el nombre
    public String getNom() {
        return nom;
    }

    // Metodo para ingresar la salud
    public void setSalut(int salutSupervivent) {
        this.salut = salutSupervivent;
    }

    // Metodo para ingresar el ataque
    public void setAtac(int atacSupervivent) {
        this.atac = atacSupervivent;
    }

    // Metodo para ingresar la defensa
    public void setDefensa(int defensaSupervivent) {
        this.defensa = defensaSupervivent;
    }

    // Metodo para ingresar el nombre
    public void setNom(String nomSupervivent) {
        this.nom = nomSupervivent;
    }

    // metodos atacar
    public int ataca() {
        return (rand.nextInt(atac + 1));
    }

    // metodos defenderse
    public int defensat() {
        return (rand.nextInt(defensa + 1));
    }
}
