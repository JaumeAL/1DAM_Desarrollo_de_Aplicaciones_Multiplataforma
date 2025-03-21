package com.example;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class inicio extends JFrame {

    private JPanel contentPane;
    private JTextField jugador1Field;
    private JTextField jugador2Field;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    inicio frame = new inicio();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public inicio() {
        setTitle("Poong2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 370, 500);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(232, 232, 232)); // COLOR DE FONDO
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // IMAGEN
        ImageIcon icono = new ImageIcon(getClass().getResource("/com/example/logo.png")); // Ruta de la imagen
        JLabel etiqueta = new JLabel(icono);
        etiqueta.setBounds(50, 5, 250, 190); // UBICACIÓN DE LA IMAGEN
        contentPane.add(etiqueta);

        // NOMBRE JUGADOR 1
        JLabel jugador1Label = new JLabel("Nombre del Jugador 1:");
        jugador1Label.setFont(new Font("Tahoma", Font.PLAIN, 18));hhg
        jugador1Label.setBounds(35, 190, 300, 28);
        contentPane.add(jugador1Label);

        jugador1Field = new JTextField();
        jugador1Field.setBounds(35, 220, 278, 28);
        contentPane.add(jugador1Field);
        jugador1Field.setColumns(10);

        // NOMBRE JUGADOR 2
        JLabel jugador2Label = new JLabel("Nombre del Jugador 2:");
        jugador2Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        jugador2Label.setBounds(35, 250, 300, 28);
        contentPane.add(jugador2Label);

        jugador2Field = new JTextField();
        jugador2Field.setBounds(35, 280, 278, 28);
        contentPane.add(jugador2Field);
        jugador2Field.setColumns(10);

        // BOTÓN START
        JButton btnStartGame = new JButton("JUGAR");
        btnStartGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarJuego();
            }
        });
        btnStartGame.setForeground(new Color(235, 235, 235));
        btnStartGame.setBackground(new Color(44, 150, 57));
        btnStartGame.setFont(new Font("Tahoma", Font.BOLD, 28));
        btnStartGame.setBounds(53, 330, 241, 55); // UBICACIÓN DEL BOTÓN
        contentPane.add(btnStartGame);

        // BOTÓN INSTRUCCIONES
        JButton btnInstrucciones = new JButton("INSTRUCCIONES");
        btnInstrucciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarInstrucciones();
            }
        });
        btnInstrucciones.setForeground(new Color(235, 235, 235));
        btnInstrucciones.setBackground(new Color(44, 150, 57));
        btnInstrucciones.setFont(new Font("Tahoma", Font.BOLD, 28));
        btnInstrucciones.setBounds(53, 400, 241, 55); // UBICACIÓN DEL BOTÓN
        contentPane.add(btnInstrucciones);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/com/example/junegull.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
            Font buttonFont = font.deriveFont(Font.BOLD, 28f);

            // Set the font for the buttons
            btnStartGame.setFont(buttonFont);
            btnInstrucciones.setFont(buttonFont);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarInstrucciones() {
        JOptionPane.showMessageDialog(this, "Instrucciones del juego:\n" +
                "Jugador 1: Usa las teclas W y S para mover la pala.\n" +
                "Jugador 2: Usa las teclas de flecha arriba y abajo para mover la pala.\n" +
                "El objetivo es evitar que la bola pase tu pala.", "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
    }

    private void iniciarJuego() {
        String jugador1 = jugador1Field.getText();
        String jugador2 = jugador2Field.getText();
        if (jugador1.isEmpty() || jugador2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese los nombres de ambos jugadores.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JFrame frame = new JFrame("Cercle Rebotant");
            poong2 panel = new poong2(jugador1, jugador2);
            frame.add(panel);
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);
            dispose(); // Cierra el menú inicial
        }
    }
}