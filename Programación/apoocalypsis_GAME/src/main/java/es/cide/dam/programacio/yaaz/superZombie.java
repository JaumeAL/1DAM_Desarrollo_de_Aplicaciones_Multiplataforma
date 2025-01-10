/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package es.cide.dam.programacio.yaaz;

public class superZombie extends zombie {

    public superZombie(int salud, int ataque, int defensa) { //constructor de la clase superZombie
        super(salud, ataque, defensa); //llamada al constructor de la clase zombie
        this.salut = 60; //salud del superZombie
        this.atac = 10; //ataque del superZombie
        this.defensa = 5; //defensa del superZombie
        this.nom = "SuperZombie"; //nombre para diferenciarlo del zombie normal


    }

    
}
