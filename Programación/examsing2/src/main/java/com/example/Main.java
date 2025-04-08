package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

class Pelota {
    int x, y, dx, dy, radi;
    Image imatge;

    public Pelota(int x, int y, int radi, String rutaImatge) {
        this.x = x;
        this.y = y;
        this.radi = radi;
        this.dx = new Random().nextInt(5) + 2;
        this.dy = new Random().nextInt(5) + 2;
        this.imatge = new ImageIcon(rutaImatge).getImage();
    }

    public void moure(int ample, int alt) {
        x += dx;
        y += dy;

        if (x <= 0 || x + (radi * 2) >= ample) dx = -dx;
        if (y <= 0 || y + (radi * 2) >= alt) dy = -dy;
    }

    public boolean colisionaAmb(Pelota altra) {
        int distancia = (int) Math.sqrt(Math.pow(this.x - altra.x, 2) + Math.pow(this.y - altra.y, 2));
        return distancia < this.radi + altra.radi;
    }
}

class PanellPilotes extends JPanel implements ActionListener {
    private final ArrayList<Pelota> pilotes = new ArrayList<>();
    private final Timer timer;
    private final JComboBox<String> comboBox;
    private final JLabel lblFPS;
    private final JLabel lblCount;
    private boolean enMarxa = true;
    private long lastTime = System.nanoTime();

    public PanellPilotes(JComboBox<String> comboBox, JLabel lblFPS, JLabel lblCount) {
        this.comboBox = comboBox;
        this.lblFPS = lblFPS;
        this.lblCount = lblCount;
        setBackground(Color.BLACK);
        timer = new Timer(16, this);
        timer.start();
    }

    public void afegirPilota() {
        if (pilotes.size() >= 15) return;

        String tipus = (String) comboBox.getSelectedItem();
        int radi;
        String rutaImatge;

        switch (tipus) {
            case "Futbol":
                radi = 20;
                rutaImatge = "football.png";
                break;
            case "Bàsquet":
                radi = 30;
                rutaImatge = "basketball.png";
                break;
            default:
                radi = 15;
                rutaImatge = "tennis.png";
                break;
        }

        Random rand = new Random();
        int x = rand.nextInt(Math.max(1, getWidth() - 2 * radi));
        int y = rand.nextInt(Math.max(1, getHeight() - 2 * radi));
        pilotes.add(new Pelota(x, y, radi, rutaImatge));
        actualitzarLabel();
    }

    public void reiniciar() {
        pilotes.clear();
        actualitzarLabel();
    }

    public void toggleMarxa() {
        enMarxa = !enMarxa;
    }

    private void actualitzarLabel() {
        lblCount.setText("Pilotes: " + pilotes.size());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Pelota p : pilotes) {
            g.drawImage(p.imatge, p.x, p.y, p.radi * 2, p.radi * 2, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!enMarxa) return;

        for (int i = 0; i < pilotes.size(); i++) {
            Pelota p = pilotes.get(i);
            p.moure(getWidth(), getHeight());

            for (int j = i + 1; j < pilotes.size(); j++) {
                Pelota altra = pilotes.get(j);
                if (p.colisionaAmb(altra)) {
                    int tempDx = p.dx;
                    p.dx = altra.dx;
                    altra.dx = tempDx;

                    int tempDy = p.dy;
                    p.dy = altra.dy;
                    altra.dy = tempDy;
                }
            }
        }

        long now = System.nanoTime();
        double fps = 1_000_000_000.0 / (now - lastTime);
        lastTime = now;
        lblFPS.setText(String.format("FPS: %.1f", fps));
        repaint();
    }
}

public class ExamenPilotesPro {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Examen Pro de Pilotes");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);

            String[] tipusPilotes = {"Tennis", "Futbol", "Bàsquet"};
            JComboBox<String> comboBox = new JComboBox<>(tipusPilotes);

            JLabel lblFPS = new JLabel("FPS: ");
            lblFPS.setForeground(Color.GREEN);
            JLabel lblCount = new JLabel("Pilotes: 0");
            lblCount.setForeground(Color.ORANGE);

            PanellPilotes panell = new PanellPilotes(comboBox, lblFPS, lblCount);

            JButton btnAfegir = new JButton("Afegir");
            JButton btnReiniciar = new JButton("Reiniciar");
            JButton btnPausa = new JButton("Pausa / Continuar");

            btnAfegir.addActionListener(e -> panell.afegirPilota());
            btnReiniciar.addActionListener(e -> panell.reiniciar());
            btnPausa.addActionListener(e -> panell.toggleMarxa());

            JPanel panellControls = new JPanel();
            panellControls.add(new JLabel("Tipus:"));
            panellControls.add(comboBox);
            panellControls.add(btnAfegir);
            panellControls.add(btnReiniciar);
            panellControls.add(btnPausa);
            panellControls.add(lblCount);
            panellControls.add(lblFPS);

            frame.setLayout(new BorderLayout());
            frame.add(panellControls, BorderLayout.NORTH);
            frame.add(panell, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}
