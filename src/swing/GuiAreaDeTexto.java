package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuiAreaDeTexto extends JPanel {

    private final String NOVALINHA = "\n";
    
    private JTextField tfCampo;
    private JButton btLimpar;
    private JTextArea taTexto;
    private JScrollPane spTexto;
    
    public GuiAreaDeTexto() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        tfCampo = new JTextField();
        tfCampo.setBounds(25, 15, 150, 25);
        add(tfCampo);
        
        btLimpar = new JButton("Limpar");
        btLimpar.setBounds(25, 170, 150, 25);
        add(btLimpar);
        
        taTexto = new JTextArea();
        taTexto.setEditable(false);
        
        spTexto = new JScrollPane(taTexto);
        spTexto.setBounds(25, 45, 300, 120);
        add(spTexto);
    }

    private void definirEventos() {
        btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfCampo.setText("");
                taTexto.setText("");
                tfCampo.requestFocus();
            }
        });
        tfCampo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfCampo.selectAll();
                taTexto.append(tfCampo.getText() + NOVALINHA);
                tfCampo.setText("");
                tfCampo.requestFocus();
            }
        });
    }
    
}
