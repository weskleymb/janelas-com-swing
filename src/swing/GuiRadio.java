package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GuiRadio extends JPanel {

    private JLabel lbSexo;
    private JRadioButton rbMasculino, rbFeminino;
    private ButtonGroup bgSexo;
    private JButton btVerificar;
    
    public GuiRadio() {
        inicializarComponentes();
        definirEventos();
    }
    
    private void inicializarComponentes() {
        setLayout(null);
        
        lbSexo = new JLabel("Selecione o sexo:");
        lbSexo.setBounds(55, 10, 105, 30);
        add(lbSexo);
        
        btVerificar = new JButton("Verificar");
        btVerificar.setBounds(55, 105, 100, 20);
        add(btVerificar);
        
        rbMasculino = new JRadioButton("Masculino");
        rbMasculino.setBounds(55, 45, 100, 25);
        rbMasculino.setSelected(true);
        add(rbMasculino);
        
        rbFeminino = new JRadioButton("Feminino");
        rbFeminino.setBounds(55, 70, 100, 25);
        add(rbFeminino);
        
        bgSexo = new ButtonGroup();
        bgSexo.add(rbMasculino);
        bgSexo.add(rbFeminino);
    }
    
    private void definirEventos() {
        btVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = "Sexo ";
                if (rbMasculino.isSelected()) {
                    texto += "Masculino";
                } else {
                    texto += "Feminino";
                }
                JOptionPane.showMessageDialog(null, texto);
            }
        });
    }
    
}
