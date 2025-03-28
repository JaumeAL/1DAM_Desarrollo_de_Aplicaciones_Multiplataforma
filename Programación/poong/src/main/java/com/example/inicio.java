// {
//   "name": "Jaume",
//   "surname": "Salas",
//   "age": 18
// }
package com.example;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class inicio extends JFrame {

    private JPanel contentPane;
    private JTextField jugador1Field;
    private JTextField jugador2Field;

    public static void main(String[] args) {  //Metodo main para ejecutar la aplicacion
        EventQueue.invokeLater(new Runnable() {  
            @Override
            public void run() { //Ejecuta el hilo de la aplicacion
                try { 
                    inicio frame = new inicio(); //Crea un nuevo objeto de la clase inicio
                    frame.setVisible(true);  //Muestra la ventana
                    frame.setLocationRelativeTo(null); //Centra la ventana en la pantalla
                } catch (Exception e) {
                    e.printStackTrace(); 
                }
            }
        });
    }

    public inicio() {
        setTitle("Poong by Jaume"); //Titulo de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cierra la ventana al pulsar la X
        setBounds(100, 100, 370, 500); //Tamaño de la ventana
        setResizable(false); //No permite cambiar el tamaño de la ventana
        
        contentPane = new JPanel(); //Crea un nuevo objeto de la clase JPanel
        contentPane.setBackground(new Color(232, 232, 232)); // COLOR DE FONDO
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //Borde del panel
        setContentPane(contentPane); //Agrega el panel al JFrame
        contentPane.setLayout(null); //Layout nulo para poder colocar los componentes donde queramos

        // IMAGEN
        ImageIcon icono = new ImageIcon(getClass().getResource("/com/example/ping.png")); // Ruta de la imagen
        JLabel etiqueta = new JLabel(icono); //Crea un nuevo objeto de la clase JLabel con la imagen
        etiqueta.setBounds(20, -22, 300, 240); // UBICACIÓN DE LA IMAGEN
        contentPane.add(etiqueta);

        // NOMBRE JUGADOR 1
        JLabel jugador1Label = new JLabel("Nom del Jugador 1:"); //Etiqueta para el nombre del jugador 1
        jugador1Label.setFont(new Font("Tahoma", Font.PLAIN, 18)); //Fuente de la etiqueta
        jugador1Label.setBounds(35, 190, 300, 28); //Ubicación de la etiqueta
        contentPane.add(jugador1Label); //Agrega la etiqueta al panel

        jugador1Field = new JTextField();  //Campo de texto para el nombre del jugador 1
        jugador1Field.setBounds(35, 220, 278, 28); //Ubicación del campo de texto
        contentPane.add(jugador1Field); //Agrega el campo de texto al panel
        jugador1Field.setColumns(10); //Campo de texto para el nombre del jugador 1

        // NOMBRE JUGADOR 2
        JLabel jugador2Label = new JLabel("Nom del Jugador 2:"); //Etiqueta para el nombre del jugador 2
        jugador2Label.setFont(new Font("Tahoma", Font.PLAIN, 18)); //Fuente de la etiqueta
        jugador2Label.setBounds(35, 250, 300, 28); //Ubicación de la etiqueta
        contentPane.add(jugador2Label); //Agrega la etiqueta al panel

        jugador2Field = new JTextField(); //Campo de texto para el nombre del jugador 2
        jugador2Field.setBounds(35, 280, 278, 28); //Ubicación del campo de texto
        contentPane.add(jugador2Field); //Agrega el campo de texto al panel
        jugador2Field.setColumns(10); //Campo de texto para el nombre del jugador 2

        // BOTÓN START
        JButton btnStartGame = new JButton("JUGAR"); //Texto del botón
        btnStartGame.addActionListener(new ActionListener() { //Accion al pulsar el boton
            @Override
            public void actionPerformed(ActionEvent e) { //Accion al pulsar el boton
                iniciarJuego(); //Llama al metodo iniciarJuego
            }
        });
        btnStartGame.setForeground(new Color(235, 235, 235)); // COLOR DEL TEXTO BLANQUITO
        btnStartGame.setBackground(new Color(24,25,26)); // COLOR DEL BOTÓN NEGRITO
        btnStartGame.setFont(new Font("Tahoma", Font.BOLD, 28)); // FUENTE DEL BOTÓN
        btnStartGame.setBounds(53, 330, 241, 55); // UBICACIÓN DEL BOTÓN
        contentPane.add(btnStartGame); // Agrega el botón al panel

        // BOTÓN INSTRUCCIONES
        JButton btnInstrucciones = new JButton("AJUDA"); //Texto del botón
        btnInstrucciones.addActionListener(new ActionListener() { //Accion al pulsar el boton
            @Override
            public void actionPerformed(ActionEvent e) { //Accion al pulsar el boton
                mostrarInstrucciones(); //Llama al metodo mostrarInstrucciones
            }
        });
        btnInstrucciones.setForeground(new Color(235, 235, 235)); // COLOR DEL TEXTO BLANQUITO
        btnInstrucciones.setBackground(new Color(24,25,26)); // COLOR DEL BOTÓN NEGRITO
        btnInstrucciones.setFont(new Font("Tahoma", Font.BOLD, 28)); // FUENTE DEL BOTÓN
        btnInstrucciones.setBounds(53, 400, 241, 55); // UBICACIÓN DEL BOTÓN
        contentPane.add(btnInstrucciones); // Agrega el botón al panel

    }

    private void mostrarInstrucciones() { //Metodo para mostrar las instrucciones
        this.setVisible(false); //Oculta la ventana actual
		this.dispose(); //Cierra la ventana actual al abrir la nueva ventana
		ayuda help = new ayuda(); //Crea un nuevo objeto de la clase ayuda
		help.setVisible(true); //Muestra la ventana de ayuda
		help.setLocationRelativeTo(null); //Centra la ventana en la pantalla
        help.setResizable(false); //Pantalla no redimensionable
    }

    private void iniciarJuego() {
        String jugador1 = jugador1Field.getText(); //Recoje el nombre del campo de texto
        String jugador2 = jugador2Field.getText(); //Recoje el nombre del campo de texto
        if (jugador1.isEmpty() || jugador2.isEmpty()) { //Si el campo de texto esta vacio
            //Muestra el mensaje de error
            JOptionPane.showMessageDialog(this, "Por favor, ingrese los nombres de ambos jugadores.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JFrame frame = new JFrame("POONG "); //Crea un nuevo objeto de la clase JFrame
            poong panel = new poong(jugador1, jugador2); //Crea un nuevo objeto de la clase poong
            frame.add(panel); //Agrega el panel al JFrame
            frame.setSize(600, 400); //Tamaño del JFrame
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cierra el JFrame al cerrar la ventana
            frame.setLocationRelativeTo(null); //Centra el JFrame en la pantalla
            frame.setResizable(false); //No permite cambiar el tamaño de la ventana
            frame.setVisible(true); //Muestra el JFrame
            dispose(); // Cierra el menú inicial
        }
    }
}