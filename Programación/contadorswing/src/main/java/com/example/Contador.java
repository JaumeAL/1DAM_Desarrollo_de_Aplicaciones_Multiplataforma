package com.example;

import java.awt.*;
import javax.swing.*;

public class Contador {
  public Contador() {
  }

  public static void main(String[] args) {

    // Ventana principal
    JFrame frame = new JFrame("Contador hasta 10"); // Crear la ventana principal y establecer el título
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurar la ventana para cerrar la aplicación
    frame.setSize(400, 400); // Establecer el tamaño de la ventana
    frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

    // Panel
    JPanel panel = new JPanel(new GridBagLayout()); // Crear un JPanel para organizar los componentes
    GridBagConstraints gbc = new GridBagConstraints(); // Crear un objeto GridBagConstraints para gestionar el diseño
    gbc.fill = GridBagConstraints.HORIZONTAL; // Establecer el tipo de relleno horizontal
    gbc.insets = new Insets(5, 5, 5, 5); // Establecer los márgenes internos de los componentes

    // Etiqueta
    JLabel etiqueta = new JLabel("0"); // Crear un JLabel con un texto inicial
    gbc.gridx = 1;
    gbc.gridy = 0;
    panel.add(etiqueta, gbc);
    // Boton sumar
    JButton sumar = new JButton("SUMAR"); // Crear un JButton con un texto inicial
    gbc.gridx = 0;
    gbc.gridy = 1;
    panel.add(sumar, gbc);
    // Boton restar
    JButton restar = new JButton("RESTAR"); // Crear un JButton con un texto inicial
    gbc.gridx = 1;
    gbc.gridy = 1;
    panel.add(restar, gbc);
    // Boton Reset solo visibe si el contador llega a 10
    JButton botonReset = new JButton("Reset"); // Crear un JButton con un texto inicial
    gbc.gridx = 0;
    gbc.gridy = 2;
    panel.add(botonReset, gbc);
    botonReset.setVisible(false); // Ocultar el botón reset

    // Evento reset
    botonReset.addActionListener((e) -> {
      etiqueta.setText("0"); // Actualizar la etiqueta con el nuevo valor
      sumar.setEnabled(true); // Habilitar el botón
      botonReset.setVisible(false); // Ocultar el botón reset

    });

    // Evento sumar hasta 10
    sumar.addActionListener((e) -> {
      int contador = Integer.parseInt(etiqueta.getText()); // Obtener el valor actual de la etiqueta
      contador++; // Incrementar el contador
      etiqueta.setText(String.valueOf(contador)); // Actualizar la etiqueta con el nuevo valor
      restar.setEnabled(true);
      if (contador == 10) { // Si el contador llega a 10
        sumar.setEnabled(false); // Deshabilitar el botón
        botonReset.setVisible(true); // Mostrar el botón reset
      }

    });

    // Evento restar hasta 0
    restar.addActionListener((e) -> {
      int contador1 = Integer.parseInt(etiqueta.getText()); // Obtener el valor actual de la etiqueta
      contador1--; // Disminuir el contador
      etiqueta.setText(String.valueOf(contador1)); // Actualizar la etiqueta con el nuevo valor
      sumar.setEnabled(true);
      if (contador1 == 0) {
        restar.setEnabled(false);
      }

    });

    frame.add(panel);
    frame.setVisible(true);
  }
}