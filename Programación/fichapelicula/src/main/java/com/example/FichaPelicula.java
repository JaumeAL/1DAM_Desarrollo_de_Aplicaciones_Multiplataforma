package com.example;

import java.awt.*;
import javax.swing.*;

public class FichaPelicula {
   public FichaPelicula() {
   }

   public static void main(String[] args) {
      JFrame frame = new JFrame("Ficha de Pelicula");
      frame.setDefaultCloseOperation(3);
      frame.setSize(400, 400);
      JPanel panel = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.fill = 2;
      JLabel tituloLabel = new JLabel("Titulo de la Pelicula:");
      JTextField tituloField = new JTextField(20);
      JLabel generoLabel = new JLabel("Genero:");
      String[] generos = new String[] { "Accion", "Comedia", "Drama", "Terror", "Ciencia Ficcion" };
      JComboBox<String> generoBox = new JComboBox<String>(generos);
      JLabel añoLabel = new JLabel("A00f1o de estreno:");
      JSlider añoSlider = new JSlider(1900, 2025, 2000);
      añoSlider.setMajorTickSpacing(25);
      añoSlider.setMinorTickSpacing(5);
      añoSlider.setPaintTicks(true);
      añoSlider.setPaintLabels(true);
      JLabel añoSeleccionadoLabel = new JLabel("2000");
      JButton mostrarButton = new JButton("Mostrar Ficha");
      JLabel resultadoLabel = new JLabel("Aqu00ed se mostrar00e1 la informaci00f3n.");
      JLabel vocalLabel = new JLabel("Selecciona una vocal:");
      String[] vocales = new String[] { "A", "E", "I", "O", "U" };
      JComboBox<String> vocalBox = new JComboBox<String>(vocales);
      JButton contarVocalesButton = new JButton("Contar Vocales");
      JLabel resultadoVocalesLabel = new JLabel("N00famero de vocales: 0");
      añoSlider.addChangeListener((e) -> {
         añoSeleccionadoLabel.setText(String.valueOf(añoSlider.getValue()));
      });
      generoBox.addActionListener((e) -> {
         String generoSeleccionado = (String) generoBox.getSelectedItem();
         if ("Terror".equals(generoSeleccionado)) {
            JOptionPane.showMessageDialog(frame, "00a1Asustando al usuario! d83ddc7b", "Advertencia", 2);
         }

      });
      mostrarButton.addActionListener((e) -> {
         String titulo = tituloField.getText();
         String genero = (String) generoBox.getSelectedItem();
         int año = añoSlider.getValue();
         resultadoLabel.setText("Pelicula: " + titulo + " | G00e9nero: " + genero + " | A00f1o: " + año);
      });
      contarVocalesButton.addActionListener((e) -> {
         String titulo = tituloField.getText().toLowerCase();
         String vocalSeleccionada = ((String) vocalBox.getSelectedItem()).toLowerCase();
         long count = titulo.chars().filter((ch) -> {
            return ch == vocalSeleccionada.charAt(0);
         }).count();
         resultadoVocalesLabel.setText("N00famero de vocales: " + count);
      });
      gbc.gridx = 0;
      gbc.gridy = 0;
      panel.add(tituloLabel, gbc);
      gbc.gridx = 1;
      panel.add(tituloField, gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      panel.add(generoLabel, gbc);
      gbc.gridx = 1;
      panel.add(generoBox, gbc);
      gbc.gridx = 0;
      gbc.gridy = 2;
      panel.add(añoLabel, gbc);
      gbc.gridx = 1;
      panel.add(añoSlider, gbc);
      gbc.gridx = 0;
      gbc.gridy = 3;
      panel.add(new JLabel("A00f1o seleccionado:"), gbc);
      gbc.gridx = 1;
      panel.add(añoSeleccionadoLabel, gbc);
      gbc.gridx = 0;
      gbc.gridy = 4;
      gbc.gridwidth = 2;
      panel.add(mostrarButton, gbc);
      gbc.gridx = 0;
      gbc.gridy = 5;
      gbc.gridwidth = 2;
      panel.add(resultadoLabel, gbc);
      gbc.gridx = 0;
      gbc.gridy = 6;
      panel.add(vocalLabel, gbc);
      gbc.gridx = 1;
      panel.add(vocalBox, gbc);
      gbc.gridx = 0;
      gbc.gridy = 7;
      gbc.gridwidth = 2;
      panel.add(contarVocalesButton, gbc);
      gbc.gridx = 0;
      gbc.gridy = 8;
      gbc.gridwidth = 2;
      panel.add(resultadoVocalesLabel, gbc);
      frame.add(panel);
      frame.setVisible(true);
   }
}
