/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class zombie {
    Random rand = new Random();
    // Aqui instancio mis variables
    protected int salut;
    protected int atac;
    protected int defensa;
    protected String nom;

    public zombie() {
        // Constructor donde le doy un valor inicial a las variables
        this.salut = 20;
        this.atac = 5;
        this.defensa = 5;
        this.nom = "Zombie";
    }

    // Metodo para mostrar la salud
    public int getSalut() {
        //System.out.print("Salud del zombie: ");
        return salut;
    }

    // Metodo para mostrar el ataque
    public int getAtaque() {
        //System.out.print("Ataque del zombie: ");
        return atac;
    }

    // Metodo para mostrar la defensa
    public int getDefensa() {
        //System.out.print("Defensa del zombie: ");
        return defensa;
    }

    public String getNom() {
        return nom;
    }

    // Metodo para ingresar la salud
    public void setSalut(int vidaZombie) {
        this.salut = vidaZombie;
    }

    // Metodo para ingresar el ataque
    public void setAtac(int atacZombie) {
        this.atac = atacZombie;
    }

    // Metodo para ingresar la defensa
    public void setDefensa(int defensaZombie) {
        this.defensa = defensaZombie;
    }

    // metodos atacar
    public int ataca() {
        //System.out.print("Ataque de: ");
        return (rand.nextInt(atac + 1));
    }

    // metodos defenderse
    public int defensat() {
        //System.out.print("Defensa de: ");
        return (rand.nextInt(defensa + 1));
    }
}
