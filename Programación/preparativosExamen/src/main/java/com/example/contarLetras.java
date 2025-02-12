package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class contarLetras {

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
        JLabel labelC = new JLabel("Contador C: 0");
        panel.add(labelC);
        //Boton que analiza el texto y cuenta las letras a y e
        JButton contar = new JButton();
        contar.setText("Contar");
        panel.add(contar);

        contar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText(); // Obtener el texto del JTextField
                int countA = 0; // Inicializar el contador para 'a'
                int countE = 0; // Inicializar el contador para 'e'
                int conutC = 0; // Inicializar el contador para 'c'
                for (int i = 0; i < text.length(); i++) {
                    char c = text.charAt(i); // Obtener el carácter en la posición i
                    if (c == 'a' || c == 'A') { // Comprobar si el carácter es 'a' o 'A'
                        countA++; // Incrementar el contador para 'a'
                    } else if (c == 'e' || c == 'E') { // Comprobar si el carácter es 'e' o 'E'
                        countE++; // Incrementar el contador para 'e'
                    }else if (c =='c' || c =='C') {
                        conutC++;
                    }
                }
                labelA.setText("Contador A: " + countA); // Actualizar el texto del JLabel para 'a'
                labelE.setText("Contador E: " + countE); // Actualizar el texto del JLabel para 'e'
                labelC.setText("Contador C: "+ conutC);
            }
        });

        finestra.add(panel); // Añadir el panel a la ventana
        finestra.setVisible(true); // Hacer visible la ventana
    }
}