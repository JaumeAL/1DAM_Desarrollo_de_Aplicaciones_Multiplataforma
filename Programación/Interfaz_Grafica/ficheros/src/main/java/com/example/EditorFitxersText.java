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
        setTitle("Editor de fitxers de text");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panell superior amb el camp per al nom del fitxer
        JPanel panellNom = new JPanel(new BorderLayout(5, 5));
        panellNom.setBorder(BorderFactory.createEmptyBorder(10, 10, 80, 10));
        panellNom.add(new JLabel("Nom del fitxer:"), BorderLayout.WEST);
        panellNom.setPreferredSize(new Dimension(getWidth(), 30)); 
        txtNomFitxer = new JTextField();
        panellNom.add(txtNomFitxer, BorderLayout.CENTER);
        panellNom.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(panellNom, BorderLayout.NORTH);

        // Àrea central per al contingut del fitxer
        txtContingut = new JTextArea();
        txtContingut.setLineWrap(true);
        txtContingut.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtContingut);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        add(scrollPane, BorderLayout.CENTER);

        // Panell inferior amb els botons i checkbox
        JPanel panellBotons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnLlegir = new JButton("Llegir");
        btnEscriure = new JButton("Escriure");
        chkAfegir = new JCheckBox("Afegir");
        panellBotons.setBackground(new Color(255, 180, 68));

        //borde negro
        panellBotons.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panellBotons.add(btnLlegir);
        panellBotons.add(btnEscriure);
        panellBotons.add(chkAfegir);
        add(panellBotons, BorderLayout.SOUTH);

        // Accions dels botons
        btnLlegir.addActionListener(e -> llegirFitxer());
        btnEscriure.addActionListener(e -> escriureFitxer());

        setVisible(true);
    }

    private void llegirFitxer() {
        String nomFitxer = txtNomFitxer.getText().trim();
        File fitxer = new File(nomFitxer);

        if (!fitxer.exists()) {
            JOptionPane.showMessageDialog(this, "El fitxer no existeix.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedReader lector = new BufferedReader(new FileReader(fitxer))) {
            txtContingut.setText("");
            String linia;
            while ((linia = lector.readLine()) != null) {
                txtContingut.append(linia + "\n");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al llegir el fitxer:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void escriureFitxer() {
        String nomFitxer = txtNomFitxer.getText().trim();
        boolean afegir = chkAfegir.isSelected();
        String text = txtContingut.getText();

        try (BufferedWriter escriptor = new BufferedWriter(new FileWriter(nomFitxer, afegir))) {
            escriptor.write(text);
            if (afegir) escriptor.newLine(); // només si vols afegir un salt extra
            JOptionPane.showMessageDialog(this, "Text escrit correctament.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al escriure al fitxer:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EditorFitxersText::new);
    }
}