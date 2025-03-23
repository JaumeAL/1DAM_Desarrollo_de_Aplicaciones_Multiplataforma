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

		JLabel jugador1 = new JLabel("RYU JUGADOR 1");
		jugador1.setFont(new Font("Tahoma", Font.BOLD, 19));
		jugador1.setBounds(20, 75, 304, 29);
		jugador1.setForeground(new Color(49, 47, 47));
		contentPane.add(jugador1);

		JLabel lblVkupIncrease = new JLabel("Tecla (W) :  Salt");
		lblVkupIncrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblVkupIncrease.setBounds(20, 100, 304, 29);
		lblVkupIncrease.setForeground(new Color(235, 235, 235));
		contentPane.add(lblVkupIncrease);

		JLabel lblVkrightIncrease = new JLabel("Tecla (A) :  Esquerra");
		lblVkrightIncrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblVkrightIncrease.setBounds(20, 135, 304, 29);
		lblVkrightIncrease.setForeground(new Color(235, 235, 235));
		contentPane.add(lblVkrightIncrease);

		JLabel lblVkdownDecrease = new JLabel("Tecla (S) :  Acotar-se");
		lblVkdownDecrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblVkdownDecrease.setBounds(20, 170, 304, 29);
		lblVkdownDecrease.setForeground(new Color(235, 235, 235));
		contentPane.add(lblVkdownDecrease);

		JLabel lblVkleftDecrease = new JLabel("Tecla (D) :  Dreta");
		lblVkleftDecrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblVkleftDecrease.setBounds(20, 205, 304, 29);
		lblVkleftDecrease.setForeground(new Color(235, 235, 235));
		contentPane.add(lblVkleftDecrease);

		JLabel lblVkrIncrease = new JLabel("Tecla (G) :  Cop");
		lblVkrIncrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblVkrIncrease.setBounds(20, 240, 304, 29);
		lblVkrIncrease.setForeground(new Color(235, 235, 235));
		contentPane.add(lblVkrIncrease);

		JLabel lblVklDecrease = new JLabel("Tecla (H) :  Potada");
		lblVklDecrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblVklDecrease.setBounds(20, 275, 304, 29);
		lblVklDecrease.setForeground(new Color(235, 235, 235));
		contentPane.add(lblVklDecrease);

		JLabel ldlVklPoderespecial = new JLabel("Tecla (J) :  Poder");
		ldlVklPoderespecial.setFont(new Font("Tahoma", Font.ITALIC, 18));
		ldlVklPoderespecial.setBounds(20, 310, 304, 29);
		ldlVklPoderespecial.setForeground(new Color(235, 235, 235));
		contentPane.add(ldlVklPoderespecial);

		JLabel jugador2 = new JLabel("KEN JUGADOR 2");
		jugador2.setFont(new Font("Tahoma", Font.BOLD, 19));
		jugador2.setBounds(280, 75, 304, 29);
		jugador2.setForeground(new Color(49, 47, 47));
		contentPane.add(jugador2);

		JLabel lblVkupIncrease2 = new JLabel("Fletxa :  Salt");
		lblVkupIncrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblVkupIncrease2.setBounds(280, 100, 304, 29);
		lblVkupIncrease2.setForeground(new Color(235, 235, 235));
		contentPane.add(lblVkupIncrease2);

		JLabel lblVkrightIncrease2 = new JLabel("Fletxa :  Esquerra");
		lblVkrightIncrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblVkrightIncrease2.setBounds(280, 135, 304, 29);
		lblVkrightIncrease2.setForeground(new Color(235, 235, 235));
		contentPane.add(lblVkrightIncrease2);

		JLabel lblVkdownDecrease2 = new JLabel("Fletxa :  Acotar-se");
		lblVkdownDecrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblVkdownDecrease2.setBounds(280, 170, 304, 29);
		lblVkdownDecrease2.setForeground(new Color(235, 235, 235));
		contentPane.add(lblVkdownDecrease2);

		JLabel lblVkleftDecrease2 = new JLabel("Fletxa :  Dreta");
		lblVkleftDecrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblVkleftDecrease2.setBounds(280, 205, 304, 29);
		lblVkleftDecrease2.setForeground(new Color(235, 235, 235));
		contentPane.add(lblVkleftDecrease2);

		JLabel lblVkrIncrease2 = new JLabel("NumPad (1) :  Cop");
		lblVkrIncrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblVkrIncrease2.setBounds(280, 240, 304, 29);
		lblVkrIncrease2.setForeground(new Color(235, 235, 235));
		contentPane.add(lblVkrIncrease2);

		JLabel lblVklDecrease2 = new JLabel("NumPad (2) :  Potada");
		lblVklDecrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblVklDecrease2.setBounds(280, 275, 304, 29);
		lblVklDecrease2.setForeground(new Color(235, 235, 235));
		contentPane.add(lblVklDecrease2);

		JLabel ldlVklPoderespecial2 = new JLabel("NumPad (3) :  Poder");
		ldlVklPoderespecial2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		ldlVklPoderespecial2.setBounds(280, 310, 304, 29);
		ldlVklPoderespecial2.setForeground(new Color(235, 235, 235));
		contentPane.add(ldlVklPoderespecial2);

		JButton btnExit = new JButton("SORTIR");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnExit.setBackground(new Color(235, 235, 235));// COLOR FONDO BOTÓN
		btnExit.setForeground(new Color(44, 150, 57));// COLOR LETRA
		btnExit.setBounds(177, 365, 150, 40);// UBICACIÓN DEL BOTÓN
		contentPane.add(btnExit);

		try { // Fuente22
			Font font = Font.createFont(Font.TRUETYPE_FONT,
					getClass().getResourceAsStream("/com/shridhar/personalGame/junegull.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
			Font buttonFont = font.deriveFont(Font.ITALIC, 22f);

			ldlVklPoderespecial2.setFont(buttonFont);
			lblVklDecrease2.setFont(buttonFont);
			lblVkrIncrease2.setFont(buttonFont);
			lblVkleftDecrease2.setFont(buttonFont);
			lblVkdownDecrease2.setFont(buttonFont);
			lblVkrightIncrease2.setFont(buttonFont);
			lblVkupIncrease2.setFont(buttonFont);
			ldlVklPoderespecial.setFont(buttonFont);
			lblVklDecrease.setFont(buttonFont);
			lblVkrIncrease.setFont(buttonFont);
			lblVkleftDecrease.setFont(buttonFont);
			lblVkdownDecrease.setFont(buttonFont);
			lblVkrightIncrease.setFont(buttonFont);
			lblVkupIncrease.setFont(buttonFont);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try { // Fuente 26
			Font font = Font.createFont(Font.TRUETYPE_FONT,
					getClass().getResourceAsStream("/com/shridhar/personalGame/junegull.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
			Font buttonFont = font.deriveFont(Font.BOLD, 30f);

			btnExit.setFont(buttonFont);
			jugador2.setFont(buttonFont);
			jugador1.setFont(buttonFont);
			lblInstructions.setFont(buttonFont);

		} catch (Exception e) {
			e.printStackTrace();
		}

        
	}



    
    
}
