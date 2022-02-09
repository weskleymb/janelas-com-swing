package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuiCombo extends JPanel {

    private JLabel lbEstados;
    private JComboBox cbEstados;
    private JButton btMostrar;
    
    public GuiCombo() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        lbEstados = new JLabel("Estados:");
        lbEstados.setBounds(25, 15, 150, 25);
        add(lbEstados);
        
        btMostrar = new JButton("Mostrar");
        btMostrar.setBounds(25, 75, 100, 25);
        add(btMostrar);
        
        String[] estados = {"Rio Grande do Norte", "Paraíba", "Ceará"};
        cbEstados = new JComboBox(estados);
        cbEstados.setBounds(25, 40, 150, 25);
        add(cbEstados);
    }

    private void definirEventos() {
        btMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String estado = "Estado selecionado " + cbEstados.getSelectedItem();
                JOptionPane.showMessageDialog(null, estado);
            }
        });
    }
    
}
