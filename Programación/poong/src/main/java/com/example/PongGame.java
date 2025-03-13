package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGame extends JPanel implements ActionListener {
    private int ballX = 290, ballY = 190, ballDX = 3, ballDY = 3, ballSize = 20; 
    private int paddle1Y = 150, paddle2Y = 150, paddleWidth = 10, paddleHeight = 80;
    private int score1 = 0, score2 = 0;
    private Timer timer;
    private boolean up1 = false, down1 = false, up2 = false, down2 = false;

    public PongGame() {
        setPreferredSize(new Dimension(600, 400));
        setBackground(Color.pink); //Color de fondo rosita

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> up1 = true;
                    case KeyEvent.VK_S -> down1 = true;
                    case KeyEvent.VK_UP -> up2 = true;
                    case KeyEvent.VK_DOWN -> down2 = true;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> up1 = false;
                    case KeyEvent.VK_S -> down1 = false;
                    case KeyEvent.VK_UP -> up2 = false;
                    case KeyEvent.VK_DOWN -> down2 = false;
                }
            }
        });
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.fillOval(ballX, ballY, ballSize, ballSize);
        g2d.fillRect(30, paddle1Y, paddleWidth, paddleHeight);
        g2d.fillRect(560, paddle2Y, paddleWidth, paddleHeight); 
        g2d.setFont(new Font("Arial", Font.BOLD, 20)); //Fuente y estilos 
        g2d.drawString("jugaror1: "+score1, 100, 30); //Marcador jugaror1
        g2d.drawString("jugaror2: "+score2, 400, 30); //Marcador jugaror2
        float[] dashPattern = { 20, 10 };  //Patron de la linea
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,  0, dashPattern, 0); // Estilo de la linea
        g2d.setStroke(dashed); //Linea punteada
        int midX = getWidth() / 2; //Mitad de la ventana
        g2d.drawLine(midX, 0, midX, getHeight()); //Linea central
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
        ballX += ballDX;
        ballY += ballDY;
        if (ballY <= 0 || ballY >= getHeight() - ballSize)
            ballDY = -ballDY;
        if (ballX <= 40 && ballY + ballSize >= paddle1Y && ballY <= paddle1Y + paddleHeight)
            ballDX = -ballDX;
        if (ballX >= 550 && ballY + ballSize >= paddle2Y && ballY <= paddle2Y + paddleHeight)
            ballDX = -ballDX;
            
        if (ballX < 0) {
            score2++;
            resetBall();
        }
        if (ballX > getWidth()) {
            score1++;
            resetBall();
        }
        if (up1 && paddle1Y > 0)
            paddle1Y -= 5;
        if (down1 && paddle1Y < getHeight() - paddleHeight)
            paddle1Y += 5;
        if (up2 && paddle2Y > 0)
            paddle2Y -= 5;
        if (down2 && paddle2Y < getHeight() - paddleHeight)
            paddle2Y += 5;
        repaint();
    }

    private void resetBall() {
        ballX = getWidth() / 2 - ballSize / 2;
        ballY = getHeight() / 2 - ballSize / 2;
        ballDX = -ballDX;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong Game"); //Crear la ventana
        PongGame game = new PongGame(); //Crear el juego
        frame.add(game); //Agregar el juego a la ventana
        frame.pack(); //Ajustar el tamaño de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar la ventana
        frame.setLocationRelativeTo(null); //Centrar la ventana

        frame.setVisible(true);
    }
}