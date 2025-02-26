package com.example;


import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        JFrame finestra = new JFrame("Dibuix amb Java Swing");
        JPanel panel = new JPanel() {
            private Image imatge = new ImageIcon("imatge.png").getImage();


            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;


                // Dibuixar una línia
                g2d.drawLine(50, 50, 200, 50);


                // Dibuixar un rectangle
                g2d.drawRect(50, 70, 100, 50);


                // Dibuixar un rectangle ple
                g2d.setColor(Color.BLUE);
                g2d.fillRect(200, 70, 100, 50);


                // Dibuixar un cercle (oval)
                g2d.setColor(Color.RED);
                g2d.drawOval(50, 150, 50, 50);


                // Dibuixar un cercle ple
                g2d.fillOval(150, 150, 50, 50);


                // Dibuixar un arc
                g2d.setColor(Color.GREEN);
                g2d.drawArc(250, 150, 50, 50, 0, 180);


                // Dibuixar un polígon (triangle)
                int[] xPoints = {100, 125, 150};
                int[] yPoints = {250, 200, 250};
                g2d.setColor(Color.ORANGE);
                g2d.drawPolygon(xPoints, yPoints, 3);


                // Dibuixar text
                g2d.setColor(Color.BLACK);
                g2d.drawString("Hola, Java Swing!", 50, 300);


                // Dibuixar una imatge (ha d'existir imatge.png a la carpeta del projecte)
                g2d.drawImage(imatge, 200, 250, this);
            }
        };


        finestra.add(panel);
        finestra.setSize(400, 400);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setVisible(true);
    }
}
