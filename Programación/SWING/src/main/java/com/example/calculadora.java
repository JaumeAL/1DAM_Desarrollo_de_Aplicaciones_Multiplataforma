package main.java.com.example;

import javax.swing.*; // Importem la llibreria Swing per crear la interfície gràfica
import java.awt.*; // Importem la llibreria per gestionar el disseny
import java.awt.event.*; // Importem la llibreria per gestionar els esdeveniments

public class calculadora {
    public static void main(String[] args) {
        JFrame finestra = new JFrame("Calculadora"); // Creem la finestra principal
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurem la finestra per tancar l'aplicació
        finestra.setSize(300, 150); // Establim la mida de la finestra

        JPanel panel = new JPanel(); // Creem un JPanel per organitzar els components
        panel.setLayout(new GridLayout(3, 1)); // Establim un disseny de graella amb 3 files i 1 columna

        JTextField campText = new JTextField(15); // Creem un camp de text
        panel.add(campText); // Afegim el camp de text al panell

        JLabel etiqueta = new JLabel("Aquí irà el text..."); // Creem una etiqueta per mostrar el text
        panel.add(etiqueta); // Afegim l'etiqueta al panell

        JButton boto = new JButton("Mostrar text"); // Creem un botó
        panel.add(boto); // Afegim el botó al panell

        boto.addActionListener(new ActionListener() { // Afegim un gestor d'esdeveniments al botó
            @Override
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText(campText.getText()); // Copiem el text a l'etiqueta
            }
        });

        finestra.add(panel); // Afegim el panell a la finestra
        finestra.setVisible(true); // Fem visible la finestra principal
    JPanel panelBotones = new JPanel();
    panelBotones.setLayout(new GridLayout(4, 4));

    String[] botones = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ".", "=", "+"
    };

    for (String texto : botones) {
        JButton boton = new JButton(texto);
        panelBotones.add(boton);
        boton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            if (comando.equals("=")) {
            try {
                etiqueta.setText(eval(campText.getText()));
            } catch (Exception ex) {
                etiqueta.setText("Error");
            }
            } else {
            campText.setText(campText.getText() + comando);
            }
        }
        });
    }

    panel.add(panelBotones);
    }

    private static String eval(String expression) {
    // Simple evaluation logic (not recommended for production use)
    try {
        return Double.toString(new ScriptEngineManager().getEngineByName("JavaScript").eval(expression));
    } catch (Exception e) {
        return "Error";
    }
    }
    }
