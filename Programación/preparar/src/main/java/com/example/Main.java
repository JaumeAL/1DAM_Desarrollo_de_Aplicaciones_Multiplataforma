/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package com.example;

import javax.swing.*; // Importem la llibreria Swing per crear la interfície gràfica
import java.awt.*; // Importem la llibreria per gestionar el disseny
import java.awt.event.*; // Importem la llibreria per gestionar els esdeveniments
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main {
    public static void main(String[] args) {
        //1. Haz una pequeña aplicación con jframe/jpanel que contenga un slider y un label. El slider tendrá valores de 0 a 100. Cuando el usuario mueva el slider haz que se imprima el valor entre 0 y 100 según el slider en el label. (adjusmentListener)
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
        panel.setLayout(new GridLayout(4, 2)); //Establim un disseny de graella amb 4 files i 2 columna

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0); //Creem un slider amb valors de 0 a 100
        slider.setMajorTickSpacing(10); //Establim la separació entre les marques majors
        slider.setMinorTickSpacing(1); //Establim la separació entre les marques menors
        slider.setPaintTicks(true); //Mostrem les marques
        slider.setPaintLabels(true); //Mostrem els valors
        panel.add(slider); //Afegim el slider al panell

        JLabel label = new JLabel("0"); //Creem un JLabel amb el valor inicial
        panel.add(label); //Afegim el JLabel al panell

        slider.addChangeListener(new ChangeListener() { //Afegim un Listener al slider
            @Override
            public void stateChanged(ChangeEvent e) {
                label.setText(String.valueOf(slider.getValue())); //Actualitzem el valor del JLabel amb el valor del slider
            }
        });

        finestra.add(panel); //Afegim el panell a la finestra
        finestra.setVisible(true); //Fem visible la finestra



    }
}