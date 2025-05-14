/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package com.example;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class EditorFitxersText extends JFrame { // Clase principal que extiende JFrame
    // Atributos
    private JTextField txtNomFitxer;
    private JTextArea txtContingut;
    private JCheckBox chkAfegir;
    private JButton btnLlegir, btnEscriure;

    // Establecer el LookAndFeel
    public EditorFitxersText() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Editor de fitxers de text"); // Titulo de la ventana
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("trala.png"))); // Icono de la ventana :)
        setSize(600, 500); // Tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cerrar la ventana
        setLocationRelativeTo(null); // Centrar la ventana
        setResizable(false); // No se puede redimensionar
        setLayout(new BorderLayout(10, 10)); // Layout de la ventana

        // Título estilizado
        JLabel titulo = new JLabel("Editor de Fitxers de Text", JLabel.CENTER); // Etiqueta centrada
        titulo.setFont(new Font("Arial", Font.BOLD, 20)); // Fuente en negrita
        titulo.setBackground(new Color(100, 149, 237)); // Azul claro
        add(titulo, BorderLayout.NORTH); // Añadir la etiqueta al norte

        // Panell superior amb el camp per al nom del fitxer
        JPanel panellNom = new JPanel(new BorderLayout(10, 10)); // Layout de panell
        panellNom.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen
        panellNom.setBackground(new Color(240, 240, 240)); // Fondo gris claro
        JLabel etiquetaNomFitxer = new JLabel("Nom del fitxer:"); // Etiqueta
        etiquetaNomFitxer.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente en negrita
        txtNomFitxer = new JTextField(); // Campo de texto
        panellNom.add(etiquetaNomFitxer, BorderLayout.WEST); // Añadir etiqueta al oeste
        panellNom.add(txtNomFitxer, BorderLayout.CENTER); // Añadir campo de texto al centro
        add(panellNom, BorderLayout.NORTH);

        // Àrea central per al contingut del fitxer
        txtContingut = new JTextArea(); // Área de texto
        txtContingut.setLineWrap(true); // Ajustar el texto al ancho del área
        txtContingut.setWrapStyleWord(true); // Ajustar el texto al ancho del área
        txtContingut.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Fuente monoespaciada
        txtContingut.setBorder(BorderFactory.createCompoundBorder( // Borde del área de texto
                BorderFactory.createEmptyBorder(10, 10, 10, 10), // Margen interno
                BorderFactory.createLineBorder(Color.GRAY))); // Colorzito
        add(txtContingut, BorderLayout.CENTER); // Añadir directamente el JTextArea

        // Panell inferior amb els botons i checkbox
        JPanel panellBotons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Layout de panell
        btnLlegir = new JButton("Llegir"); // Botón de leer
        btnEscriure = new JButton("Escriure"); // Botón de escribir
        chkAfegir = new JCheckBox("Afegir"); // Checkbox de añadir

        // Ajustar tamaño de los botones
        btnLlegir.setPreferredSize(new Dimension(140, 50)); // Botón más ancho y alto
        btnEscriure.setPreferredSize(new Dimension(140, 50)); // Botón más ancho y alto

        // Ajustar tamaño del checkbox
        chkAfegir.setFont(new Font("Arial", Font.BOLD, 18)); // Fuente más grande
        chkAfegir.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Margen interno

        // Estilo de los botones
        Font fontBotons = new Font("Arial", Font.BOLD, 16); // Fuente en negrita
        btnLlegir.setFont(fontBotons); // Fuente en negrita
        btnEscriure.setFont(fontBotons); // Fuente en negrita
        btnLlegir.setBackground(new Color(41, 181, 255)); // Celestito
        btnEscriure.setBackground(new Color(41, 181, 255)); // Celestito

        // Añadir botones y checkbox al panel
        panellBotons.add(btnLlegir);  // Botón de leer
        panellBotons.add(btnEscriure);  // Botón de escribir
        panellBotons.add(chkAfegir);    // Checkbox de añadir
        add(panellBotons, BorderLayout.SOUTH); // Añadir el panel al sur

        // Accions dels botons
        btnLlegir.addActionListener(e -> llegirFitxer()); // Acció del botó de llegir
        btnEscriure.addActionListener(e -> escriureFitxer()); // Acció del botó d'escriure
        setVisible(true); // Fer visible la finestra
    }

    // LLEGIR
    private void llegirFitxer() { // Llegeix el fitxer i mostra el contingut
        String nomFitxer = txtNomFitxer.getText().trim(); // Obtenim el nom del fitxer
        File fitxer = new File(nomFitxer); // Cream un objecte File amb el nom del fitxer

        if (!fitxer.exists()) { // Si el fitxer no existeix
            // Mostram un missatge d'error
            JOptionPane.showMessageDialog(this, "El fitxer no existeix.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (FileInputStream fileInput = new FileInputStream(fitxer)) { // Cream un FileInputStream per llegir el fitxer
            txtContingut.setText(""); // Esborram el contingut anterior
            int caracter;
            while ((caracter = fileInput.read()) != -1) { // Llegim byte a byte
                txtContingut.append(String.valueOf((char) caracter)); // Convertim el byte a char i l'afegim al JTextArea
            }
        } catch (IOException ex) { // Si hi ha un error al llegir el fitxer
            // Mostram un missatge d'error
            JOptionPane.showMessageDialog(this, "Error al llegir el fitxer:\n" + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ESCRIURE
    private void escriureFitxer() { // Escriu el contingut del JTextArea al fitxer
        String nomFitxer = txtNomFitxer.getText().trim(); // Obtenim el nom del fitxer
        boolean afegir = chkAfegir.isSelected(); // Obtenim si volem afegir o sobreescriure
        String text = txtContingut.getText(); // Obtenim el contingut del JTextArea

        try (FileOutputStream fileOutput = new FileOutputStream(nomFitxer, afegir)) { // Cream un FileOutputStream per escriure al fitxer
            if (afegir) { // Si volem afegir...
                fileOutput.write("\n".getBytes()); // Afegim el salt de línia
            }
            fileOutput.write(text.getBytes()); // Escriure el contingut al fitxer
            JOptionPane.showMessageDialog(this, "Text escrit correctament."); // Mostram un missatge d'èxit
            txtContingut.setText(""); // Esborram el contingut per no tenir que fer-ho manualment :)
        } catch (IOException ex) { // Si hi ha un error al escriure al fitxer
            // Mostram un missatge d'error
            JOptionPane.showMessageDialog(this, "Error al escriure al fitxer:\n" + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) { // Mètode principal
        SwingUtilities.invokeLater(EditorFitxersText::new); // Cream un nou objecte de la classe
    }
}
