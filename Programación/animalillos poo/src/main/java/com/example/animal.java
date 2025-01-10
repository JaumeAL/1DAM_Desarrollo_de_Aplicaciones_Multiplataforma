package com.example;

public class animal {
    private double peso;

    public animal(double nuevopeso){
        this.peso=nuevopeso;
    }

    public void setPeso(double nuevopeso){
        this.peso=nuevopeso;
    }

    public double getPeso(){
        return this.peso;
    }

    public void hazRuido(){
        System.out.println("¡El animal hace ruido!");
    }
}
