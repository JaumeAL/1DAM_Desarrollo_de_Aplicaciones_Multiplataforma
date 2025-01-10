package com.example;

public class gato extends animal{

    public gato(double peso){
        super(peso);
    }

    @Override 
    public void hazRuido(){
        System.out.println("!miau¡");
    }
}
