/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
//Calculadroa con Swing
package com.example;

import javax.swing.*; // Importem la llibreria Swing per crear la interfície gràfica
import java.awt.*; // Importem la llibreria per gestionar el disseny
import java.awt.event.*; // Importem la llibreria per gestionar els esdeveniments

public class Main {
    public static void main(String[] args) {
        JFrame finestra = new JFrame("Exemple Swing"); // Creem la finestra principal
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurem la finestra per tancar l'aplicació
        finestra.setSize(300, 350); // Establim la mida de la finestra
        finestra.setLocationRelativeTo(null); // Centrem la finestra a la pantalla
        finestra.setBackground(Color.pink);

        JPanel panel = new JPanel(); // Creem un JPanel per organitzar els components
        panel.setLayout(new GridLayout(4, 2)); // Establim un disseny de graella amb 3 files i 1 columna

        JTextField num1 = new JTextField(1); // Creem un camp de text
        panel.add(num1); // Afegim el camp de text al panell

        JTextField num2 = new JTextField(1); // Creem un camp de text
        panel.add(num2); // Afegim el camp de text al panell
        
        JButton sumar = new JButton("SUMAR"); // Creem un botó
        panel.add(sumar); // Afegim el botó al panell
        
        JButton restar = new JButton("RESTAR"); // Creem un botó
        panel.add(restar); // Afegim el botó al panell
        
        JButton multiplicar = new JButton("MULTIPLICAR"); // Creem un botó
        panel.add(multiplicar); // Afegim el botó al panell
        
        JButton dividir = new JButton("DIVIDIR"); // Creem un botó
        panel.add(dividir); // Afegim el botó al panell
        
        JLabel etiqueta = new JLabel("Resultado..."); // Creem una etiqueta per mostrar el text
        panel.add(etiqueta); // Afegim l'etiqueta al panell

        double a = Double.parseDouble(num1.getText());
        double b = Double.parseDouble(num2.getText());
        
        sumar.addActionListener(new ActionListener() { // Afegim un gestor d'esdeveniments al botó
        @Override
        public void actionPerformed(ActionEvent e) {
            Double resultat = a + b ; // Sumam els dos valors
            etiqueta.setText(String.valueOf(resultat)); // Mostrem el resultat a l'etiqueta
        }
    });
    
        restar.addActionListener(new ActionListener() { // Afegim un gestor d'esdeveniments al botó
            @Override
            public void actionPerformed(ActionEvent e) {
                Double resultat = Double.parseDouble(num1.getText()) - Double.parseDouble(num2.getText()); // Multiplicam els dos valors
                etiqueta.setText(String.valueOf(resultat)); // Mostrem el resultat a l'etiqueta
            }
        });

        multiplicar.addActionListener(new ActionListener() { // Afegim un gestor d'esdeveniments al botó
            @Override
            public void actionPerformed(ActionEvent e) {
                Double resultat = Double.parseDouble(num1.getText()) * Double.parseDouble(num2.getText()); // Multiplicam els dos valors
                etiqueta.setText(String.valueOf(resultat)); // Mostrem el resultat a l'etiqueta
            }
        });

        dividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Double.parseDouble(num2.getText()) !=0) { //Si el segon valor no es 0 
                    Double resultat = Double.parseDouble(num1.getText()) / Double.parseDouble(num2.getText()); // Dividim els dos valors
                    etiqueta.setText(String.valueOf(resultat));
                }else{
                    etiqueta.setText("No se puede dividir por 0..."); // De lo contrari mostrarà un missatge d'error
                }
            }
        });

        


        finestra.add(panel); // Afegim el panell a la finestra
        finestra.setVisible(true); // Fem visible la finestra principal

    }
}