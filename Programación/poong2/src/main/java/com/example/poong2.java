package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Classe que representa un panell on es dibuixa un cercle que rebota
public class poong2 extends JPanel implements ActionListener {
    private int bolaInicialX = 290, bolaInicialY = 190,radioBola = 20; // Coordenades inicials del cercle
    private int dx = 3, dy = 3; // Velocitat del moviment en X i Y
    private final int DELAY = 10; // Retard del temporitzador en mil·lisegons
    private Timer timer; // Temporitzador per controlar l'animació
    private int pala1Y = 150, pala2Y = 150, palaH = 10, palaW = 80;
    private boolean arriba1 = false, abajo1 = false;
    private boolean arriba2 = false, abajo2 = false;
    private int contador1 = 0, contador2 = 0;

    // Constructor que inicialitza el panell i inicia el temporitzador
    public poong2() {
        setBackground(Color.WHITE); // Defineix el color de bolla del panell
        setFocusable(true); // Para que el JPanel vea los eventos de teclado


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
        g2d.fillOval(bolaInicialX, bolaInicialY, radioBola, radioBola); // Dibuixa el cercle amb les coordenades i el radi
        g2d.fillRect(20, pala1Y, palaH, palaW);
        g2d.fillRect(560, pala2Y, palaH, palaW);
        g2d.setFont(new Font("Arial", Font.BOLD, 20)); //Fuente y estilos 
        g2d.drawString("jugador 1: "+contador1, 100, 30); //Marcador jugaror1
        g2d.drawString("jugador 2: "+contador2, 400, 30); //Marcador jugaror2
        



    }

    // Mètode que s'executa a cada tic del temporitzador per moure el cercle
    @Override
    public void actionPerformed(ActionEvent e) {
        bolaInicialX += dx;
        bolaInicialY += dy;

        //Rebote arriba y abajo de la pantalla
        if (bolaInicialY <= 0 || bolaInicialY >= getHeight() - radioBola)
            dy = -dy;
        //Rebote de las palas
        if (bolaInicialX <= 25 && bolaInicialY + radioBola >= pala1Y && bolaInicialY <= pala1Y + palaW)
            dx = Math.abs(dx);//asegura que la pelota rebota en la dirección correcta
        if (bolaInicialX >= 540 && bolaInicialY + radioBola >= pala2Y && bolaInicialY <= pala2Y + palaW)
            dx = -Math.abs(dx);
        //Contadores y posicionar la bola en el centro
        if (bolaInicialX < 0) {
            contador2++;
            reset();
        }
        if (bolaInicialX > getWidth()) {
            contador1++;
            reset();
        }
        //Movimiento de las palas
        if (arriba1 && pala1Y > 0)
            pala1Y -= 5;
        if (abajo1 && pala1Y < getHeight() - palaW)
            pala1Y += 5;
        if (arriba2 && pala2Y > 0)
            pala2Y -= 5;
        if (abajo2 && pala2Y < getHeight() - palaW)
            pala2Y += 5;
        repaint(); // Redibuixa el panell per actualitzar la posició del cercle
    }

    // Mètode per reiniciar la pilota
    public void reset() {
        bolaInicialX = 290;
        bolaInicialY = 190;
        dx = -dx;
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
