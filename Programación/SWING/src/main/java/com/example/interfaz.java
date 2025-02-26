package com.example;

import javax.swing.*;
import java.awt.*;

public class interfaz {
    // Interfaz registrar nuevo usuario
    public static void main(String[] args) {
        JFrame frame = new JFrame("Registrar nuevo usuario");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(java.awt.Color.GRAY);
        frame.setLocationRelativeTo(null);

        // Crear un Panel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("New User"));
        panel.setForeground(Color.red);
        panel.setBackground(java.awt.Color.LIGHT_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(-5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Agregar un label Account name al panel
        JLabel accountName = new JLabel("Account name:");
        accountName.setForeground(Color.BLUE);
        accountName.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(accountName, gbc);
        // Agregar un campo de texto al panel
        JTextField accountNameText = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(accountNameText, gbc);

        // Agregar un label Full name al panel
        JLabel fullName = new JLabel("Full name:");
        fullName.setForeground(Color.BLUE);
        fullName.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(fullName, gbc);
        // Agregar un campo de texto al panel
        JTextField fullNameText = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(fullNameText, gbc);

        // Agregar un laber password al panel
        JLabel password = new JLabel("Password:");
        password.setForeground(Color.BLUE);
        password.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(password, gbc);
        // Agregar un campo de texto al panel
        JPasswordField passwordText = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(passwordText, gbc);

        // Agregar un label repeat password al panel
        JLabel confirmPassword = new JLabel("Repeat password:");
        confirmPassword.setForeground(Color.BLUE);
        confirmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(confirmPassword, gbc);
        // Agregar un campo de texto al panel
        JPasswordField confirmPasswordText = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(confirmPasswordText, gbc);

        // Agregar un boton Add al panel
        JButton add = new JButton("Add");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(add, gbc);
        add.setBackground(Color.lightGray);

        // Añadir el panel al frame
        frame.add(panel, BorderLayout.CENTER);

        // Crear un Panel para "User Accounts"
        JPanel userAccountsPanel = new JPanel(new BorderLayout());
        userAccountsPanel.setBorder(BorderFactory.createTitledBorder("User Accounts"));
        userAccountsPanel.setForeground(Color.blue);
        userAccountsPanel.setBackground(Color.magenta);

        // Crear una tabla con dos columnas y tres filas
        String[] columnNames = { "User", "Full Name" };
        Object[][] data = {
            { "Karl", "Karl Max" },
            { "Vlad", "Vladimir Lenin" }
        };
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        // Ajustar el tamaño preferido del JScrollPane
        scrollPane.setPreferredSize(new Dimension(100, 100));
        userAccountsPanel.add(scrollPane, BorderLayout.CENTER);

        // Añadir el panel de "User Accounts" al frame
        frame.add(userAccountsPanel, BorderLayout.SOUTH);

        try {
        UIManager.setLookAndFeel("Javax.swing.plaf.metal.MetalFileChooserUI");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set the frame visibility to true
        frame.setVisible(true);

    }
}