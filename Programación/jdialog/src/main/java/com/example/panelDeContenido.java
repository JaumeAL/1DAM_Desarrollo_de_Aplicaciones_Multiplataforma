package com.example;

import javax.swing.*;
import java.awt.*;

public class panelDeContenido {
    public static void main(String[] args) {
        JFrame frame = new  JFrame("Ejemplo de panel");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Crear un Panel
        JPanel panel = new JPanel();
        panel.setSize(300,200);

        //Agregar un boto al panel
        //JButton boton = new JButton("Haz clic");
        //panel.add(boton);

        //Agregar el panel al frame
        //frame.add(panel);

        try {
            UIManager.setLookAndFeel("Javax.swing.plaf.metal.MetalFileChooserUI");
            } catch (Exception e) {
                e.printStackTrace();
            }

        frame.setVisible(true);

    }
}
