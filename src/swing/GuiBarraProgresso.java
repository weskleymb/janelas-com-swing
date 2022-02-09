package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class GuiBarraProgresso extends JPanel {

    private JLabel lbProgresso;    
    private JButton btAumentar, btDiminuir;
    private JProgressBar pbInstalar;
    
    public GuiBarraProgresso() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        lbProgresso = new JLabel("Teste");
        lbProgresso.setBounds(155, 8, 100, 25);
        add(lbProgresso);
        
        btAumentar = new JButton("Aumentar");
        btAumentar.setBounds(50, 50, 100, 25);
        btAumentar.setMnemonic(KeyEvent.VK_A);
        add(btAumentar);
        
        btDiminuir = new JButton("Diminuir");
        btDiminuir.setBounds(50, 100, 100, 25);
        btDiminuir.setMnemonic(KeyEvent.VK_D);
        add(btDiminuir);
        
        pbInstalar = new JProgressBar();
        pbInstalar.setBounds(50, 10, 100, 20);
        add(pbInstalar);
    }

    private void definirEventos() {
        btAumentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int valorBarraProgresso = pbInstalar.getValue() + 5;
                pbInstalar.setValue(valorBarraProgresso);
                lbProgresso.setText(String.valueOf(valorBarraProgresso));
            }
        });
        btDiminuir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int valorBarraProgresso = pbInstalar.getValue() - 5;
                pbInstalar.setValue(valorBarraProgresso);
                lbProgresso.setText(String.valueOf(valorBarraProgresso));
            }
        });
    }
    
}
