package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exam {
    public static void main(String[] args) {
        // Establecer el LookAndFeel
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

        JFrame finestra = new JFrame("Ejemplos Integrados");
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setSize(600, 500);
        finestra.setLocationRelativeTo(null);
        finestra.setResizable(false);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Ejercicio 1: Slider
        JPanel sliderPanel = new JPanel(new BorderLayout());
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        JLabel sliderLabel = new JLabel("Valor: 0", JLabel.CENTER);
        sliderLabel.setFont(new Font("Arial", Font.BOLD, 20));
        slider.addChangeListener(e -> sliderLabel.setText("Valor: " + slider.getValue()));
        sliderPanel.add(slider, BorderLayout.CENTER);
        sliderPanel.add(sliderLabel, BorderLayout.SOUTH);
        tabbedPane.addTab("Slider", sliderPanel);

        // Ejercicio 2: CheckBox
        JPanel checkBoxPanel = new JPanel(new BorderLayout());
        JCheckBox checkBox = new JCheckBox("Click me!");
        checkBox.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel checkBoxLabel = new JLabel("CheckBox sin clicar", JLabel.CENTER);
        checkBoxLabel.setFont(new Font("Arial", Font.BOLD, 20));
        checkBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                checkBoxLabel.setText("CheckBox clicado");
            } else {
                checkBoxLabel.setText("CheckBox sin clicar");
            }
        });
        checkBoxPanel.add(checkBox, BorderLayout.NORTH);
        checkBoxPanel.add(checkBoxLabel, BorderLayout.CENTER);
        tabbedPane.addTab("CheckBox", checkBoxPanel);

        // Ejercicio 3: MouseListener
        JPanel mousePanel = new JPanel(new BorderLayout());
        JLabel mouseLabel = new JLabel("Passa el ratolí per damunt", JLabel.CENTER);
        mouseLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        mouseLabel.setOpaque(true);
        mouseLabel.setBackground(Color.LIGHT_GRAY);
        mouseLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseLabel.setText("Dins");
                mouseLabel.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseLabel.setText("Fora");
                mouseLabel.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}
        });
        mousePanel.add(mouseLabel, BorderLayout.CENTER);
        tabbedPane.addTab("MouseListener", mousePanel);

        // Ejercicio 4: KeyListener
        JPanel keyListenerPanel = new JPanel(new BorderLayout());
        JTextField textField = new JTextField();
        JLabel keyListenerLabel = new JLabel("Contador: 0", JLabel.CENTER);
        keyListenerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.addKeyListener(new KeyListener() {
            int contador = 0;

            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
                    contador++;
                    keyListenerLabel.setText("Contador: " + contador);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        keyListenerPanel.add(textField, BorderLayout.NORTH);
        keyListenerPanel.add(keyListenerLabel, BorderLayout.CENTER);
        tabbedPane.addTab("KeyListener", keyListenerPanel);

        // Ejercicio Extra: Botones
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        JButton button1 = new JButton("Botón 1");
        JButton button2 = new JButton("Botón 2");
        JButton button3 = new JButton("Botón 3");
        JLabel buttonLabel = new JLabel("Presiona un botón", JLabel.CENTER);
        buttonLabel.setFont(new Font("Arial", Font.BOLD, 20));
        button1.addActionListener(e -> buttonLabel.setText("Botón 1 presionado"));
        button2.addActionListener(e -> buttonLabel.setText("Botón 2 presionado"));
        button3.addActionListener(e -> buttonLabel.setText("Botón 3 presionado"));
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(buttonLabel);
        tabbedPane.addTab("Botones", buttonPanel);

        finestra.add(tabbedPane);
        finestra.setVisible(true);
    }
}