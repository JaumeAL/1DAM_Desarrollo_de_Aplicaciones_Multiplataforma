package com.example;

import javax.swing.*;

public class MiVentana {
    public static void main(String[] args) {
        // Apuntes de Swing
        JFrame frame = new JFrame("Mi Aplicación"); // Crear la ventana
        frame.setSize(400, 300); // Establecer tamaño
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar al salir

        // Componentes basicos
        JLabel label = new JLabel("Texto de etiqueta");
        panel.add(label);

        JTextField campoTexto = new JTextField(20);
        panel.add(campoTexto);

        frame.setVisible(true); // Hacer visible
    }

}