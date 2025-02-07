package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IntegratedExample {

    public static void main(String[] args) {
        // Establim el LookAndFeel
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
        finestra.setSize(400, 300);
        finestra.setLocationRelativeTo(null);
        finestra.setResizable(false);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Ejercicio 1: Slider
        JPanel sliderPanel = new JPanel(new GridLayout(4, 2));
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        JLabel sliderLabel = new JLabel("0");
        slider.addChangeListener(e -> sliderLabel.setText(String.valueOf(slider.getValue())));
        sliderPanel.add(slider);
        sliderPanel.add(sliderLabel);
        tabbedPane.addTab("Slider", sliderPanel);

        // Ejercicio 2: CheckBox
        JPanel checkBoxPanel = new JPanel(new FlowLayout());
        JCheckBox checkBox = new JCheckBox();
        JLabel checkBoxLabel = new JLabel("CheckBox sin clicar");
        checkBoxLabel.setFont(new Font("Arial", Font.BOLD, 20));
        checkBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                checkBoxLabel.setText("CheckBox clicado");
            } else {
                checkBoxLabel.setText("CheckBox sin clicar");
            }
        });
        checkBoxPanel.add(checkBox);
        checkBoxPanel.add(checkBoxLabel);
        tabbedPane.addTab("CheckBox", checkBoxPanel);

        // Ejercicio 3: MouseListener
        JPanel mousePanel = new JPanel(new GridLayout(4, 2));
        JLabel mouseLabel = new JLabel("Passa el ratolí per damunt");
        mouseLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        mouseLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseLabel.setText("Dins");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseLabel.setText("Fora");
            }

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}
        });
        mousePanel.add(mouseLabel);
        tabbedPane.addTab("MouseListener", mousePanel);

        // Ejercicio 4: KeyListener
        JPanel keyListenerPanel = new JPanel(new GridLayout(4, 2));
        JTextField textField = new JTextField();
        JLabel keyListenerLabel = new JLabel("0");
        textField.addKeyListener(new KeyListener() {
            int contador = 0;

            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
                    contador++;
                    keyListenerLabel.setText(String.valueOf(contador));
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        keyListenerPanel.add(textField);
        keyListenerPanel.add(keyListenerLabel);
        tabbedPane.addTab("KeyListener", keyListenerPanel);

        finestra.add(tabbedPane);
        finestra.setVisible(true);
    }
}