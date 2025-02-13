package com.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompleteSwingApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}

class MainFrame extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextArea notifications;

    public MainFrame() {
        setTitle("Aplicación Completa en Swing");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        setJMenuBar(createMenuBar());
        add(createSidebar(), BorderLayout.WEST);
        add(createTabbedPane(), BorderLayout.CENTER);
        add(createNotificationPanel(), BorderLayout.SOUTH);
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("Archivo");
        JMenuItem exitItem = new JMenuItem("Salir");
        exitItem.addActionListener(e -> System.exit(0));
        menuFile.add(exitItem);
        menuBar.add(menuFile);
        return menuBar;
    }

    private JPanel createSidebar() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 5, 5));
        panel.setPreferredSize(new Dimension(200, 0));
        panel.setBorder(BorderFactory.createTitledBorder("Opciones"));

        JButton btn3 = new JButton("Añadir usuario");
        btn3.addActionListener(e -> addUser());
        btn3.setBackground(Color.lightGray);
        JButton btn2 = new JButton("Buscar usuario");
        btn2.addActionListener(e -> searchUser());
        btn2.setBackground(Color.lightGray);
        JButton btn1 = new JButton("Borrar usuario");
        btn1.addActionListener(e -> deleteUser());
        btn1.setBackground(Color.lightGray);
        btn1.setForeground(Color.red);

        panel.add(btn3);
        panel.add(btn2);
        panel.add(btn1);
        return panel;
    }

    private JTabbedPane createTabbedPane() {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Tabla", createTablePanel());
        tabbedPane.addTab("Formulario", createFormPanel());
        return tabbedPane;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        tableModel = new DefaultTableModel(new String[]{"ID", "Nombre", "Apellidos", "Edad"}, 0);
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.setRowHeight(25);
        table.setSelectionBackground(Color.LIGHT_GRAY);
        table.setSelectionForeground(Color.BLACK);

        tableModel.addRow(new Object[]{1, "Jaume Albert", "Salas", 18});
        tableModel.addRow(new Object[]{2, "Miguel", "Zurita", 18});
        tableModel.addRow(new Object[]{3, "Hector", "Rodriguez", 19});

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Nuevo Usuario"));

        JTextField txtName = new JTextField();
        JTextField txtSurn = new JTextField();
        JTextField txtAge = new JTextField();
        JButton btnSubmit = new JButton("Agregar");
        
        panel.add(new JLabel("Nombre:"));
        panel.add(txtName);
        panel.add(new JLabel("Apellidos:"));
        panel.add(txtSurn);
        panel.add(new JLabel("Edad:"));
        panel.add(txtAge);
        panel.add(new JLabel());
        panel.add(btnSubmit);
        
        btnSubmit.addActionListener(e -> {
            String name = txtName.getText();
            String surn = txtSurn.getText();
            try {
                int age = Integer.parseInt(txtAge.getText());
                tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, name, surn, age});
                showNotification("Usuario agregado: " + name);
            } catch (NumberFormatException ex) {
                showNotification("Edad inválida");
            }
        });
        
        return panel;
    }

    private JPanel createNotificationPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Notificaciones"));
        notifications = new JTextArea(2, 40);
        notifications.setEditable(false);
        panel.add(new JScrollPane(notifications), BorderLayout.CENTER);
        return panel;
    }

    private void deleteUser() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int result = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres borrar este usuario?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                String name = (String) tableModel.getValueAt(selectedRow, 1);
                tableModel.removeRow(selectedRow);
                showNotification("Usuario borrado: " + name);
            }
        } else {
            showNotification("Selecciona un usuario para borrar");
        }
    }

    private void searchUser() {
        String name = JOptionPane.showInputDialog("Introduce el nombre del usuario");
        if (name != null && !name.isEmpty()) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (name.equalsIgnoreCase((String) tableModel.getValueAt(i, 1))) {
                    table.setRowSelectionInterval(i, i);
                    showNotification("Usuario encontrado: " + name);
                    return;
                }
            }
            showNotification("Usuario no encontrado: " + name);
        }
    }

    private void addUser() {
        String name = JOptionPane.showInputDialog("Introduce el nombre del usuario");
        String surn = JOptionPane.showInputDialog("Introduce los apellidos del usuario");
        String age = JOptionPane.showInputDialog("Introduce la edad del usuario");
        if (name != null && surn != null && age != null) {
            try {
                int ageInt = Integer.parseInt(age);
                tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, name, surn, ageInt});
                showNotification("Usuario agregado: " + name);
            } catch (NumberFormatException ex) {
                showNotification("Edad inválida");
            }
        }
    }

    private void showNotification(String message) {
        notifications.append(message + "\n");
    }
}
