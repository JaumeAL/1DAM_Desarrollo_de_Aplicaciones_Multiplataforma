/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package com.example;

import java.util.Random;

//Interficie graella
interface graella {
    void posarCarnAGraella();

    void llevarCarnDeGraella();

    boolean estaFet();
}

// Interficie menjar
interface menjar {
    void assaborir();

    boolean crema();
}

// Superclasee torrada
class torrada {
    protected String festivitat;
    protected String any;

    public torrada(String festivitat, String any) { // Constructor de la clase torrada
        this.festivitat = festivitat;
        this.any = any;
    }

    // Getters
    public String getFestivitat() {
        return festivitat;
    }

    public String getAny() {
        return any;
    }

    // Setters
    public void setFestivitat(String festivitat) {
        this.festivitat = festivitat;
    }

    public void setAny(String any) {
        this.any = any;
    }
}

// Subclse botifarro
class botifarro extends torrada implements graella, menjar {
    Random rand = new Random();
    protected boolean coent;

    public botifarro(String festivitat, String any,Boolean coent) { // Constructor de la subclase botifarro
        super(festivitat, any);
  
    }

    // Geter coent
    public boolean getCoent() { // Para ver el valor
        return coent;
    }

    // Seter coent
    public void setCoent(boolean coent) { // Para modificar el valor
        this.coent = coent;
    }

    @Override // Sobreescribir metodo de la interficie graella
    public void posarCarnAGraella() {
        System.out.println("He posat el botifarró a la graella.");
    }

    @Override // Sobreescribir metodo de la interficie graella
    public void llevarCarnDeGraella() {
        System.out.println("Llevant el botifarró de la graella.");
    }

    @Override // Sobreescribir metodo de la interficie graella
    public boolean estaFet() {
        int num = rand.nextInt(100); // si el num es entre 0 y 70 devolverá false
        if (num < 70) {
            return false;
        } else {
            return true;
        }
    }

    @Override // Sobreescribir metodo de la interficie menjar
    public void assaborir() {
        System.out.println("Estic assaborint un botifarró");
    }

    @Override // Sobreescribir metodo de la interficie menjar
    public boolean crema() {
        int num = rand.nextInt(2); // 0= true y 1= false
        if (num == 1) {
            return false; //Devuelve false
        } else {
            return true; //Devuelve true
        }
    }
}
// Subclse sobrassada
class sobrassada extends torrada implements graella, menjar {
    Random rand = new Random();

    public sobrassada(String festivitat, String any) { // Constructor de la subclase botifarro
        super(festivitat, any);
    }


    @Override // Sobreescribir metodo de la interficie graella
    public void posarCarnAGraella() {
        System.out.println("He posat la sobrassada a la graella.");
    }

    @Override // Sobreescribir metodo de la interficie graella
    public void llevarCarnDeGraella() {
        System.out.println("Llevant la sobrassada de la graella.");
    }

    @Override // Sobreescribir metodo de la interficie graella
    public boolean estaFet() {
        int num = rand.nextInt(2); // 0= true y 1= false
        if (num == 1) {
            return false; //Devuelve false
        } else {
            return true; //Devuelve true
        }
    }

    @Override // Sobreescribir metodo de la interficie menjar
    public void assaborir() {
        System.out.println("Asaborint la sobrassada.");
    }

    @Override // Sobreescribir metodo de la interficie menjar
    public boolean crema() {
        int num = rand.nextInt(2); // 0= true y 1= false
        if (num == 1) {
            return false; //Devuelve false
        } else {
            return true; //Devuelve true 
        }
    }
}

public class Main {
    public static void main(String[] args) {
        boolean stop = true;
        //Crear una torrada
        torrada miTorrada = new torrada("Sant Sebastià", "2025");

        //Crear un botifarro
        botifarro miBotifarro = new botifarro("Sant Sebastià", "2025",true);

        //Crear una sobrassada
        sobrassada miSobrassada = new sobrassada("Sant Sebastià", "2025");

        //Lore
        System.out.println("Benvingut a la torrada de " + miTorrada.getFestivitat() +" "+ miTorrada.getAny()+".");
        System.out.println("He comprat un botifarró.");
        System.out.println("He comprat una sobrassada.");

        //Posar el botifarró a la graella
        miBotifarro.posarCarnAGraella();

        //Posar la sobrassada a la graella
        miSobrassada.posarCarnAGraella();

        //Lore
        System.out.println("Vaig a mirar si estan fets:");

            while (stop = true) {
                
                if (miBotifarro.estaFet()== false && miSobrassada.estaFet() == true) { //per si es botifarró esta cru i la sobrasada no
                    System.out.println("El botifarró està cru i la sobrassada està fet. He d esperar.");
                }else if (miBotifarro.estaFet()== true && miSobrassada.estaFet() == false) { // per si es botifarró esta fet i la sobrasada no
                    System.out.println("El botifarró està fet i la sobrassada està cru. He d esperar.");
                }else if (miBotifarro.estaFet()== false && miSobrassada.estaFet() == false) { //per si el botifarró esta cru i la sobrasada també
                    System.out.println("El botifarró està cru i la sobrassada està cru. He d esperar.");
                }else{// per si els dos estan fets
                    System.out.println("El botifarró està fet i la sobrassada està fet. Ja puc anar a sopar.");
                    break;
                }
            }
            //indica si el botifarro es coent o no es coent
            if (miBotifarro.getCoent() == true) {
                System.out.println("Estic assaborint el botifarró i es coent.");
            }else{
                System.out.println("Estic assaborint el botifarró i no es coent.");
            }
            
            //Indica que esta saboreando la sobrassada
            miSobrassada.assaborir();

            //Fin
            System.out.println("Au, ja està tot fet! Visca Sant Sebastià!");
            
        


    }
}
