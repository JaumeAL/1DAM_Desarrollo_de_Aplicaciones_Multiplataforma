package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Main {

    public static void mostrarDialeg(JFrame parnet) {
        //Creem el dialeg
        JDialog dialeg = new JDialog(parnet, "Missatge important", true);
        dialeg.setSize(300,150);
        dialeg.setLayout(new BorderLayout());

        //Add Misatge
        JLabel etiqueta = new JLabel("Aixo es un diàleg!", JLabel.CENTER);
        dialeg.add(etiqueta, BorderLayout.CENTER);


        //Boto per tancar el dialeg
        JButton botoTancar = new JButton("D'acord");
        botoTancar.addActionListener(e -> dialeg.dispose());
        dialeg.add(botoTancar, BorderLayout.SOUTH);

        //Fem visible el dialeg
        dialeg.setLocationRelativeTo(parnet);
        dialeg.setVisible(true);

    }
    public static void main(String[] args) {
        //Creem el JFrame principal
        JFrame finestra = new JFrame("Exemple de JDialog");
        finestra.setSize(400, 200);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setLayout(new FlowLayout());

        //Botó per obrir le JDialog
        JButton botoObrir = new JButton("Obrir diàleg");
        finestra.add(botoObrir);

        //Afagim un listener per obrir el JDialog quan es premi
        botoObrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialeg(finestra);
            }
        });
        //Fem visible la finestra principal
        finestra.setVisible(true);


    }
}