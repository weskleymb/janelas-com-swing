package swing;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuiBotao extends JPanel {

    private JButton btMensagem, btTeimoso;
    private ImageIcon icone;

    public GuiBotao() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        icone = new ImageIcon("java.png");
        
        Image imagem = icone.getImage();
        Image novoIcone = imagem.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        
        icone = new ImageIcon(novoIcone);
        
        btMensagem = new JButton("Mensagem", icone);
        btMensagem.setToolTipText("Clique para ver a mensagem");
        btMensagem.setMnemonic(KeyEvent.VK_M);
        btMensagem.setBounds(50, 20, 140, 40);
        add(btMensagem);
        
        btTeimoso = new JButton("Teimoso");
        btTeimoso.setBounds(50, 70, 100, 25);
        add(btTeimoso);
    }

    private void definirEventos() {
        btMensagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botão de Mensagem");
            }
        });
        btTeimoso.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                btTeimoso.setBounds(50, 120, 100, 25);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btTeimoso.setBounds(50, 70, 100, 25);
            }
        });
    }
    
}
