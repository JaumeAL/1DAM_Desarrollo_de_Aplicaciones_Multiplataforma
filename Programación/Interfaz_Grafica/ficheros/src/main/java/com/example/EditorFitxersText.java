/* {
    "name": "Jaume Albert",
    "surnames": "Salas Pastor",
    "age": "18"
    }
 */
package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EditorFitxersText extends JFrame {
    private JTextField txtNomFitxer;
    private JTextArea txtContingut;
    private JCheckBox chkAfegir;
    private JButton btnLlegir, btnEscriure;

    public EditorFitxersText() {
        // Establecer el LookAndFeel
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

        setTitle("Editor de fitxers de text");
        setSize(600, 500); // Tamaño más amplio
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // No se puede redimensionar
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("trala.png"))); // Icono de la ventana
        setLayout(new BorderLayout(10, 10));

        // Título estilizado
        JLabel titulo = new JLabel("Editor de Fitxers de Text", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setOpaque(true);
        titulo.setBackground(new Color(100, 149, 237)); // Azul claro
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titulo, BorderLayout.NORTH);

        // Panell superior amb el camp per al nom del fitxer
        JPanel panellNom = new JPanel(new BorderLayout(10, 10));
        panellNom.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panellNom.setBackground(new Color(240, 240, 240)); // Fondo gris claro
        JLabel etiquetaNomFitxer = new JLabel("Nom del fitxer:");
        etiquetaNomFitxer.setFont(new Font("Arial", Font.BOLD, 14));
        txtNomFitxer = new JTextField();
        panellNom.add(etiquetaNomFitxer, BorderLayout.WEST);
        panellNom.add(txtNomFitxer, BorderLayout.CENTER);
        

        add(panellNom, BorderLayout.NORTH);

        // Àrea central per al contingut del fitxer
        txtContingut = new JTextArea();
        txtContingut.setLineWrap(true);
        txtContingut.setWrapStyleWord(true);
        txtContingut.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(txtContingut);
        scrollPane.setBackground(new Color(255, 203, 65)); // Fondo blanco
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10),
            BorderFactory.createLineBorder(Color.GRAY)
        ));
        add(scrollPane, BorderLayout.CENTER);

        // Panell inferior amb els botons i checkbox
        JPanel panellBotons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panellBotons.setBackground(new Color(240, 240, 240));
        btnLlegir = new JButton("Llegir");
        btnEscriure = new JButton("Escriure");
        chkAfegir = new JCheckBox("Afegir");
        
        // Ajustar tamaño de los botones
        btnLlegir.setPreferredSize(new Dimension(140, 50)); // Botón más ancho y alto
        btnEscriure.setPreferredSize(new Dimension(140, 50)); // Botón más ancho y alto
        
        // Ajustar tamaño del checkbox
        chkAfegir.setFont(new Font("Arial", Font.BOLD, 18)); // Fuente más grande
        chkAfegir.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Margen interno
        
        // Estilo de los botones
        Font fontBotons = new Font("Arial", Font.BOLD, 16);
        btnLlegir.setFont(fontBotons);
        btnEscriure.setFont(fontBotons);
        btnLlegir.setBackground(new Color(41, 181, 255)); // Celestito
        btnEscriure.setBackground(new Color(41, 181, 255)); // Celestito
        
        // Añadir botones y checkbox al panel
        panellBotons.add(btnLlegir);
        panellBotons.add(btnEscriure);
        panellBotons.add(chkAfegir);
        add(panellBotons, BorderLayout.SOUTH);

        // Accions dels botons
        btnLlegir.addActionListener(e -> llegirFitxer());
        btnEscriure.addActionListener(e -> escriureFitxer());

        setVisible(true);
    }
    // LLEGIR
    private void llegirFitxer() { // Llegeix el fitxer i mostra el contingut
        String nomFitxer = txtNomFitxer.getText().trim(); // Obtenim el nom del fitxer
        File fitxer = new File(nomFitxer);// Cream un objecte File amb el nom del fitxer

        if (!fitxer.exists()) { // Si el fitxer no existeix
            // Mostram un missatge d'error
            JOptionPane.showMessageDialog(this, "El fitxer no existeix.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedReader lector = new BufferedReader(new FileReader(fitxer))) { // Cream un BufferedReader per llegir el fitxer
            txtContingut.setText(""); // Esborram el contingut anterior
            String linia; // Cream una variable per llegir línia a línia
            while ((linia = lector.readLine()) != null) { // Llegim línia a línia
                txtContingut.append(linia + "\n"); // Afegim la línia al JTextArea
            }
        } catch (IOException ex) { // Si hi ha un error al llegir el fitxer
            // Mostram un missatge d'error
            JOptionPane.showMessageDialog(this, "Error al llegir el fitxer:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // ESCRIURE
    private void escriureFitxer() { // Escriu el contingut del JTextArea al fitxer
        String nomFitxer = txtNomFitxer.getText().trim(); // Obtenim el nom del fitxer
        boolean afegir = chkAfegir.isSelected(); // Obtenim si volem afegir o sobreescriure
        String text = txtContingut.getText(); // Obtenim el contingut del JTextArea

        try (BufferedWriter escriptor = new BufferedWriter(new FileWriter(nomFitxer, afegir))) { // Cream un BufferedWriter per escriure al fitxer
            if (afegir) { // Si volem afegir
                escriptor.newLine(); //afegir un salt extra :)
            }
            escriptor.write(text); // Escriure el contingut al fitxer
            JOptionPane.showMessageDialog(this, "Text escrit correctament."); // Mostram un missatge d'èxit
            txtContingut.setText(""); // Esborram el contingut per no tenir que fer-ho manualment
        } catch (IOException ex) { // Si hi ha un error al escriure al fitxer
            // Mostram un missatge d'error
            JOptionPane.showMessageDialog(this, "Error al escriure al fitxer:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(EditorFitxersText::new);
    }
}