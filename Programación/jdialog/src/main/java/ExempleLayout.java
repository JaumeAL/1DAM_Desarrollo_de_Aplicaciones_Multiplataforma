
import javax.swing.*;
import java.awt.*;
public class ExempleLayout {
    public static void main(String[] args) {
        JFrame finestra = new  JFrame("Exemple de layoutManager");
        finestra.setSize(900,700);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setLayout(new BorderLayout());
        finestra.setLocationRelativeTo(null);

        //Creem el panel superior am flowlayout
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout()); //Oreganitza els elements en una fila
        panelSuperior.setLayout(new GridLayout(3,1)); 
        panelSuperior.setBackground(Color.pink);
        panelSuperior.add(new JButton("Botó 1"), BorderLayout.NORTH);
        panelSuperior.add(new JButton("Botó 2"), BorderLayout.SOUTH);
        panelSuperior.add(new JButton("Botó 3"), BorderLayout.CENTER);
        panelSuperior.add(new JButton("Botó 4"), BorderLayout.WEST);
        panelSuperior.add(new JButton("Botó 5"), BorderLayout.EAST);
        panelSuperior.add(new JButton("Botó 6"), BorderLayout.CENTER);


        //Creem un panel central amb GridLayout
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(1,1)); //2 files i 2 columnes
        panelCentral.setBackground(Color.blue);
        panelCentral.add(new JLabel("Etiqueta 1"));
        panelCentral.add(new JTextField("Text 1"));
        panelCentral.add(new JLabel("Etiqueta 2"));
        panelCentral.add(new JTextField("Text 2"));
        panelCentral.add(new JLabel("Etiqueta 1"));
        panelCentral.add(new JTextField("Text 1"));
        panelCentral.add(new JLabel("Etiqueta 2"));
        panelCentral.add(new JTextField("Text 2"));



        //Creem un panel inferior amb borderlayout
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout());
        panelInferior.setBackground(Color.green);
        panelInferior.add(new JButton("Botó inferior"), BorderLayout.CENTER);
        panelInferior.add(new JButton("Botó inferior 2"), BorderLayout.SOUTH);
        panelInferior.add(new JButton("Botó inferior 3"), BorderLayout.NORTH);
        panelInferior.add(new JButton("Botó inferior 4"), BorderLayout.WEST);
        panelInferior.add(new JButton("Botó inferior 5"), BorderLayout.EAST);
        // Añadimos un grupo de radio botones
        JRadioButton radioButton1 = new JRadioButton("Opción 1");
        JRadioButton radioButton2 = new JRadioButton("Opción 2");
        JRadioButton radioButton3 = new JRadioButton("Opción 3");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        panelInferior.add(radioButton1, BorderLayout.NORTH);
        panelInferior.add(radioButton2, BorderLayout.CENTER);
        panelInferior.add(radioButton3, BorderLayout.SOUTH);

        // Añadimos un grupo de checkboxes
        JCheckBox checkBox1 = new JCheckBox("Check 1");
        JCheckBox checkBox2 = new JCheckBox("Check 2");
        JCheckBox checkBox3 = new JCheckBox("Check 3");
        panelInferior.add(checkBox1, BorderLayout.WEST);
        panelInferior.add(checkBox2, BorderLayout.CENTER);
        panelInferior.add(checkBox3, BorderLayout.EAST);



        //Afegim un panerl a la dreta
        JPanel panelDreta = new JPanel();
        panelDreta.setLayout(new GridLayout(1,1));
        panelDreta.setBackground(Color.red);
        panelDreta.add(new JLabel("Etiqueta 1"));
        panelDreta.add(new JTextField("Text 1"));
        panelDreta.add(new JLabel("Etiqueta 2"));
        panelDreta.add(new JTextField("Text 2"));
        panelDreta.add(new JLabel("Etiqueta 1"));
        panelDreta.add(new JTextField("Text 1"));
        panelDreta.add(new JLabel("Etiqueta 2"));
        panelDreta.add(new JTextField("Text 2"));

        //Panel abaix del boton
        JPanel panelBoton = new JPanel();
        panelBoton.setLayout(new GridLayout(1,1));
        panelBoton.setBackground(Color.red);
        panelBoton.add(new JLabel("Etiqueta 1"));
        panelBoton.add(new JTextField("Text 1"));
        panelBoton.add(new JLabel("Etiqueta 2"));
        panelBoton.add(new JTextField("Text 2"));
        panelBoton.add(new JLabel("Etiqueta 1"));

        //Panel abaix del boton
        JPanel panelBoton1 = new JPanel();
        panelBoton1.setLayout(new GridLayout(1,1));
        panelBoton1.setBackground(Color.yellow);
        panelBoton1.add(new JLabel("Etiqueta 1"));
        panelBoton1.add(new JTextField("Text 1"));
        panelBoton1.add(new JLabel("Etiqueta 2"));
        panelBoton1.add(new JTextField("Text 2"));
        panelBoton1.add(new JLabel("Etiqueta 1"));


        //Afegim els panels a la finestra
        finestra.add(panelSuperior, BorderLayout.NORTH);
        finestra.add(panelCentral, BorderLayout.CENTER);
        finestra.add(panelDreta, BorderLayout.EAST);
        finestra.add(panelInferior, BorderLayout.EAST);
        finestra.add(panelBoton, BorderLayout.WEST);
        finestra.add(panelBoton1, BorderLayout.SOUTH);



        //Fem visible la finestra
        finestra.setVisible(true);




        



    }
    

}
