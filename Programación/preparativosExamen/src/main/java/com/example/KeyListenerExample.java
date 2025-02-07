package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyListenerExample {

    public static void main(String[] args) {
        // Establecer el LookAndFeel
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

        JFrame finestra = new JFrame("Exemple Swing"); // Crear la ventana principal
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurar la ventana para cerrar la aplicación
        finestra.setSize(350, 200); // Establecer el tamaño de la ventana
        finestra.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        finestra.setResizable(false); // Hacer que la ventana no se pueda redimensionar

        JPanel panel = new JPanel(); // Crear un JPanel para organizar los componentes
        panel.setLayout(new GridLayout(5, 1)); // Establecer un diseño de cuadrícula con 5 filas y 1 columna

        JTextField textField = new JTextField(); // Crear un JTextField
        panel.add(textField); // Añadir el JTextField al panel

        JLabel labelA = new JLabel("Contador A: 0"); // Crear un JLabel con el valor inicial para 'a'
        panel.add(labelA); // Añadir el JLabel al panel

        JLabel labelE = new JLabel("Contador E: 0"); // Crear un JLabel con el valor inicial para 'e'
        panel.add(labelE); // Añadir el JLabel al panel



        KeyListener keyListener = new KeyListener() { // Añadir un Listener al JTextField
            int contadorA = 0; // Crear un contador para 'a'
            int contadorE = 0; // Crear un contador para 'e'

            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') { // Comprobar si la letra presionada es una "a" o "A"
                    contadorA++; // Incrementar el contador de 'a'
                    labelA.setText("Contador A: " + contadorA); // Mostrar el valor del contador en el JLabel
                } else if (e.getKeyChar() == 'e' || e.getKeyChar() == 'E') { // Comprobar si la letra presionada es una "e" o "E"
                    contadorE++; // Incrementar el contador de 'e'
                    labelE.setText("Contador E: " + contadorE); // Mostrar el valor del contador en el JLabel
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
            @Override
            public void resetCounters() {
                contadorA = 0;
                contadorE = 0;
                labelA.setText("Contador A: 0");
                labelE.setText("Contador E: 0");
            }
        };

        textField.addKeyListener(keyListener);




        finestra.add(panel); // Añadir el panel a la ventana
        finestra.setVisible(true); // Hacer visible la ventana
    }
}