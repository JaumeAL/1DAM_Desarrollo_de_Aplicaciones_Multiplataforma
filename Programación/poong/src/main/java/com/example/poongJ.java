package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class poongJ extends JPanel implements ActionListener {
    private int bolaInicialX = 290, bolaInicialY = 190, radioBola = 20;
    private int dx = 2, dy = 2;
    private final int DELAY = 10;
    private Timer timer;
    private int pala1Y = 150, pala2Y = 150, palaH = 10, palaW = 80;
    private boolean arriba1 = false, abajo1 = false;
    private boolean arriba2 = false, abajo2 = false;
    private int contador1 = 0, contador2 = 0;
    private String jugador1, jugador2;

    public poongJ(String jugador1, String jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        setBackground(Color.WHITE);
        setFocusable(true);

        addKeyListener(new KeyAdapter() { //Sirve para detectar las teclas presionadas
            @Override
            public void keyPressed(KeyEvent e) { //Detecta si una tecla está siendo presionada
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> arriba1 = true; //Si presionamos W, pala1 subira
                    case KeyEvent.VK_S -> abajo1 = true; //Si presionamos S, pala1 bajara
                    case KeyEvent.VK_UP -> arriba2 = true; //Si presionamos ↑, pala2 subira
                    case KeyEvent.VK_DOWN -> abajo2 = true; //Si presionamos ↓, pala2 bajara
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {  //Detecta si una tecla ya no se pulsa porque sino se quedaria subiendo o bajando
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> arriba1 = false; 
                    case KeyEvent.VK_S -> abajo1 = false;
                    case KeyEvent.VK_UP -> arriba2 = false;
                    case KeyEvent.VK_DOWN -> abajo2 = false;
                }
            }
        });
        //Java.Swing.Timer
        timer = new Timer(DELAY, this); //Crea un temporizador que llama a actionPerformed cada 10ms
        timer.start(); //Inicia el temporizador
    }

    @Override
    protected void paintComponent(Graphics g) { //Para dibujar los compoentes en el panel
        super.paintComponent(g); //Llama al método paintComponent
        Graphics2D g2d = (Graphics2D) g; //Pasamos Graphics a Graphics2D
        g2d.setColor(Color.black); //Color de la bola y las plas
        g2d.fillOval(bolaInicialX, bolaInicialY, radioBola, radioBola); //Dibuja la bola con las coordenadas y el radio
        g2d.fillRect(20, pala1Y, palaH, palaW); //Pala1
        g2d.fillRect(560, pala2Y, palaH, palaW); //Pala2
        g2d.setFont(new Font("Arial", Font.PLAIN, 20)); //Fuente y tamaño de la letra
        g2d.drawString(jugador1 + ": " + contador1, 100, 30); //Nombre del jugador1 y su puntuación
        g2d.drawString(jugador2 + ": " + contador2, 400, 30); //Nombre del jugador2 y su puntuación
        float[] dashPattern = {10, 10}; //Patrón de la línea
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, dashPattern, 0); //Estilo de la línea
        g2d.setStroke(dashed); //Establece el estilo 
        int midX = getWidth() / 2; //Mitad de la pantalla
        g2d.drawLine(midX, 0, midX, getHeight()); //Dibuja la línea en la mitad de la pantalla
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bolaInicialX += dx;
        bolaInicialY += dy;

        if (bolaInicialY <= 0 || bolaInicialY >= getHeight() - radioBola)
            dy = -dy;
        if (bolaInicialX <= 25 && bolaInicialY + radioBola >= pala1Y && bolaInicialY <= pala1Y + palaW)
            dx = Math.abs(dx);
        if (bolaInicialX >= 540 && bolaInicialY + radioBola >= pala2Y && bolaInicialY <= pala2Y + palaW)
            dx = -Math.abs(dx);

        if (bolaInicialX < 0) {
            contador2++;
            reset();
        }
        if (bolaInicialX > getWidth()) {
            contador1++;
            reset();
        }
        if (arriba1 && pala1Y > 0)
            pala1Y -= 5;
        if (abajo1 && pala1Y < getHeight() - palaW)
            pala1Y += 5;
        if (arriba2 && pala2Y > 0)
            pala2Y -= 5;
        if (abajo2 && pala2Y < getHeight() - palaW)
            pala2Y += 5;
        repaint();
    }

    public void reset() {
        bolaInicialX = 290;
        bolaInicialY = 190;
        dx = -dx;
    }
}