package com.example;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ayuda extends JFrame {
    
	private JPanel contentPane;

	public ayuda() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 447);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 150, 57));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInstructions = new JLabel("INSTRUCCIONS");
		lblInstructions.setForeground(Color.black);
		lblInstructions.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblInstructions.setBounds(157, 20, 200, 46);
		contentPane.add(lblInstructions);

		JLabel jugador1 = new JLabel("UGADOR 1");
		jugador1.setFont(new Font("Tahoma", Font.BOLD, 19));
		jugador1.setBounds(20, 75, 304, 29);
		jugador1.setForeground(new Color(49, 47, 47));
		contentPane.add(jugador1);

		JLabel lblVkupIncrease = new JLabel("Tecla (W) :  Amunt");
		lblVkupIncrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblVkupIncrease.setBounds(20, 100, 304, 29);
		lblVkupIncrease.setForeground(new Color(235, 235, 235));
		contentPane.add(lblVkupIncrease);

		JLabel lblVkrightIncrease = new JLabel("Tecla (S) :  Avall");
		lblVkrightIncrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblVkrightIncrease.setBounds(20, 135, 304, 29);
		lblVkrightIncrease.setForeground(new Color(235, 235, 235));
		contentPane.add(lblVkrightIncrease);


		JLabel jugador2 = new JLabel("JUGADOR 2");
		jugador2.setFont(new Font("Tahoma", Font.BOLD, 19));
		jugador2.setBounds(280, 75, 304, 29);
		jugador2.setForeground(new Color(49, 47, 47));
		contentPane.add(jugador2);

		JLabel lblVkupIncrease2 = new JLabel("↑ :  Amunt");
		lblVkupIncrease2.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
		lblVkupIncrease2.setBounds(280, 100, 304, 29);
		lblVkupIncrease2.setForeground(new Color(235, 235, 235));
		contentPane.add(lblVkupIncrease2);

		JLabel lblVkrightIncrease2 = new JLabel("↓ :  Avall");
		lblVkrightIncrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblVkrightIncrease2.setBounds(280, 135, 304, 29);
		lblVkrightIncrease2.setForeground(new Color(235, 235, 235));
		contentPane.add(lblVkrightIncrease2);


		JButton btnExit = new JButton("SORTIR");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tornar();
			}
		});

		btnExit.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnExit.setBackground(new Color(235, 235, 235));// COLOR FONDO BOTÓN
		btnExit.setForeground(new Color(44, 150, 57));// COLOR LETRA
		btnExit.setBounds(177, 365, 150, 40);// UBICACIÓN DEL BOTÓN
		contentPane.add(btnExit);
		
	}
	
	public void tornar() { //Funcion para volver a la pantalla de inicio
		inicio inici = new inicio();
		inici.setVisible(true);
		this.dispose();
		inici.setLocationRelativeTo(null);
		inici.setResizable(false);
	}


    
    
}
