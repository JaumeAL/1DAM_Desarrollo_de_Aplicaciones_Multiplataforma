package com.example;

import javax.swing.*; // Importem la llibreria Swing per crear la interfície gràfica
import java.awt.*; // Importem la llibreria per gestionar el disseny
import java.awt.event.*; // Importem la llibreria per gestionar els esdeveniments

public class check {

    public static void main(String[] args) {
        //2. crea aplicación que contenga un checkbox. Cuando el usuario marque o desmarque el checkbox lanza un jdialog que contenga un mensaje diferente si está marcado o desmarcado. (itemListener)
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

        JCheckBox checkbox = new JCheckBox("Marcar/Desmarcar"); //Creem un checkbox
        panel.add(checkbox); //Afegim el checkbox al panell

        checkbox.addItemListener(new ItemListener() { //Afegim un Listener al checkbox
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkbox.isSelected()) { //Si el checkbox està marcat
                    JOptionPane.showMessageDialog(null, "El checkbox està marcat", "Informació", JOptionPane.INFORMATION_MESSAGE); //Mostrem un missatge informatiu
                } else { //Si el checkbox no està marcat
                    JOptionPane.showMessageDialog(null, "El checkbox està desmarcat", "Informació", JOptionPane.INFORMATION_MESSAGE); //Mostrem un missatge informatiu
                }
            }
        });

        finestra.add(panel); //Afegim el panell a la finestra
        finestra.setVisible(true); //Fem visible la finestra

        

    }
    
}
