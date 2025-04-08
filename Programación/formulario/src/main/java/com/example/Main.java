package com.example;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Formulario de Usuario");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null); // Centrar la ventana

            JTabbedPane tabbedPane = new JTabbedPane();

            // Panel de formulario
            JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
            JLabel nameLabel = new JLabel("Nombre:");
            JTextField nameField = new JTextField();
            JLabel emailLabel = new JLabel("Email:");
            JTextField emailField = new JTextField();
            JLabel ageLabel = new JLabel("Edad:");
            JTextField ageField = new JTextField();
            JButton submitButton = new JButton("Enviar");

            formPanel.add(nameLabel);
            formPanel.add(nameField);
            formPanel.add(emailLabel);
            formPanel.add(emailField);
            formPanel.add(ageLabel);
            formPanel.add(ageField);
            formPanel.add(new JLabel()); // Espacio vacío
            formPanel.add(submitButton);

            // Panel de datos
            JPanel dataPanel = new JPanel(new GridLayout(4, 1, 10, 10));
            JLabel displayDataLabel = new JLabel("Datos del Usuario:");
            JLabel displayName = new JLabel();
            JLabel displayEmail = new JLabel();
            JLabel displayAge = new JLabel();
            JButton modifyButton = new JButton("Modificar");

            dataPanel.add(displayDataLabel);
            dataPanel.add(displayName);
            dataPanel.add(displayEmail);
            dataPanel.add(displayAge);
            dataPanel.add(modifyButton);

            // Agregar pestañas
            tabbedPane.addTab("Formulario", formPanel);
            tabbedPane.addTab("Datos", dataPanel);

            // Deshabilitar la pestaña de datos inicialmente
            tabbedPane.setEnabledAt(1, false);

            // Acción del botón Enviar
            submitButton.addActionListener(e -> {
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String ageText = ageField.getText().trim();

                // Validaciones
                if (name.isEmpty() || email.isEmpty() || ageText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!Pattern.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", name)) {
                    JOptionPane.showMessageDialog(frame, "El nombre solo puede contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!Pattern.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", email)) {
                    JOptionPane.showMessageDialog(frame, "El email no tiene un formato válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int age;
                try {
                    age = Integer.parseInt(ageText);
                    if (age <= 0) {
                        JOptionPane.showMessageDialog(frame, "La edad debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "La edad debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Si todas las validaciones pasan, mostrar los datos en la pestaña de datos
                displayName.setText("Nombre: " + name);
                displayEmail.setText("Email: " + email);
                displayAge.setText("Edad: " + age);

                // Habilitar la pestaña de datos y cambiar a ella
                tabbedPane.setEnabledAt(1, true);
                tabbedPane.setSelectedIndex(1);
            });

            // Acción del botón Modificar
            modifyButton.addActionListener(e -> {
                // Volver a la pestaña de formulario
                tabbedPane.setSelectedIndex(0);
            });

            frame.add(tabbedPane);
            frame.setVisible(true);
        });
    }
}