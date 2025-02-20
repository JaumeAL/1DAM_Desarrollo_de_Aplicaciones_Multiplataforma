package com.example;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MasVideojuego {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ficha de Videojuegos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Nombre del videojuego
        JLabel tituloJuego = new JLabel("Nombre del Videojuego:");
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(tituloJuego, gbc);
        JTextField tituloField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(tituloField, gbc);
        
        // Plataforma
        JLabel plataformaLabel = new JLabel("Plataforma:");
        gbc.gridx = 0; gbc.gridy = 1;
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
        
        // Fecha de lanzamiento
        JLabel fechaLabel = new JLabel("Fecha de Lanzamiento:");
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(fechaLabel, gbc);
        JSpinner fechaSpinner = new JSpinner(new SpinnerDateModel());
        gbc.gridx = 1;
        panel.add(fechaSpinner, gbc);
        
        // Género del videojuego
        JLabel generoLabel = new JLabel("Género:");
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(generoLabel, gbc);
        String[] generos = {"Acción", "Aventura", "RPG", "Estrategia", "Deportes"};
        JComboBox<String> generoBox = new JComboBox<>(generos);
        gbc.gridx = 1;
        panel.add(generoBox, gbc);
        
        // Requisitos mínimos para PC
        JLabel requisitosLabel = new JLabel("Requisitos mínimos:");
        JTextField requisitosField = new JTextField(20);
        requisitosLabel.setVisible(false);
        requisitosField.setVisible(false);
        gbc.gridx = 0; gbc.gridy = 4;
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
        
        // Descripción del videojuego
        JLabel descripcionLabel = new JLabel("Descripción:");
        gbc.gridx = 0; gbc.gridy = 5;
        panel.add(descripcionLabel, gbc);
        JTextArea descripcionArea = new JTextArea(3, 20);
        JScrollPane scrollDescripcion = new JScrollPane(descripcionArea);
        gbc.gridx = 1;
        panel.add(scrollDescripcion, gbc);
        
        // Checkbox de multijugador
        JCheckBox multijugadorCheck = new JCheckBox("¿Tiene multijugador?");
        gbc.gridx = 1; gbc.gridy = 6;
        panel.add(multijugadorCheck, gbc);
        
        // Botón para mostrar ficha
        JButton mostrarFichaButton = new JButton("Mostrar Ficha");
        gbc.gridx = 0; gbc.gridy = 7;
        gbc.gridwidth = 2;
        panel.add(mostrarFichaButton, gbc);
        
        // Etiqueta para mostrar resultado
        JLabel resultadoLabel = new JLabel("Aquí se mostrará la información.");
        gbc.gridx = 0; gbc.gridy = 8;
        gbc.gridwidth = 2;
        panel.add(resultadoLabel, gbc);
        
        // Historial de videojuegos ingresados
        DefaultListModel<String> listaModel = new DefaultListModel<>();
        JList<String> listaHistorial = new JList<>(listaModel);
        JScrollPane scrollLista = new JScrollPane(listaHistorial);
        gbc.gridx = 0; gbc.gridy = 9;
        gbc.gridwidth = 2;
        panel.add(scrollLista, gbc);
        
        // Botón para limpiar el formulario
        JButton limpiarButton = new JButton("Limpiar Formulario");
        gbc.gridx = 0; gbc.gridy = 10;
        gbc.gridwidth = 2;
        panel.add(limpiarButton, gbc);
        
        // Evento para mostrar ficha
        mostrarFichaButton.addActionListener(e -> {
            String titulo = tituloField.getText();
            String plataforma = pcButton.isSelected() ? "PC" :
                               ps4Button.isSelected() ? "PS4" :
                               xboxButton.isSelected() ? "Xbox" : "Switch";
            Date fechaLanzamiento = (Date) fechaSpinner.getValue();
            String genero = (String) generoBox.getSelectedItem();
            String requisitos = requisitosField.getText();
            String descripcion = descripcionArea.getText();
            boolean tieneMultijugador = multijugadorCheck.isSelected();
            String mensaje = "Videojuego: " + titulo + " | Plataforma: " + plataforma +
                             " | Fecha: " + fechaLanzamiento + " | Género: " + genero +
                             (pcButton.isSelected() ? " | Requisitos: " + requisitos : "") +
                             " | Descripción: " + descripcion +
                             " | Multijugador: " + (tieneMultijugador ? "Sí" : "No");
            resultadoLabel.setText(mensaje);
            listaModel.addElement(titulo);
        });
        
        // Evento para limpiar formulario
        limpiarButton.addActionListener(e -> {
            tituloField.setText("");
            plataformaGroup.clearSelection();
            requisitosField.setText("");
            descripcionArea.setText("");
            multijugadorCheck.setSelected(false);
        });
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
