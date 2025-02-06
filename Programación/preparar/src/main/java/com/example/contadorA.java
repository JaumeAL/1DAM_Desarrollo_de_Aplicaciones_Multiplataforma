package com.example;

import javax.swing.*; // Importem la llibreria Swing per crear la interfície gràfica
import java.awt.*; // Importem la llibreria per gestionar el disseny
import java.awt.event.*; // Importem la llibreria per gestionar els esdeveniments

public class contadorA {
    
    public static void main(String[] args) {
        //4. fes una aplicació que contengui un JTextField i un JLabel. A mesura que l'usuari vagi introduïnt texte al TextField, fes que cada pic que pitji la lletra "a" o "A" sumi un al contador que es mostrará al JLabel.  (KeyListener)
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
        finestra.setSize(350, 200); //Establim la mida de la finestra
        finestra.setLocationRelativeTo(null); //Centrem la finestra a la pantalla
        finestra.setResizable(false); //Fem que la finestra no es pugui redimensionar

        JPanel panel = new JPanel(); //Creem un JPanel per organitzar els components
        panel.setLayout(new GridLayout(4, 2)); //Establim un disseny de graella amb 3 files i 1 columna

        JTextField textfield = new JTextField(); //Creem un JTextField
        panel.add(textfield); //Afegim el JTextField al panell
        
        JLabel label = new JLabel("0"); //Creem un JLabel amb el valor inicial
        panel.add(label); //Afegim el JLabel al panell

        textfield.addKeyListener(new KeyListener() { //Afegim un Listener al JTextField
            int contador = 0; //Creem un contador
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') { //Si la lletra pitjada és una "a" o "A"
                    contador++; //Incrementem el contador
                    label.setText(String.valueOf(contador)); //Mostrem el valor del contador al JLabel
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        finestra.add(panel); //Afegim el panell a la finestra
        finestra.setVisible(true); //Fem visible la finestra
        
    }
}
