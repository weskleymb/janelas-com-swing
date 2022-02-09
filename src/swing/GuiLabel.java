package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiLabel extends JPanel {
    
    private JLabel lb1, lb2, lb3, lb4;
    private ImageIcon ic1;
    
    public GuiLabel() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(null);
        setBackground(Color.PINK);
        
        ic1 = new ImageIcon("imagens/mssql.png");
        
        Image imagem = ic1.getImage();
        Image novoIcone = imagem.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        
        ic1 = new ImageIcon(novoIcone);
        
        lb1 = new JLabel("Aprendendo", JLabel.LEFT);
        lb1.setForeground(Color.RED);
        lb1.setBounds(15, 30, 500, 25);
        add(lb1);
        
        lb2 = new JLabel("Inserir", JLabel.RIGHT);
        lb2.setForeground(Color.BLUE);
        lb2.setBounds(15, 60, 500, 25);
        add(lb2);
        
        lb3 = new JLabel("Label e Imagem", ic1, JLabel.CENTER);
        lb3.setForeground(Color.MAGENTA);
        lb3.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        lb3.setBounds(15, 90, 500, 25);
        add(lb3);
        
        lb4 = new JLabel(ic1, JLabel.LEFT);
        lb4.setBounds(15, 120, 500, 70);
        add(lb4);
    }
    
}
