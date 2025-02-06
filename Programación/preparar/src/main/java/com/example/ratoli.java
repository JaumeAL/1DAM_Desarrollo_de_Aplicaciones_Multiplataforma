package com.example;

import javax.swing.*; // Importem la llibreria Swing per crear la interfície gràfica
import java.awt.*; // Importem la llibreria per gestionar el disseny
import java.awt.event.*; // Importem la llibreria per gestionar els esdeveniments

public class ratoli {
    
    public static void main(String[] args) {
        //3. Fes una aplicació que contengui un objecte jlabel. Fes que quan el ratolí passi per damunt (sense clickar) del label, el contigut digui "Dentro" i quan el ratolí surti del label mostri "Fuera". (mouseListener)
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

        JLabel label = new JLabel("Passa el ratolí per damunt"); //Creem un JLabel amb un text inicial
        panel.add(label); //Afegim el JLabel al panell

        label.addMouseListener(new MouseListener() { //Afegim un Listener al JLabel
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("Dins"); //Canviem el text del JLabel quan el ratolí entra
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("Fora"); //Canviem el text del JLabel quan el ratolí surt
            }
        });

        finestra.add(panel); //Afegim el panell a la finestra
        finestra.setVisible(true); //Fem visible la finestra
        
    }
}
