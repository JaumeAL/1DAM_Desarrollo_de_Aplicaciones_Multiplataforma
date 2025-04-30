package es.cide.programacio.examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

// Classe que representa una pilota
class Pelota {
    int x, y; // Coordenades de la pilota
    int dx, dy; // Direcció del moviment
    int radi; // Radi de la pilota
    Image imatge; // Imatge de la pilota

    // Constructor que inicialitza la pilota amb posició, radi i imatge
    public Pelota(int x, int y, int radi, String rutaImatge) {
        this.x = x;
        this.y = y;
        this.radi = radi;
        this.dx = new Random().nextInt(3) + 1; // Velocitat aleatòria en l'eix X
        this.dy = new Random().nextInt(3) + 1; // Velocitat aleatòria en l'eix Y
        this.imatge = new ImageIcon(getClass().getResource(rutaImatge)).getImage();
    }

    // Mètode per moure la pilota dins dels límits del panell
    public void moure(int ample, int alt) {
        x += dx;
        y += dy;

        // Canvia la direcció si la pilota toca les vores del panell
        if (x <= 0 || x + (radi * 2) >= ample) {
            dx = -dx;
        }
        if (y <= 0 || y + (radi * 2) >= alt) {
            dy = -dy;
        }
    }

    // Mètode per comprovar si dues pilotes col·lisionen
    public boolean colisionaAmb(Pelota altra) {
        int distancia = (int) Math.sqrt(Math.pow(this.x - altra.x, 2) + Math.pow(this.y - altra.y, 2));
        return distancia < this.radi + altra.radi;
    }
}

// Panell principal on es dibuixen les pilotes
class PanellPilotes extends JPanel implements ActionListener {
    private final ArrayList<Pelota> pilotes = new ArrayList<>(); // Llista de pilotes
    private final Timer timer; // Temporitzador per actualitzar el moviment
    private final JComboBox<String> comboBox; // ComboBox per seleccionar el tipus de pilota

    // Constructor que inicialitza el panell i el temporitzador
    public PanellPilotes(JComboBox<String> comboBox) {
        this.comboBox = comboBox;
        setBackground(Color.WHITE); // Fons blanc per al panell
        timer = new Timer(10, this); // Temporitzador que s'executa cada 10 ms
        timer.start(); // Inicia el temporitzador
    }

    // Mètode per afegir una nova pilota al panell
    public void afegirPilota() {
        if (pilotes.size() >= 10) return; // Limita el nombre de pilotes a 10

        String tipus = (String) comboBox.getSelectedItem(); // Obté el tipus seleccionat
        int radi;
        String rutaImatge;

        // Assigna el radi i la imatge segons el tipus de pilota
        switch (tipus) {
            case "Futbol":
                radi = 20;
                rutaImatge = "/football.png";
                break;
            case "Bàsquet":
                radi = 30;
                rutaImatge = "/basketball.png";
                break;
            default:
                radi = 10;
                rutaImatge = "/tennis.png";
                break;
        }

        // Genera una posició aleatòria dins del panell
        Random rand = new Random();
        int x = rand.nextInt(getWidth() - 2 * radi);
        int y = rand.nextInt(getHeight() - 2 * radi);

        // Afegeix la nova pilota a la llista
        pilotes.add(new Pelota(x, y, radi, rutaImatge));
    }

    // Mètode per dibuixar les pilotes al panell
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Pelota p : pilotes) {
            g.drawImage(p.imatge, p.x, p.y, p.radi * 2, p.radi * 2, this);
        }
    }

    // Mètode que s'executa cada vegada que el temporitzador fa "tick"
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < pilotes.size(); i++) {
            Pelota p = pilotes.get(i);
            p.moure(getWidth(), getHeight()); // Mou la pilota

            // Comprova col·lisions entre pilotes
            for (int j = i + 1; j < pilotes.size(); j++) {
                Pelota altra = pilotes.get(j);
                if (p.colisionaAmb(altra)) {
                    // Inverteix només un dels eixos de les pilotes en cas de col·lisió
                    if (Math.abs(p.dx) > Math.abs(p.dy)) {
                        p.dx = -p.dx;
                        altra.dx = -altra.dx;
                    } else {
                        p.dy = -p.dy;
                        altra.dy = -altra.dy;
                    }
                }
            }
        }
        repaint(); // Redibuixa el panell
    }
}

// Classe principal amb la interfície d'usuari
public class ExamenPilotes {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hostia Pilotes! que son de bones! M'encanten!"); // Finestra principal
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Tanca l'aplicació en sortir
            frame.setSize(600, 400); // Mida de la finestra
            frame.setLocationRelativeTo(null); // Centra la finestra a la pantalla

            // ComboBox per seleccionar el tipus de pilota
            String[] tipusPilotes = {"Tennis", "Futbol", "Bàsquet"};
            JComboBox<String> comboBox = new JComboBox<>(tipusPilotes);

            // Panell de dibuix
            PanellPilotes panell = new PanellPilotes(comboBox);

            // Botó per afegir pilotes
            JButton btnAfegir = new JButton("Afegir Pilota");
            btnAfegir.addActionListener(e -> panell.afegirPilota()); // Acció per afegir una pilota

            // Panell superior amb controls
            JPanel panellControls = new JPanel();
            panellControls.add(new JLabel("Selecciona tipus:")); // Etiqueta descriptiva
            panellControls.add(comboBox); // Afegeix el ComboBox
            panellControls.add(btnAfegir); // Afegeix el botó

            // Afegir components a la finestra
            frame.setLayout(new BorderLayout());
            frame.add(panell, BorderLayout.CENTER); // Panell de dibuix al centre
            frame.add(panellControls, BorderLayout.NORTH); // Controls a la part superior

            frame.setVisible(true); // Fa visible la finestra
        });
    }
}