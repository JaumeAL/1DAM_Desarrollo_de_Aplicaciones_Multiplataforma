package com.example;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FichaVideojuegos {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ficha de Videojuegos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Nombre del videojuego
        JLabel tituloJuego = new JLabel("Nombre del Videojuego:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(tituloJuego, gbc);
        JTextField tituloField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(tituloField, gbc);

        // Descripción del videojuego
        JLabel descripcionLabel = new JLabel("Descripción:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(descripcionLabel, gbc);
        JTextArea descripcionField = new JTextArea(3, 20);
        JScrollPane descripcionScroll = new JScrollPane(descripcionField);
        gbc.gridx = 1;
        panel.add(descripcionScroll, gbc);

        // Selección de plataforma
        JLabel plataformaLabel = new JLabel("Plataforma:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(plataformaLabel, gbc);
        JRadioButton pcButton = new JRadioButton("PC");
        JRadioButton ps4Button = new JRadioButton("PS4");
        JRadioButton xboxButton = new JRadioButton("Xbox");
        JRadioButton switchButton = new JRadioButton("Switch");
        ButtonGroup plataformaGroup = new ButtonGroup();
        plataformaGroup.add(pcButton);
        plataformaGroup.add(ps4Button);
        plataformaGroup.add(xboxButton);
        plataformaGroup.add(switchButton);
        JPanel radioPanel = new JPanel();
        radioPanel.add(pcButton);
        radioPanel.add(ps4Button);
        radioPanel.add(xboxButton);
        radioPanel.add(switchButton);
        gbc.gridx = 1;
        panel.add(radioPanel, gbc);

        // Campo de requisitos mínimos para PC
        JLabel requisitosLabel = new JLabel("Requisitos mínimos:");
        JTextField requisitosField = new JTextField(20);
        requisitosLabel.setVisible(false);
        requisitosField.setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(requisitosLabel, gbc);
        gbc.gridx = 1;
        panel.add(requisitosField, gbc);
        pcButton.addActionListener(e -> {
            requisitosLabel.setVisible(true);
            requisitosField.setVisible(true);
        });
        ActionListener ocultarRequisitos = e -> {
            requisitosLabel.setVisible(false);
            requisitosField.setVisible(false);
        };
        ps4Button.addActionListener(ocultarRequisitos);
        xboxButton.addActionListener(ocultarRequisitos);
        switchButton.addActionListener(ocultarRequisitos);

        // Género del videojuego
        JLabel generoLabel = new JLabel("Género:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(generoLabel, gbc);
        String[] generos = { "Acción", "Aventura", "RPG", "Estrategia", "Deportes" };
        JComboBox<String> generoBox = new JComboBox<>(generos);
        gbc.gridx = 1;
        panel.add(generoBox, gbc);

        // Modos de juego
        JLabel modosLabel = new JLabel("Modos de juego:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(modosLabel, gbc);
        JCheckBox multiCheck = new JCheckBox("Multijugador");
        JCheckBox coopCheck = new JCheckBox("Cooperativo");
        JCheckBox singleCheck = new JCheckBox("Un jugador");
        JPanel checkPanel = new JPanel();
        checkPanel.add(multiCheck);
        checkPanel.add(coopCheck);
        checkPanel.add(singleCheck);
        gbc.gridx = 1;
        panel.add(checkPanel, gbc);

        // Fecha de lanzamiento
        JLabel fechaLabel = new JLabel("Fecha de lanzamiento:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(fechaLabel, gbc);
        JSpinner fechaSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(fechaSpinner, "dd/MM/yyyy");
        fechaSpinner.setEditor(dateEditor);
        gbc.gridx = 1;
        panel.add(fechaSpinner, gbc);

        // Precio del videojuego
        JLabel precioLabel = new JLabel("Precio (€):");
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(precioLabel, gbc);
        JTextField precioField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(precioField, gbc);

        // Botón para mostrar la ficha
        JButton mostrarFichaButton = new JButton("Mostrar Ficha");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        panel.add(mostrarFichaButton, gbc);

        mostrarFichaButton.addActionListener(e -> {
            String titulo = tituloField.getText();
            String descripcion = descripcionField.getText();
            String plataforma = pcButton.isSelected() ? "PC" : ps4Button.isSelected() ? "PS4" : xboxButton.isSelected() ? "Xbox" : "Switch";
            String genero = (String) generoBox.getSelectedItem();
            String modos = (multiCheck.isSelected() ? "Multijugador, " : "") +
                           (coopCheck.isSelected() ? "Cooperativo, " : "") +
                           (singleCheck.isSelected() ? "Un jugador" : "");
            String fecha = new SimpleDateFormat("dd/MM/yyyy").format((Date) fechaSpinner.getValue());
            String precio = precioField.getText();
            String requisitos = pcButton.isSelected() ? requisitosField.getText() : "No aplica";
            JOptionPane.showMessageDialog(frame, "Videojuego: " + titulo + "\nDescripción: " + descripcion + "\nPlataforma: " + plataforma + "\nGénero: " + genero + "\nModos: " + modos + "\nFecha: " + fecha + "\nPrecio: " + precio + "€\nRequisitos: " + requisitos);
        });
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
