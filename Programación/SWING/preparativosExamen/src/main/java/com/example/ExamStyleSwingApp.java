package com.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExamStyleSwingApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ExamFrame().setVisible(true));
    }
}

class ExamFrame extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtName, txtAge;
    private JLabel statusLabel;

    public ExamFrame() {
        setTitle("Gestión de Usuarios");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Menú
        setJMenuBar(createMenuBar());
        
        // Panel principal
        add(createMainPanel(), BorderLayout.CENTER);
        
        // Barra de estado
        statusLabel = new JLabel("Bienvenido");
        add(statusLabel, BorderLayout.SOUTH);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem exitItem = new JMenuItem("Salir");
        exitItem.addActionListener(e -> System.exit(0));
        menu.add(exitItem);
        menuBar.add(menu);
        return menuBar;
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Formulario
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Nuevo Usuario"));
        txtName = new JTextField();
        txtAge = new JTextField();
        JButton btnAdd = new JButton("Añadir");
        btnAdd.addActionListener(e -> addUser());
        
        formPanel.add(new JLabel("Nombre:"));
        formPanel.add(txtName);
        formPanel.add(new JLabel("Edad:"));
        formPanel.add(txtAge);
        
        // Tabla
        String[] columns = {"Nombre", "Edad"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        
        // Botones
        JPanel buttonPanel = new JPanel();
        JButton btnDelete = new JButton("Eliminar Seleccionado");
        btnDelete.addActionListener(e -> deleteUser());
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);
        
        // Agregar componentes
        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }

    private void addUser() {
        String name = txtName.getText();
        String ageText = txtAge.getText();
        
        if (name.isEmpty() || ageText.isEmpty()) {
            statusLabel.setText("Error: Todos los campos son obligatorios");
            return;
        }
        
        try {
            int age = Integer.parseInt(ageText);
            tableModel.addRow(new Object[]{name, age});
            txtName.setText("");
            txtAge.setText("");
            statusLabel.setText("Usuario añadido correctamente");
        } catch (NumberFormatException e) {
            statusLabel.setText("Error: La edad debe ser un número");
        }
    }

    private void deleteUser() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
            statusLabel.setText("Usuario eliminado");
        } else {
            statusLabel.setText("Error: Selecciona un usuario para eliminar");
        }
    }
}
