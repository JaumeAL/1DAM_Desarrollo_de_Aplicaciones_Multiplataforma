//Lectura i escriptura de fitxers
//Objectiu
//Desenvolupar una aplicació gràfica en Java Swing i Java.io que permeti:
//Introduir el nom d’un fitxer de text.
//Llegir i mostrar el contingut del fitxer.
//Escriure al fitxer el text indicat.
//Decidir si s’ha de sobreescriure el fitxer o afegir text al final.

package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import java.util.logging.*;


public class Main {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Editor de fixers de test");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurar la ventana para cerrar la aplicación
      frame.setSize(500, 700); // Establecer el tamaño de la ventana
      frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

      // Panel
      JPanel panel = new JPanel(new GridBagLayout()); // Crear un JPanel para organizar los componentes
      GridBagConstraints gbc = new GridBagConstraints(); // Crear un objeto GridBagConstraints para gestionar el diseño
      gbc.fill = GridBagConstraints.HORIZONTAL; // Establecer el tipo de relleno horizontal
      gbc.fill = 2;
  



      frame.add(panel);
      frame.setVisible(true);
    }
}