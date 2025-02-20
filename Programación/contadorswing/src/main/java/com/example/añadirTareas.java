package com.example;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class añadirTareas {
    public añadirTareas() {
    }

    public static void main(String[] args) {
        //App para añadir tareas en forma de lista
        JFrame frame = new JFrame("Añadir Tareas"); // Crear la ventana principal y establecer el título
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurar la ventana para cerrar la aplicación
        frame.setSize(400, 400); // Establecer el tamaño de la ventana
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Panel
        JPanel panel = new JPanel(new GridBagLayout()); // Crear un JPanel para organizar los componentes
        GridBagConstraints gbc = new GridBagConstraints(); // Crear un objeto GridBagConstraints para gestionar el diseño
        gbc.fill = GridBagConstraints.HORIZONTAL; // Establecer el tipo de relleno horizontal
        gbc.insets = new Insets(5, 5, 5, 5); // Establecer los márgenes internos de los componentes
        // TextField tarea
        JTextField tarea = new JTextField("escribe una tarea"); // Crear un JLabel con un texto inicial
        gbc.gridy = 0;
        panel.add(tarea, gbc);  
        // Boton añadir
        JButton añadir = new JButton("AÑADIR"); // Crear un JButton con un texto inicial
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(añadir, gbc);
        // Boton borrar
        JButton borrar = new JButton("BORRAR"); // Crear un JButton con un texto inicial
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(borrar, gbc);
        // Etiqueta
        JLabel etiqueta = new JLabel("Tareas"); // Crear un JLabel con un texto inicial
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(etiqueta, gbc);
        //Evento limpiar tarea al poner el foco encima
        tarea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                tarea.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        
        
        // Evento añadir
        añadir.addActionListener((e) -> {
            // Añadir tareas una debajo de la otra
            String textTarea = tarea.getText();
            if (!textTarea.isEmpty()) {
            etiqueta.setText("<html>" + etiqueta.getText().replace("<html>", "").replace("</html>", "") + "<br>" + textTarea + "</html>");
            tarea.setText(""); // Limpiar el campo de texto después de añadir la tarea
            }
        });

        // Evento borrar
        borrar.addActionListener((e) -> {
            //Borrar tarea
        });

        frame.add(panel); // Agregar el panel a la ventana
        frame.setVisible(true); // Hacer visible la ventana
    }
}
