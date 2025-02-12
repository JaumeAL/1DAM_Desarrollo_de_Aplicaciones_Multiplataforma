package com.example;

import javax.swing.*; // Importem la llibreria Swing per crear la interfície gràfica
import javax.swing.event.*;
import java.awt.*; // Importem la llibreria per gestionar el disseny

public class adivinarNumero {

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
        //Programa de adivinar el numero en el que estoy pensando
        JFrame finestra = new JFrame("Exemple Swing"); // Crear la ventana principal
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurar la ventana para cerrar la aplicación
        finestra.setSize(350, 200); // Establecer el tamaño de la ventana
        finestra.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        finestra.setResizable(false); // Hacer que la ventana no se pueda redimensionar


        JPanel panel = new JPanel(); // Crear un JPanel para organizar los componentes

        panel.setLayout(new GridLayout(5, 1)); // Establecer un diseño de cuadrícula con 5 filas y 1 columna
        JLabel adivina = new JLabel("Adivina el numero del 1 al 100:"); // Crear un JLabel con un texto inicial
        panel.add(adivina); // Añadir el JLabel al panel

        JTextField textField = new JTextField(); // Crear un JTextField
        panel.add(textField); // Añadir el JTextField al panel

        JButton button = new JButton("Comprobar"); // Crear un JButton
        panel.add(button); // Añadir el JButton al panel

        JLabel label = new JLabel("..."); 
        panel.add(label); // Añadir el JLabel al panel
        label.setFont(new Font("Arial", Font.PLAIN, 20)); // Establecer la fuente del JLabel
        label.setForeground(Color.black);

        JButton reiniciar = new JButton("Reiniciar"); // Crear un JButton
        panel.add(reiniciar); // Añadir el JButton al panel
        
        final int[] numero = {(int) (Math.random() * 100 + 1)}; 
        
        button.addActionListener(e -> { // Añadir un Listener al JButton
            try {
                int intento = Integer.parseInt(textField.getText()); // Obtener el número introducido por el usuario
                if (intento < numero[0]) {
                    label.setText("Demasiado bajo ↓");
                    label.setForeground(Color.red);
                } else if (intento > numero[0]) {
                    label.setText("Demasiado alto ↑");
                    label.setForeground(Color.red);
                } else {
                    label.setText("Felicidades, has adivinado el número!");
                    label.setForeground(Color.green);
                }
            } catch (NumberFormatException ex) {
                label.setText("Por favor, introduce un número válido.");
            }
        });

        reiniciar.addActionListener(e -> { // Añadir un Listener al JButton
            numero[0] = (int) (Math.random() * 100 + 1); // Generar un nuevo número aleatorio
            label.setText("..."); 
            label.setForeground(Color.black);
            textField.setText(""); 
        });
        

        finestra.add(panel); // Añadir el panel a la ventana
        finestra.setVisible(true); // Hacer visible la ventana
        
    }
    
}
