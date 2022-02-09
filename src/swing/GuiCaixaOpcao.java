package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuiCaixaOpcao extends JPanel {

    private JButton btVerificar, btMarcar, btDesmarcar;
    private JCheckBox cbIngles, cbInformatica;
    
    public GuiCaixaOpcao() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        cbIngles = new JCheckBox("Inglês");
        cbIngles.setBounds(15, 15, 100, 25);
        add(cbIngles);
        
        cbInformatica = new JCheckBox("Informática");
        cbInformatica.setBounds(15, 40, 100, 25);
        add(cbInformatica);
        
        btVerificar = new JButton("Verificar");
        btVerificar.setBounds(20, 70, 100, 20);
        add(btVerificar);
        
        btMarcar = new JButton("Marcar");
        btMarcar.setBounds(20, 100, 100, 20);
        add(btMarcar);
        
        btDesmarcar = new JButton("Desmarcar");
        btDesmarcar.setBounds(20, 130, 100, 20);
        add(btDesmarcar);
    }

    private void definirEventos() {
        btMarcar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbIngles.setSelected(true);
                cbInformatica.setSelected(true);
            }
        });
        btDesmarcar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbIngles.setSelected(false);
                cbInformatica.setSelected(false);
            }
        });
        btVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = "Selecionados: ";
                if (cbIngles.isSelected()) {
                    texto += "\nInglês ";
                }
                if (cbInformatica.isSelected()) {
                    texto += "\nInformática ";
                }
                JOptionPane.showMessageDialog(null, texto);
            }
        });
    }
    
}
