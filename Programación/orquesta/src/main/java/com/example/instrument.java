package com.example;

public abstract class instrument {
    protected String nom;
    protected String tipus;

    public instrument(String nom, String tipus){
        this.nom = nom;
        this.tipus = tipus;
    }

    //mostrar Info
    public void mostrarInformacio() {
        System.out.println("nombre: "+ nom+ "Tipo: " +tipus);
    }
    //interpretar
    public abstract void interpretar();




}
