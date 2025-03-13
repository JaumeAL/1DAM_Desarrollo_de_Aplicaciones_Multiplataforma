package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Classe que representa un panell on es dibuixa un cercle que rebota
public class poong2 extends JPanel implements ActionListener {
    private int x = 290, y = 190; // Coordenades inicials del cercle
    private int dx = 2, dy = 2; // Velocitat del moviment en X i Y
    private final int RADI = 10; // Radi del cercle
    private final int DELAY = 10; // Retard del temporitzador en mil·lisegons
    private Timer timer; // Temporitzador per controlar l'animació
    private int pala1Y = 150, pala2Y = 150, palaW = 10, palaH = 80;
    private boolean arriba1 = false, abajo1 = false;
    private boolean arriba2 = false, abajo2 = false;
    private int contador1 = 0, contador2 = 0;

    // Constructor que inicialitza el panell i inicia el temporitzador
    public poong2() {
        setBackground(Color.WHITE); // Defineix el color de polla del panell

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> arriba1 = true;
                    case KeyEvent.VK_S -> abajo1 = true;
                    case KeyEvent.VK_UP -> arriba2 = true;
                    case KeyEvent.VK_DOWN -> abajo2 = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> arriba1 = false;
                    case KeyEvent.VK_S -> abajo1 = false;
                    case KeyEvent.VK_UP -> arriba2 = false;
                    case KeyEvent.VK_DOWN -> abajo2 = false;
                }
            }
        });
        timer = new Timer(DELAY, this); // Crea el temporitzador amb retard especificat
        timer.start(); // Inicia el temporitzador
    }

    // Mètode per dibuixar dins del panell
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; // Conversió a Graphics2D per millorar el dibuix
        g2d.setColor(Color.black); // Defineix el color del cercle
        g2d.fillOval(x, y, RADI * 2, RADI * 2); // Dibuixa el cercle amb les coordenades i el radi
        g2d.fillRect(10, pala1Y, palaW, palaH);
        g2d.fillRect(560, pala2Y, palaW, palaH);
        g2d.setFont(new Font("Arial", Font.BOLD, 20)); //Fuente y estilos 
        g2d.drawString("jugaror1: "+contador1, 100, 30); //Marcador jugaror1
        g2d.drawString("jugaror2: "+contador2, 400, 30); //Marcador jugaror2

    }

    // Mètode que s'executa a cada tic del temporitzador per moure el cercle
    @Override
    public void actionPerformed(ActionEvent e) {

        x += dx;
        y += dy;

        if (y <= 0 || y >= getHeight() - RADI * 2)
            dy = -dy;
        if (x <= 40 && y + RADI * 2 >= pala1Y && y <= pala1Y + palaH)
            dx = -dx;
        if (x >= 550 && y + RADI * 2 >= pala2Y && y <= pala2Y + palaH)
            dx = -dx;

        if (x < 0) {
            contador2++;
            reset();
        }
        if (x > getWidth()) {
            contador1++;
            reset();
        }

        if (arriba1 && pala1Y > 0)
            pala1Y -= 5;
        if (abajo1 && pala1Y < getHeight() - palaH)
            pala1Y += 5;
        if (arriba2 && pala2Y > 0)
            pala2Y -= 5;
        if (abajo2 && pala2Y < getHeight() - palaH)
            pala2Y += 5;
        repaint(); // Redibuixa el panell per actualitzar la posició del cercle
    }

    // Mètode per reiniciar la pilota
    public void reset() {
        x = 300; // Reinicia la posició X del cercle
        y = 200; // Reinicia la posició Y del cercle
        dx = 2; // Reinicia la velocitat en X
        dy = 2; // Reinicia la velocitat en Y
    }

    // Mètode principal per iniciar l'aplicació
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Cercle Rebotant"); // Crea la finestra
            poong2 panel = new poong2(); // Crea una instància del panell
            frame.add(panel); // Afegeix el panell a la finestra
            frame.setSize(600, 400); // Defineix la mida de la finestra
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura el tancament de la finestra
            frame.setLocationRelativeTo(null); // Centra la finestra a la pantalla
            frame.setVisible(true); // Mostra la finestra
        });
    }
}
