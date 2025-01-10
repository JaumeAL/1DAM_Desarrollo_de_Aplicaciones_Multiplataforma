package com.example;

public class Patin {

    private boolean isOn;
    private int velocidad;
    private int giro;
    private String nombre;

    public Patin() {
        // sus valores iniciales
        this.isOn = false;
        this.velocidad = 0;
        this.giro = 0;
    }

    // Arrancar
    public void arrancar() {
        
        this.isOn = true;
        System.out.println("El patín está arrancado");
    }

    // Apagar
    public void apagar() {
        this.isOn = false;
        System.out.println("El patín está apagado");
    }

    // Acelerar
    public void acelerar() {
        this.velocidad++;
        System.out.println("Vas a " + velocidad + "Km/h");
    }

    // Frenar
    public void frenar() {
        this.velocidad--;
        System.out.println("Vas a " + velocidad + "Km/h");
    }

    public void girarDerecha() {
        this.giro++;
        System.out.println("has girado " + giro + "º a la derecha");
    }

    public void girarIzquierda() {
        this.giro--;
        System.out.println("has girado " + giro + "º a la izquierda");
    }

    // Mostrar velocidad actual
    public int getVelocidad() {
        return velocidad;
    }

    // Ir a la velocidad que quieras
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String getNombre() {
        return nombre;
    } 
    public void setNombre(String Nombre){
        this.nombre = Nombre;
    }

}
