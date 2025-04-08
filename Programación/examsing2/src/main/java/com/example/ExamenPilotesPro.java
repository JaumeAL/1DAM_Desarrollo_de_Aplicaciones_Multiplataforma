package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.net.URL;

class Pelota {
    int x, y, dx, dy, radi;
    Image imatge;

    public Pelota(int x, int y, int radi, String rutaImatge) {
        this.x = x;
        this.y = y;
        this.radi = radi;
        this.dx = 0;
        this.dy = 0;

        URL imatgeURL = getClass().getResource(rutaImatge); 
        if (imatgeURL != null) {
            this.imatge = new ImageIcon(imatgeURL).getImage();
        } else {
            JOptionPane.showMessageDialog(null, "No s'ha trobat la imatge: " + rutaImatge);
        }
    }

    public void moure(int ample, int alt) { // Moure la pilota
        // Actualitzar la posició de la pilota
        x += dx;
        y += dy;

        if (x <= 0 || x + (radi * 2) >= ample) //Si toca els costats
            dx = -dx;
        if (y <= 0 || y + (radi * 2) >= alt) //Si toca el sostre o el terra
            dy = -dy;
    }
}

class Triangle { // Classe Triangle
    int x, y, dx, dy, size;
    double angle;
    double rotationSpeed;

    public Triangle(int x, int y, int size, double rotationSpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.dx = 0;
        this.dy = 0;
        this.angle = 0;
        this.rotationSpeed = rotationSpeed;
    }

    public void moure(int ample, int alt) {
        x += dx;
        y += dy;

        if (x <= 0 || x + size >= ample)
            dx = -dx;
        if (y <= 0 || y + size >= alt)
            dy = -dy;

        angle += rotationSpeed;
        if (angle >= 360)
            angle -= 360;
    }

    public void dibuixar(Graphics2D g2d) {
        int halfSize = size / 2;

        int[] xPoints = {
                x + (int) (halfSize * Math.cos(Math.toRadians(angle))),
                x + (int) (halfSize * Math.cos(Math.toRadians(angle + 120))),
                x + (int) (halfSize * Math.cos(Math.toRadians(angle + 240)))
        };
        int[] yPoints = {
                y + (int) (halfSize * Math.sin(Math.toRadians(angle))),
                y + (int) (halfSize * Math.sin(Math.toRadians(angle + 120))),
                y + (int) (halfSize * Math.sin(Math.toRadians(angle + 240)))
        };

        g2d.setColor(Color.RED);
        g2d.fillPolygon(xPoints, yPoints, 3);
    }
}

class Obstaculo { // Classe Obstaculo
    int x, y, width, height, dx; // Posició i dimensions del rectangle

    public Obstaculo(int x, int y, int width, int height) { 
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dx = 5; // Velocidad inicial del obstáculo
    }

    public void moure(int ample) { // Moure l'obstacle
        x += dx;

        // Rebotar en los bordes del panel
        if (x <= 0 || x + width >= ample) { 
            dx = -dx;
        }
    }

    public void dibuixar(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x, y, width, height);
    }

    public boolean colisionaCon(int figuraX, int figuraY, int figuraWidth, int figuraHeight) { //si el rectangle colisiona amb la figura
        // Comprovar si la figura colisiona amb l'obstacle
        return figuraX < x + width && figuraX + figuraWidth > x && 
               figuraY < y + height && figuraY + figuraHeight > y; 
    }
}
class PanellPilotes extends JPanel implements ActionListener { // Classe PanellPilotes serveix per dibuixar les pilotes i triangles
    private final ArrayList<Pelota> pilotes = new ArrayList<>(); // ArrayList de pilotes
    private final ArrayList<Triangle> triangles = new ArrayList<>();
    private final Timer timer;
    private final JComboBox<String> comboBox;
    private final JLabel lblFPS;
    private final JLabel lblCount;
    private final int velMin;
    private final int velMax;
    private final Obstaculo obstaculo;
    private boolean enMarxa = true;
    private long lastTime = System.nanoTime();

    private final int maxFigures;

    public PanellPilotes(JComboBox<String> comboBox, JLabel lblFPS, JLabel lblCount, int maxFigures, int velMin,
            int velMax) {
        this.comboBox = comboBox;
        this.lblFPS = lblFPS;
        this.lblCount = lblCount;
        this.maxFigures = maxFigures;
        this.velMin = velMin;
        this.velMax = velMax;
        timer = new Timer(16, this);
        timer.start();
        setDoubleBuffered(true);
        setBackground(Color.gray);

        // Inicializamos el obstáculo en el centro del panel
        obstaculo = new Obstaculo(300, 200, 100, 50);
    }

    public void afegirPilota() {
        if (pilotes.size() + triangles.size() >= maxFigures) {
            JOptionPane.showMessageDialog(this, "Has alcanzado el número máximo de figuras.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        String tipus = (String) comboBox.getSelectedItem();
        int radi;
        String rutaImatge;

        switch (tipus) {
            case "Futbol":
                radi = 20;
                rutaImatge = "/images/football.png";
                break;
            case "Bàsquet":
                radi = 30;
                rutaImatge = "/images/basketball.png";
                break;
            default:
                radi = 10;
                rutaImatge = "/images/tennis.png";
                break;
        }

        Random rand = new Random();
        int x = rand.nextInt(Math.max(1, getWidth() - 2 * radi));
        int y = rand.nextInt(Math.max(1, getHeight() - 2 * radi));
        int dx = rand.nextInt(velMax - velMin + 1) + velMin;
        int dy = rand.nextInt(velMax - velMin + 1) + velMin;

        Pelota p = new Pelota(x, y, radi, rutaImatge);
        p.dx = dx;
        p.dy = dy;
        pilotes.add(p);
        actualitzarLabel();
        repaint();
    }

    public void afegirTriangle() {
        if (pilotes.size() + triangles.size() >= maxFigures) {
            JOptionPane.showMessageDialog(this, "Has alcanzado el número máximo de figuras.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Random rand = new Random();
        int size = rand.nextInt(30) + 20;
        int x = rand.nextInt(Math.max(1, getWidth() - size));
        int y = rand.nextInt(Math.max(1, getHeight() - size));
        int dx = rand.nextInt(velMax - velMin + 1) + velMin;
        int dy = rand.nextInt(velMax - velMin + 1) + velMin;
        double rotationSpeed = rand.nextDouble() * 5 + 1;

        Triangle t = new Triangle(x, y, size, rotationSpeed);
        t.dx = dx;
        t.dy = dy;
        triangles.add(t);
        actualitzarLabel();
        repaint();
    }

    public void reiniciar() {
        pilotes.clear();
        triangles.clear();
        actualitzarLabel();
    }

    public void borrarUltimaPilota() {
        if (!pilotes.isEmpty()) {
            pilotes.remove(pilotes.size() - 1);
            actualitzarLabel();
            repaint();
        } else {
            JOptionPane.showMessageDialog(this, "No hi ha pilotes per eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void toggleMarxa() {
        enMarxa = !enMarxa;
    }

    private void actualitzarLabel() {
        lblCount.setText("Figures: " + (pilotes.size() + triangles.size()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (Pelota p : pilotes) {
            g2d.drawImage(p.imatge, p.x, p.y, p.radi * 2, p.radi * 2, this);
        }

        for (Triangle t : triangles) {
            t.dibuixar(g2d);
        }
        // Dibujar el obstáculo
        obstaculo.dibuixar(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!enMarxa)
            return;
    
        for (Pelota p : pilotes) {
            p.moure(getWidth(), getHeight());
    
            // Detectar colisión con el obstáculo
            if (obstaculo.colisionaCon(p.x, p.y, p.radi * 2, p.radi * 2)) {
                p.dx = -p.dx;
                p.dy = -p.dy;
            }
        }
    
        for (Triangle t : triangles) {
            t.moure(getWidth(), getHeight());
    
            // Detectar colisión con el obstáculo
            if (obstaculo.colisionaCon(t.x, t.y, t.size, t.size)) {
                t.dx = -t.dx;
                t.dy = -t.dy;
            }
        }
    
        // Mover el obstáculo
        obstaculo.moure(getWidth());
    
        long now = System.nanoTime();
        double fps = 1_000_000_000.0 / (now - lastTime);
        lastTime = now;
        lblFPS.setText(String.format("FPS: %.1f", fps));
        repaint();
    }
}
class MenuInicial extends JFrame {
    public MenuInicial() {
        setTitle("Configuració del Joc");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 10, 10));

        JLabel lblMaxFigures = new JLabel("Nombre màxim de figures:");
        JSpinner spnMax = new JSpinner(new SpinnerNumberModel(10, 1, 100, 1));

        JLabel lblColor = new JLabel("Color de fons:");
        String[] colors = { "Gris", "Blanc", "Negre", "Blau" };
        JComboBox<String> colorBox = new JComboBox<>(colors);

        JLabel lblVelMin = new JLabel("Velocitat mínima:");
        JSpinner spnVelMin = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

        JLabel lblVelMax = new JLabel("Velocitat màxima:");
        JSpinner spnVelMax = new JSpinner(new SpinnerNumberModel(5, 1, 10, 1));

        JCheckBox chkInicial = new JCheckBox("Afegir 1 pilota al començar");

        JButton btnIniciar = new JButton("Iniciar Joc");

        add(lblMaxFigures);
        add(spnMax);
        add(lblColor);
        add(colorBox);
        add(lblVelMin);
        add(spnVelMin);
        add(lblVelMax);
        add(spnVelMax);
        add(new JLabel());
        add(chkInicial);
        add(new JLabel());
        add(btnIniciar);

        btnIniciar.addActionListener(e -> {
            int maxFigures = (int) spnMax.getValue();
            String color = (String) colorBox.getSelectedItem();
            int velMin = (int) spnVelMin.getValue();
            int velMax = (int) spnVelMax.getValue();
            boolean afegirUna = chkInicial.isSelected();

            SwingUtilities.invokeLater(() -> {
                new JocConfigurat(maxFigures, velMin, velMax, color, afegirUna);
            });

            dispose();
        });

        setVisible(true);
    }
}

class JocConfigurat extends JFrame {
    public JocConfigurat(int maxFigures, int velMin, int velMax, String colorFons, boolean afegirUna) {
        setTitle("Joc Configurat de Figures");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblFPS = new JLabel("FPS: ");
        JLabel lblCount = new JLabel("Figures: 0");
        JComboBox<String> tipusBox = new JComboBox<>(new String[] { "Futbol", "Bàsquet", "Tennis" });

        PanellPilotes panell = new PanellPilotes(tipusBox, lblFPS, lblCount, maxFigures, velMin, velMax);
        canviarColorFons(panell, colorFons);

        JButton btnAfegirPilota = new JButton("Afegir Pilota");
        JButton btnAfegirTriangle = new JButton("Afegir Triangle");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnReiniciar = new JButton("Reiniciar");
        JButton btnStartStop = new JButton("Start/Stop");

        JPanel controls = new JPanel();
        controls.add(lblFPS);
        controls.add(lblCount);
        controls.add(tipusBox);
        controls.add(btnAfegirPilota);
        controls.add(btnAfegirTriangle);
        controls.add(btnBorrar);
        controls.add(btnReiniciar);
        controls.add(btnStartStop);

        btnAfegirPilota.addActionListener(e -> panell.afegirPilota());
        btnAfegirTriangle.addActionListener(e -> panell.afegirTriangle());
        btnBorrar.addActionListener(e -> panell.borrarUltimaPilota());
        btnReiniciar.addActionListener(e -> panell.reiniciar());
        btnStartStop.addActionListener(e -> panell.toggleMarxa());

        add(panell, BorderLayout.CENTER);
        add(controls, BorderLayout.SOUTH);

        setVisible(true);

        if (afegirUna) {
            panell.afegirPilota();
        }
    }

    private void canviarColorFons(JPanel panell, String colorFons) {
        switch (colorFons) {
            case "Blanc":
                panell.setBackground(Color.WHITE);
                break;
            case "Negre":
                panell.setBackground(Color.BLACK);
                break;
            case "Blau":
                panell.setBackground(Color.BLUE);
                break;
            default:
                panell.setBackground(Color.GRAY);
                break;
        }
    }
}

public class ExamenPilotesPro {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuInicial::new);
    }
}
