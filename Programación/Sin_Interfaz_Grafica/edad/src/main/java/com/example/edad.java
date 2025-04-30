// Mayor o menor de edad

package com.example;

import java.util.Scanner;

public class edad {

    static int actualidad = 2024;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Introduce tu año de nacimiento:");
        int nacimiento = sc.nextInt();
        
        
        int edad = (actualidad - nacimiento);
        
        if (edad >= 18) {
            System.out.println("Eres mayor de edad :) ");
        }
        else if (nacimiento > actualidad) {
            System.out.println("Es imposible ");
        }
        else if (edad == 17) {
            System.out.println("Tienes 17 años ");
        }else {
            System.out.println("Eres menor de edad :( ");
        }
        
    }
}

