import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdvancedSwingApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}

class MainFrame extends JFrame {
    private JTextField textField;
    private JTextArea textArea;
    private JCheckBox checkBox;
    private JRadioButton radioButton1, radioButton2;
    private JComboBox<String> comboBox;
    private JScrollBar scrollBar;
    private JLabel label;

    public MainFrame() {
        setTitle("Advanced Swing Application");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        label = new JLabel("Interactua amb els elements");
        topPanel.add(label);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        textField = new JTextField();
        textArea = new JTextArea(3, 20);
        checkBox = new JCheckBox("Acceptar");
        radioButton1 = new JRadioButton("Opció 1");
        radioButton2 = new JRadioButton("Opció 2");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        comboBox = new JComboBox<>(new String[]{"Opció A", "Opció B", "Opció C"});

        centerPanel.add(new JLabel("TextField:"));
        centerPanel.add(textField);
        centerPanel.add(new JLabel("TextArea:"));
        centerPanel.add(new JScrollPane(textArea));
        centerPanel.add(checkBox);
        centerPanel.add(comboBox);
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        JButton button = new JButton("Enviar");
        scrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 100);
        bottomPanel.add(button);
        bottomPanel.add(scrollBar);
        add(bottomPanel, BorderLayout.SOUTH);

        // Listeners
        button.addActionListener(e -> label.setText("Botó premut"));
        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                label.setText("Tecla: " + e.getKeyChar());
            }
        });
        checkBox.addItemListener(e -> label.setText("Checkbox: " + (checkBox.isSelected() ? "Marcat" : "Desmarcat")));
        comboBox.addActionListener(e -> label.setText("Seleccionat: " + comboBox.getSelectedItem()));
        scrollBar.addAdjustmentListener(e -> label.setText("Scroll: " + e.getValue()));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Finestra tancant-se");
            }
        });
    }
}
