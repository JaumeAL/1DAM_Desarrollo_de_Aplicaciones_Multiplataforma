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

        JFrame finestra = new JFrame("CHECKBOX");
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Configurem la finestra per tancar l'aplicació
        finestra.setSize(350, 200); //Establim la mida de la finestra
        finestra.setLocationRelativeTo(null); //Centrem la finestra a la pantalla
        finestra.setResizable(false); //Fem que la finestra no es pugui redimensionar

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new FlowLayout());
        finestra.add(panelPrincipal);

        JCheckBox box = new JCheckBox();
        panelPrincipal.add(box);

        JLabel mensaje =new JLabel("CheckBox sin clicar");
        panelPrincipal.add(mensaje);
        mensaje.setFont(new Font("Arial", Font.BOLD, 20));

        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    mensaje.setText("CheckBox clicado");
                } else {
                    mensaje.setText("CheckBox sin clicar");
                }
            }
        });

        finestra.setVisible(true);

        

    }
    
}
