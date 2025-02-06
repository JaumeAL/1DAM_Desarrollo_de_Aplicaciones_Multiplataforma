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
        // Establim el LookAndFeel 
                try {
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JFrame finestra = new JFrame("Exemple Swing"); //Creem la finestra principal
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Configurem la finestra per tancar l'aplicació
        finestra.setSize(350, 400); //Establim la mida de la finestra
        finestra.setLocationRelativeTo(null); //Centrem la finestra a la pantalla
        finestra.setResizable(false); //Fem que la finestra no es pugui redimensionar
        

        JPanel panel = new JPanel(); //Creem un JPanel per organitzar els components
        panel.setLayout(new GridLayout(4, 2)); //Establim un disseny de graella amb 3 files i 1 columna

        JTextField num1 = new JTextField(10); //Creem un camp de text
        panel.add(num1); // Afegim el camp de text al panell
        num1.setHorizontalAlignment(JTextField.CENTER);

        JTextField num2 = new JTextField(10); //Creem un camp de text
        panel.add(num2); // Afegim el camp de text al panell
        num2.setHorizontalAlignment(JTextField.CENTER);

        JButton sumar = new JButton("SUMAR"); //Creem un botó per sumar
        panel.add(sumar); // Afegim el botó al panell
        sumar.setBackground(Color.gray);

        JButton restar = new JButton("RESTAR"); //Creem un botó per restar
        panel.add(restar); // Afegim el botó al panell
        restar.setBackground(Color.gray);

        JButton multiplicar = new JButton("MULTIPLICAR"); //Creem un botó per multiplicar
        panel.add(multiplicar); // Afegim el botó al panell
        multiplicar.setBackground(Color.gray);

        JButton dividir = new JButton("DIVIDIR"); //Creem un botó per dividir
        panel.add(dividir); // Afegim el botó al panell
        dividir.setBackground(Color.gray);

        JLabel etiqueta = new JLabel("Resultado..."); //Creem una etiqueta per mostrar el resultat
        panel.add(etiqueta); // Afegim l'etiqueta al panell

        //SUMAR
        sumar.addActionListener(new ActionListener() { //Afegim un gestor d'esdeveniments al botó
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double resultat = Double.parseDouble(num1.getText()) + Double.parseDouble(num2.getText()); //Sumam els dos valors
                    etiqueta.setText(String.valueOf(resultat)); //Mostrem el resultat a l'etiqueta
                } catch (NumberFormatException ex) {
                    etiqueta.setText("SYNTAX ERROR :("); //Si no s'introdueix un número mostrarà un missatge d'error
                }
            }
        });
        //RESTAR
        restar.addActionListener(new ActionListener() { //Afegim un gestor d'esdeveniments al botó
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double resultat = Double.parseDouble(num1.getText()) - Double.parseDouble(num2.getText()); //Restam els dos valors
                    etiqueta.setText(String.valueOf(resultat)); //Mostrem el resultat a l'etiqueta
                } catch (NumberFormatException ex) {
                    etiqueta.setText("SYNTAX ERROR :("); //Si no s'introdueix un número mostrarà un missatge d'errorç
                }
            }
        });
        //MULTIPLICAR
        multiplicar.addActionListener(new ActionListener() { //Afegim un gestor d'esdeveniments al botó
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double resultat = Double.parseDouble(num1.getText()) * Double.parseDouble(num2.getText()); //Multiplicam els dos valors
                    etiqueta.setText(String.valueOf(resultat)); //Mostrem el resultat a l'etiqueta
                } catch (NumberFormatException ex) {
                    etiqueta.setText("SYNTAX ERROR :("); //Si no s'introdueix un número mostrarà un missatge d'error
                }
            }
        });
        //DIVIDIR
        dividir.addActionListener(new ActionListener() { //Afegim un gestor d'esdeveniments al botó
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Double.parseDouble(num2.getText()) != 0) { //Si el segon valor no es 0
                        Double resultat = Double.parseDouble(num1.getText()) / Double.parseDouble(num2.getText()); //Dividim els dos valors
                        etiqueta.setText(String.valueOf(resultat));
                    } else {
                        etiqueta.setText("No se puede dividir por 0..."); //De lo contrari mostrarà un missatge d'error
                    }
                } catch (NumberFormatException ex) {
                    etiqueta.setText("SYNTAX ERROR :("); //Si no s'introdueix un número mostrarà un missatge d'error
                }
            }
        });

        finestra.add(panel); // Afegim el panell a la finestra
        finestra.setVisible(true); // Fem visible la finestra principal

    }
}