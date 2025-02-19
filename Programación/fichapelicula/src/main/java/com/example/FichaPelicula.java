package com.example;

import java.awt.*;
import javax.swing.*;

public class FichaPelicula {
   public FichaPelicula() {
   }

   public static void main(String[] args) {
      // Ventana principal
      JFrame frame = new JFrame("Ficha de Pelicula"); // Crear la ventana principal y establecer el título
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurar la ventana para cerrar la aplicación
      frame.setSize(400, 400); // Establecer el tamaño de la ventana
      frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

      // Panel
      JPanel panel = new JPanel(new GridBagLayout()); // Crear un JPanel para organizar los componentes
      GridBagConstraints gbc = new GridBagConstraints(); // Crear un objeto GridBagConstraints para gestionar el diseño
      gbc.fill = GridBagConstraints.HORIZONTAL; // Establecer el tipo de relleno horizontal
      gbc.fill = 2;
      gbc.insets = new Insets(5, 5, 5, 5); // Establecer los márgenes internos de los componentes

      // COMOPONENTES
      // Titulo de la pelicula:
      JLabel tituloLabel = new JLabel("Titulo de la Pelicula:"); // Crear un JLabel con un texto inicial
      gbc.gridx = 0;
      gbc.gridy = 0;
      panel.add(tituloLabel, gbc);
      JTextField tituloField = new JTextField(20); // Crear el campo de texto
      gbc.gridx = 1;
      panel.add(tituloField, gbc);
      // Genero de la pelicula:
      JLabel generoLabel = new JLabel("Genero:"); // Crear un JLabel con un texto inicial
      gbc.gridx = 0;
      gbc.gridy = 1;
      panel.add(generoLabel, gbc);
      String[] generos = new String[] { "Accion", "Comedia", "Drama", "Terror", "Ciencia Ficcion" }; // Crear un array
                                                                                                     // de géneros
      JComboBox<String> generoBox = new JComboBox<String>(generos); // Crear un JComboBox con el array de géneros
      gbc.gridx = 1;
      panel.add(generoBox, gbc);
      // Año de estreno:
      JLabel añoLabel = new JLabel("Año de estreno:"); // Crear un JLabel con un texto inicial
      gbc.gridx = 0;
      gbc.gridy = 2;
      panel.add(añoLabel, gbc);
      JSlider añoSlider = new JSlider(1900, 2025, 2000); // Crear un JSlider con un rango de años
      gbc.gridx = 1;
      panel.add(añoSlider, gbc);

      añoSlider.setMajorTickSpacing(25); // Establecer el espaciado de las marcas mayores
      añoSlider.setMinorTickSpacing(5); // Establecer el espaciado de las marcas menores
      añoSlider.setPaintTicks(true); // Mostrar las marcas en el JSlider
      añoSlider.setPaintLabels(true); // Mostrar los valores de las marcas en el JSlider
      // Año seleccionado:
      JLabel añoSeleccionadoLabel = new JLabel("2000"); // Crear un JLabel para mostrar el año seleccionado
      añoSlider.addChangeListener((e) -> { // Añadir un ChangeListener al JSlider
         añoSeleccionadoLabel.setText(String.valueOf(añoSlider.getValue())); // Actualizar el JLabel con el valor seleccionado
      });
      gbc.gridx = 0;
      gbc.gridy = 3;
      panel.add(new JLabel("Año seleccionado:"), gbc);
      gbc.gridx = 1;
      panel.add(añoSeleccionadoLabel, gbc);
      // Mostrar Ficha:
      JButton mostrarButton = new JButton("Mostrar Ficha"); // Crear un JButton con un texto inicial
      gbc.gridx = 0;
      gbc.gridy = 4;
      gbc.gridwidth = 2;
      panel.add(mostrarButton, gbc);
      JLabel resultadoLabel = new JLabel("Aqui se mostrara la informacion.");
      gbc.gridx = 0;
      gbc.gridy = 5;
      gbc.gridwidth = 2;
      panel.add(resultadoLabel, gbc);
      // Evento mostrar Ficha:
      mostrarButton.addActionListener((e) -> {
         String titulo = tituloField.getText();
         String genero = (String) generoBox.getSelectedItem();
         int año = añoSlider.getValue();
         resultadoLabel.setText("Pelicula: " + titulo + " | Genero: " + genero + " | Año: " + año);
      });
      gbc.gridx = 0;
      gbc.gridy = 4;
      gbc.gridwidth = 2;
      panel.add(mostrarButton, gbc);

      // Seleccionar Vocales:
      JLabel vocalLabel = new JLabel("Selecciona una vocal:"); // Crear un JLabel con un texto inicial
      gbc.gridx = 0;
      gbc.gridy = 6;
      panel.add(vocalLabel, gbc);
      String[] vocales = new String[] { "A", "E", "I", "O", "U" }; // Crear un array de vocales
      JComboBox<String> vocalBox = new JComboBox<String>(vocales); // Crear un JComboBox con el array de vocales
      gbc.gridx = 1;
      panel.add(vocalBox, gbc);
      // Contar Vocales:
      JButton contarVocalesButton = new JButton("Contar Vocales"); // Crear un JButton con un texto inicial
      gbc.gridx = 0;
      gbc.gridy = 7;
      gbc.gridwidth = 2;
      panel.add(contarVocalesButton, gbc);
      JLabel resultadoVocalesLabel = new JLabel("Numero de vocales: 0"); // Crear un JLabel para mostrar el resultado
      gbc.gridx = 0;
      gbc.gridy = 8;
      gbc.gridwidth = 2;
      panel.add(resultadoVocalesLabel, gbc);
      // Evento vocal seleccionada:
      contarVocalesButton.addActionListener((e) -> { // Añadir un ActionListener al JButton
         String titulo = tituloField.getText().toLowerCase(); // Obtener el texto del campo de texto y convertirlo a minúsculas
         String vocalSeleccionada = ((String) vocalBox.getSelectedItem()).toLowerCase(); // Obtener la vocal seleccionada y convertirla a minúsculas
         long count = titulo.chars().filter((ch) -> { // Contar el número de veces que aparece la vocal seleccionada en el título
            return ch == vocalSeleccionada.charAt(0); // Filtrar los caracteres que coinciden con la vocal seleccionada
         }).count(); // Contar el número de caracteres filtrados
         resultadoVocalesLabel.setText("Numero de vocales: " + count); // Actualizar el JLabel con el resultado
      });
      // Asustar al usuario:
      generoBox.addActionListener((e) -> {
         String generoSeleccionado = (String) generoBox.getSelectedItem(); // Obtener el género seleccionado
         if ("Terror".equals(generoSeleccionado)) { // Comprobar si el género seleccionado es "Terror"
            JOptionPane.showMessageDialog(frame, "Asustando al usuario! buuuuuu", "Advertencia", 2);
         }

      });

      frame.add(panel);
      frame.setVisible(true);
   }
}
