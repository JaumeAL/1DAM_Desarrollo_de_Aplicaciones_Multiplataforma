package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PinballGame extends JPanel implements ActionListener, KeyListener {
    private int ballX = 50, ballY = 50, ballXDir = 2, ballYDir = 2;
    private int paddleX = 150;
    private int paddleWidth = 60, paddleHeight = 60;
    private Timer timer;
    private Image pelotaImagen;
    private Image pelotaBask;
    private Image pelotaFut;
    private Image pelotaFut2;

    

    public PinballGame() {
        pelotaImagen = new ImageIcon(getClass().getResource("tennis.png")).getImage();
        pelotaBask = new ImageIcon(getClass().getResource("basketball.png")).getImage();
        pelotaFut = new ImageIcon(getClass().getResource("football.png")).getImage();
        pelotaFut2 = new ImageIcon(getClass().getResource("football.png")).getImage();
        setPreferredSize(new Dimension(400, 300));
        setBackground(Color.white);
        addKeyListener(this);
        setFocusable(true);
        timer = new Timer(5, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        //g.fillOval(ballX, ballY, 20, 20); // Dibuja la bola
        //g.fillRect(paddleX, 350, paddleWidth, paddleHeight); // Dibuja la barra
        g.drawImage(pelotaImagen, ballX, ballY,paddleWidth,paddleHeight, this );
        g.drawImage(pelotaBask, ballX + 100, ballY-20,paddleWidth-30,paddleHeight-30, this );
        g.drawImage(pelotaFut, ballX - 100, ballY-20,paddleWidth+30,paddleHeight+30, this );
        g.drawImage(pelotaFut2, ballX - 50, ballY-20,paddleWidth +30,paddleHeight+30, this );

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ballX += ballXDir;
        ballY += ballYDir;

        // Rebote en los bordes
        if (ballX <= 0 || ballX >= 350) ballXDir = -ballXDir;
        if (ballY <= 0 || ballY >= 247) ballYDir = -ballYDir;
        

        // Rebote en la barra
        if (ballY >= 330 && ballX >= paddleX && ballX <= paddleX + paddleWidth) {
            ballYDir = -ballYDir;
        }


        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT && paddleX > 0) {
            paddleX -= 20;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddleX < 300) {
            paddleX += 20;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pinball Game");
        PinballGame game = new PinballGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
