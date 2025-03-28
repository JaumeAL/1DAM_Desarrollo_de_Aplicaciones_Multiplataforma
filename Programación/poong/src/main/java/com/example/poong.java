// {
//   "name": "Jaume",
//   "surname": "Salas",
//   "age": 18
// }
package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class poong extends JPanel implements ActionListener { //Declara la clase poong que extiende JPanel y implementa ActionListener
    private int bolaInicialX = 290, bolaInicialY = 190, radioBola = 20; //Posicion inicial de la bola
    private int dx = 3, dy = 3; //Velocidad de la bola
    private final int DELAY = 10; //Delay del temporizador
    private Timer timer; //Temporizador
    private int pala1Y = 150, pala2Y = 150, palaH = 10, palaW = 80; //Posicion inicial de las palas
    private boolean arriba1 = false, abajo1 = false; //Variables para saber si la pala1 esta subiendo o bajando
    private boolean arriba2 = false, abajo2 = false; //Variables para saber si la pala2 esta subiendo o bajando
    private int contador1 = 0, contador2 = 0; //Contadores de los jugadores
    private String jugador1, jugador2; //Nombres de los jugadores

    public poong(String jugador1, String jugador2) { //Constructor de la clase poong
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
                    case KeyEvent.VK_W -> arriba1 = false; //Si soltamos W pala1 dejara de subir
                    case KeyEvent.VK_S -> abajo1 = false; //Si soltamos S pala1 dejara de bajar
                    case KeyEvent.VK_UP -> arriba2 = false; //Si soltamos ↑ pala2 dejara de subir
                    case KeyEvent.VK_DOWN -> abajo2 = false; //Si soltamos ↓ pala2 dejara de bajar
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
    public void actionPerformed(ActionEvent e) { //Cada vez que se llama al temporizador
        bolaInicialX += dx; //Actualiza la posición de la bola
        bolaInicialY += dy; //Actualiza la posición de la bola

        if (bolaInicialY <= 0 || bolaInicialY >= getHeight() - radioBola) //Si la bola toca el borde superior o inferior de la pantalla
            dy = -dy; //Cambia la dirección de la bola para arriba o abajo
        if (bolaInicialX <= 25 && bolaInicialY + radioBola >= pala1Y && bolaInicialY <= pala1Y + palaW) //Si la bola toca la pala1
            dx = Math.abs(dx); //Cambia la dirección de la bola para la derecha 
        if (bolaInicialX >= 540 && bolaInicialY + radioBola >= pala2Y && bolaInicialY <= pala2Y + palaW) //Si la bola toca la pala2
            dx = -Math.abs(dx); //Cambia la dirección de la bola para la izquierda
        
        if (bolaInicialX < 0) { //Si la bola sale por la izquierda
            contador2++; //Aumenta el contador del jugador2
            reset(); //Reinicia la bola en el centro
        }
        if (bolaInicialX > getWidth()) { //Si la bola sale por la derecha
            contador1++; //Aumenta el contador del jugador1
            reset(); //Reinicia la bola
        }

        if (arriba1 && pala1Y > 0) //Si la pala1 no toca el borde de arriba
            pala1Y -= 5; //Sube la pala1
        if (abajo1 && pala1Y < getHeight() - palaW) //Si la pala1 no toca el borde de abajo
            pala1Y += 5; //Baja la pala1
        if (arriba2 && pala2Y > 0) //Si la pala2 no toca el borde de arriba
            pala2Y -= 5; //Sube la pala2
        if (abajo2 && pala2Y < getHeight() - palaW) //Si la pala2 no toca el borde de abajo
            pala2Y += 5; //Baja la pala2
        repaint(); //Vuelve a dibujar el panel
    }

    public void reset() { //Reinicia la bola en el centro
        bolaInicialX = getWidth() / 2 - radioBola / 2; //Reinicia la posición de la bola
        bolaInicialY = getHeight() / 2 - radioBola / 2; //Reinicia la posición de la bola
        dx = -dx; //Cambia la dirección de la bola
    }
}