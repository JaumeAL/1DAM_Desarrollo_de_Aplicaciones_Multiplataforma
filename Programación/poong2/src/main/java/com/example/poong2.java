package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class poong2 extends JPanel implements ActionListener {
    private int bolaInicialX = 290, bolaInicialY = 190, radioBola = 20;
    private int dx = 3, dy = 3;
    private final int DELAY = 10;
    private Timer timer;
    private int pala1Y = 150, pala2Y = 150, palaH = 10, palaW = 80;
    private boolean arriba1 = false, abajo1 = false;
    private boolean arriba2 = false, abajo2 = false;
    private int contador1 = 0, contador2 = 0;
    private String jugador1, jugador2;

    public poong2(String jugador1, String jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        setBackground(Color.WHITE);
        setFocusable(true);

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
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.fillOval(bolaInicialX, bolaInicialY, radioBola, radioBola);
        g2d.fillRect(20, pala1Y, palaH, palaW);
        g2d.fillRect(560, pala2Y, palaH, palaW);
        g2d.setFont(new Font("Arial", Font.PLAIN, 20));
        g2d.drawString(jugador1 + ": " + contador1, 100, 30);
        g2d.drawString(jugador2 + ": " + contador2, 400, 30);
        float[] dashPattern = {10, 10};
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, dashPattern, 0);
        g2d.setStroke(dashed);
        int midX = getWidth() / 2;
        g2d.drawLine(midX, 0, midX, getHeight());
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