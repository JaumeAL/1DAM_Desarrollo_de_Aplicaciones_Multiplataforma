package com.example;

public class perro extends animal{
    //Constructor que llama al construcotr de la clase base(Animal)
    public perro(double peso){
        super(peso);  //Llama al constructor animal
    }

    //Sobrescribir el método hazRuido para Perro
    @Override
    public void hazRuido(){
        System.out.println("!guauuu¡");
    }
}
