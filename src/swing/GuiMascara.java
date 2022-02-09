package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

public class GuiMascara extends JPanel {

    private JLabel lbCpf, lbCnpj, lbFone, lbCep;
    private JButton btMostrar;
    private JFormattedTextField tfCpf, tfCnpj, tfFone, tfCep;
    private MaskFormatter mfCpf, mfCnpj, mfFone, mfCep;
    
    public GuiMascara() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        lbCpf = new JLabel("CPF:");
        lbCpf.setBounds(15, 20, 100, 20);
        add(lbCpf);
        
        lbCnpj = new JLabel("CNPJ:");
        lbCnpj.setBounds(15, 50, 100, 20);
        add(lbCnpj);
        
        lbFone = new JLabel("Fone:");
        lbFone.setBounds(15, 80, 100, 20);
        add(lbFone);
        
        lbCep = new JLabel("CEP:");
        lbCep.setBounds(15, 110, 100, 20);
        add(lbCep);
        
        btMostrar = new JButton("Mostrar");
        btMostrar.setBounds(15, 140, 200, 25);
        add(btMostrar);
        
        try {
            mfCpf = new MaskFormatter("###.###.###-##");
            tfCpf = new JFormattedTextField(mfCpf);
            tfCpf.setBounds(60, 20, 150, 20);
            add(tfCpf);
            
            mfCnpj = new MaskFormatter("##.###.###/####-##");
            tfCnpj = new JFormattedTextField(mfCnpj);
            tfCnpj.setBounds(60, 50, 150, 20);
            add(tfCnpj);
            
            mfFone = new MaskFormatter("(##) ####-####");
            tfFone = new JFormattedTextField(mfFone);
            tfFone.setBounds(60, 80, 150, 20);
            add(tfFone);
            
            mfCep = new MaskFormatter("##.###-###");
            tfCep = new JFormattedTextField(mfCep);
            tfCep.setBounds(60, 110, 150, 20);
            add(tfCep);
        } catch(ParseException error) {
            JOptionPane.showMessageDialog(null, error);
        }
        
        
    }

    private void definirEventos() {
        btMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, removerMascara(tfCpf.getText()));
            }
        });
    }
    
    private String removerMascara(String texto) {
        return texto.replace(".", "").replace("-", "").replace("/", "");
    }
    
}
