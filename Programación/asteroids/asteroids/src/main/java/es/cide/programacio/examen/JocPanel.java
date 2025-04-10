/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package es.cide.programacio.examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;

//EL CODIGO COMENTADO ES PORQUE NO FUNCIONA MUY FINO
/* class Estrella {
    int x, y; // Posició de l'estrella
    int radi = 10; // Radi de l'estrella
    private int velocitat; // Velocitat de l'estrella
    Image imatge; // Per ficar la imatge

    public Estrella(int amplePanell) {
        Random aleatori = new Random();
        x = aleatori.nextInt(amplePanell - radi * 2) + radi; // Posició x aleatòria
        y = 0; // Comença a la part superior del panell
        velocitat = 10; // Velocitat de 10
        imatge = new ImageIcon(getClass().getResource("/images/a.png")).getImage(); //Indicam on está la imatge

    }

    public void moure() {
        y += velocitat; // Mou l'asteroide cap avall
    }

    public void dibuixar(Graphics g) {
        g.fillOval(x - radi, y - radi, 2 * radi, 2 * radi); // Dibuixa l'asteroide com un cercle
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadi() {
        return radi;
    }
} */

class JocPanel extends JPanel {
    private NauEspacial nau; // Nau espacial del jugador
    private List<Asteroide> asteroides; // Llista d'asteroides
    //private List<Estrella> estrellas; // Llista d'asteroides
    private int puntuacio; // Puntuació del jugador
    private boolean jocActiu; // Indica si el joc està actiu

    public JocPanel() {
        nau = new NauEspacial(330, 530); // Posició inicial de la nau
        asteroides = new ArrayList<>(); // Inicialitza la llista d'asteroides
        puntuacio = 0; // Inicialitza la puntuació
        jocActiu = true; // El joc comença actiu

        // Configura el panell
        setBackground(Color.BLACK); // Fons negre
        setFocusable(true); // Permet que el panell rebi el focus
        requestFocusInWindow(); // Demana el focus per rebre les tecles

        // Afegeix un KeyListener per controlar la nau
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    nau.moureEsquerra(); // Mou la nau a l'esquerra
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    nau.moureDreta(); // Mou la nau a la dreta
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    nau.moureAdalt(); // Mou la nau a dalt
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    nau.moureAabaix(); // Mou la nau a dalt
                }
            }
        });

        // Crea un Timer per actualitzar el joc
        Timer temporitzador = new Timer(20, e -> {
            if (jocActiu) {
                actualitzarJoc(); // Actualitza l'estat del joc
                repaint(); // Redibuixa el panell
            }
        });
        temporitzador.start(); // Inicia el temporitzador
    }

    private void actualitzarJoc() {
        // Genera asteroides aleatoris
        if (Math.random() < 0.06) {
            asteroides.add(new Asteroide(getWidth())); // Afegeix un nou asteroide
        }

        // Mou els asteroides i comprova les col·lisions
        for (int i = asteroides.size() - 1; i >= 0; i--) {
            Asteroide asteroide = asteroides.get(i);
            asteroide.moure(); // Mou l'asteroide

            // Comprova si l'asteroide col·lisiona amb la nau
            if (collisio(nau, asteroide)) {
                jocActiu = false; // El joc acaba
            }

            // Comprova si l'asteroide ha sortit de la pantalla
            if (asteroide.getY() > getHeight()) {
                asteroides.remove(i); // Elimina l'asteroide
                puntuacio++; // Augmenta la puntuació
            }
        }
    }

    private boolean collisio(NauEspacial nau, Asteroide asteroide) {
        // Comprova si hi ha col·lisió entre la nau i l'asteroide
        int nauX = nau.getX();
        int nauY = nau.getY();
        int asteroideX = asteroide.getX();
        int asteroideY = asteroide.getY();
        int radiAsteroide = asteroide.getRadi();
        int ampleNau = nau.getAmple();
        int altNau = nau.getAlt();

        return nauX < asteroideX + radiAsteroide &&
                nauX + ampleNau > asteroideX - radiAsteroide &&
                nauY < asteroideY + radiAsteroide &&
                nauY + altNau > asteroideY - radiAsteroide;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dibuixa la nau espacial
        nau.dibuixar(g);

        // Dibuixa els asteroides
        for (Asteroide asteroide : asteroides) {
            // Indicam els valors necesaris per poder dibuixar l'asteroide
            g2d.drawImage(asteroide.imatge, asteroide.x, asteroide.y, asteroide.radi * 2, asteroide.radi * 2, this);
        }

        // Dibuixa la puntuació
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Puntuació: " + puntuacio, 10, 30);

        // Dibuixa el missatge de final de joc
        if (!jocActiu) {
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            String missatge = "Fi del joc";
            int ampleMissatge = g.getFontMetrics().stringWidth(missatge);
            g.drawString(missatge, getWidth() / 2 - ampleMissatge / 2, getHeight() / 2);
        }
    }

}