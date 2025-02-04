package com.example;

import javax.swing.*; // Importem la llibreria Swing per crear la interfície gràfica
import java.awt.*; // Importem la llibreria per gestionar el disseny
import java.awt.event.*; // Importem la llibreria per gestionar els esdeveniments

public class Main {
    public static void main(String[] args) {
        JFrame finestra = new JFrame("Exemple Swing"); // Creem la finestra principal
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurem la finestra per tancar l'aplicació
        finestra.setSize(300, 150); // Establim la mida de la finestra

        JPanel panel = new JPanel(); // Creem un JPanel per organitzar els components
        panel.setLayout(new GridLayout(3, 1)); // Establim un disseny de graella amb 3 files i 1 columna

        JTextField campText = new JTextField(15); // Creem un camp de text
        panel.add(campText); // Afegim el camp de text al panell


    }
}