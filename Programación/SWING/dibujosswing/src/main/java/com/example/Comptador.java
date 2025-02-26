package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Comptador extends JFrame {

    private JLabel etiquetaComptador; // Etiqueta per mostrar el comptador
    private int comptador = 0; // Variable per mantenir el valor del comptador
    private Timer timer; // Objecte Timer per actualitzar el comptador

    public Comptador() { 
    // Configuració de la finestra 
    setTitle("Comptador"); 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    setSize( 200, 100); 
    setLayout(new FlowLayout()); 
    
    // Creació de l'etiqueta per mostrar el comptador 
    etiquetaComptador = new JLabel("0"); 
    etiquetaComptador.setFont(new Font( "Arial", Font.BOLD, 24)); 
    add(etiquetaComptador);

    // Creació del Timer per actualitzar el comptador cada segon
    timer = new Timer( 1000, new ActionListener() { 
        @Override 
        public void actionPerformed(ActionEvent e) { 
        // Incrementa el comptador i actualitza l'etiqueta 
        comptador++; 
        etiquetaComptador.setText(String.valueOf(comptador)); 
        }
        });
        // Inicialitza el Timer
        timer.start();

        // Mostra la finestra
    setVisible(true); 
    }

    public static void main(String[] args) {
        new Comptador();
    }
}