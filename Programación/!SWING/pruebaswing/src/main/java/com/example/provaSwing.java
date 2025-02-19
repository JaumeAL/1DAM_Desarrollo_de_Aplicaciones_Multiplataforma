package com.example;

import javax.swing.*;

public class provaSwing {

    public class Main {
        public static void main(String[] args) {

            JFrame frame = new JFrame("Ventana");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JLabel label = new JLabel("Hola Mundo");
            frame.getContentPane().add(label);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            JCheckBox check = new JCheckBox();
            check.setText("Check");
            check.setBounds(50, 100, 200, 50);
            frame.add(check);
            JButton boton = new JButton("Boton");
            boton.setBounds(50, 100, 300, 50);
            frame.add(boton);

            

        }
    }
}
