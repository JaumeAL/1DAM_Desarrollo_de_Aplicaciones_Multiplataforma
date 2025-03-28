// {
//   "name": "Jaume",
//   "surname": "Salas",
//   "age": 18
// }
package com.example; 

import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 

public class ayuda extends JFrame { // Declara la clase ayuda que extiende JFrame, lo que significa que es una ventana de Swing
    
    private JPanel contentPane; // Declara un panel que contendrá todos los componentes de la ventana

    public ayuda() { // Constructor de la clase ayuda

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Establece que la aplicación se cierre al cerrar la ventana
        setBounds(100, 100, 501, 447); // Define la posición y el tamaño de la ventana 
        contentPane = new JPanel(); // Crea un nuevo panel para contener los componentes
        contentPane.setBackground(new Color(232, 232, 232)); // Establece el color de fondo del panel
        setContentPane(contentPane); // Asigna el panel como el contenido principal de la ventana
        contentPane.setLayout(null); // Establece un diseño nulo para posicionar los componentes manualmente

        JLabel lblInstructions = new JLabel("INSTRUCCIONS"); // Crea una etiqueta con el texto "INSTRUCCIONS"
        lblInstructions.setForeground(Color.black); // Establece el color del texto de la etiqueta a negro
        lblInstructions.setFont(new Font("Tahoma", Font.BOLD, 25)); // Define la fuente, estilo y tamaño del texto
        lblInstructions.setBounds(145, 20, 200, 46); // Posiciona la etiqueta en el panel
        contentPane.add(lblInstructions); // Añade la etiqueta al panel

        JLabel jugador1 = new JLabel("JUGADOR 1"); // Crea una etiqueta para el nombre del jugador 1
        jugador1.setFont(new Font("Tahoma", Font.BOLD, 19)); // Establece la fuente, estilo y tamaño del texto
        jugador1.setBounds(55, 125, 304, 29); // Posiciona la etiqueta en el panel
        jugador1.setForeground(new Color(24, 25, 26)); // Establece el color del texto
        contentPane.add(jugador1); // Añade la etiqueta al panel

        JLabel pala1W = new JLabel("Tecla (W) :  Amunt"); // Crea una etiqueta para la tecla W del jugador 1
        pala1W.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Establece la fuente y tamaño del texto
        pala1W.setBounds(55, 170, 304, 29); // Posiciona la etiqueta en el panel
        pala1W.setForeground(new Color(0,0,0)); // Establece el color del texto
        contentPane.add(pala1W); // Añade la etiqueta al panel

        JLabel pala1S = new JLabel("Tecla (S) :  Avall"); // Crea una etiqueta para la tecla S del jugador 1
        pala1S.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Establece la fuente y tamaño del texto
        pala1S.setBounds(55, 205, 304, 29); // Posiciona la etiqueta en el pane
        pala1S.setForeground(new Color(0,0,0)); // Establece el color del texto
        contentPane.add(pala1S); // Añade la etiqueta al panel

        JLabel jugador2 = new JLabel("JUGADOR 2"); // Crea una etiqueta para el nombre del jugador 2
        jugador2.setFont(new Font("Tahoma", Font.BOLD, 19)); // Establece la fuente, estilo y tamaño del texto
        jugador2.setBounds(280, 125, 304, 29); // Posiciona la etiqueta en el panel
        jugador2.setForeground(new Color(24, 25, 26)); // Establece el color del texto
        contentPane.add(jugador2); // Añade la etiqueta al panel

        JLabel pala2U = new JLabel("Tecla (↑) :  Amunt"); // Crea una etiqueta para la tecla de flecha arriba del jugador 2
        pala2U.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Establece la fuente y tamaño del texto
        pala2U.setBounds(280, 170, 304, 29); // Posiciona la etiqueta en el panel
        pala2U.setForeground(new Color(0,0,0)); // Establece el color del texto
        contentPane.add(pala2U); // Añade la etiqueta al panel

        JLabel pala2D = new JLabel("Tecla (↓) :  Avall"); // Crea una etiqueta para la tecla de flecha abajo del jugador 2
        pala2D.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Establece la fuente y tamaño del texto
        pala2D.setBounds(280, 205, 304, 29); // Posiciona la etiqueta en el panel
        pala2D.setForeground(new Color(0,0,0)); // Establece el color del texto
        contentPane.add(pala2D); // Añade la etiqueta al panel

        JButton btnExit = new JButton("SORTIR"); // Crea un botón
        btnExit.addActionListener(new ActionListener() { // Añade un listener para manejar el evento de clic en el botón
            public void actionPerformed(ActionEvent e) { // Define lo que sucede cuando se hace clic en el botón
                tornar(); // Llama al método tornar para volver a la pantalla de inicio
            }
        });

        btnExit.setForeground(new Color(235, 235, 235)); // Establece el color del texto del botón
        btnExit.setBackground(new Color(24,25,26)); // Establece el color de fondo del botón
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 28)); // Define la fuente, estilo y tamaño del texto del botón.
        btnExit.setBounds(160, 365, 150, 40); // Posiciona el botón en el panel
        contentPane.add(btnExit); // Añade el botón al panel
    }
    
    public void tornar() { // Método para volver a la pantalla de inicio
        inicio inici = new inicio(); // Crea una nueva instancia de la clase inicio
        inici.setVisible(true); // Hace visible la ventana de inicio
        this.dispose(); // Cierra la ventana actual
        inici.setLocationRelativeTo(null); // Centra la ventana de inicio en la pantalla
        inici.setResizable(false); // Establece que la ventana de inicio no sea redimensionable
        }
    }
