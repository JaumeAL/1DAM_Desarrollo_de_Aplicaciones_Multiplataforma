package es.cide.dam.programacio.yaaz;

public class superZombie extends zombie {


    public superZombie(int salud, int ataque, int defensa) { //constructor de la clase superZombie
        super(salud, ataque, defensa); //llamada al constructor de la clase zombie
        this.salut = 60; 
        this.atac = 10;
        this.defensa = 5;
        this.nom = "SuperZombie";


    }



    
}
