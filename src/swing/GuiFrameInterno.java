package swing;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class GuiFrameInterno extends JInternalFrame {
    
    private JLabel lbNome;
    private JButton btMostrar;
    
    public GuiFrameInterno() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setTitle("Usando Frame Interno");
        setSize(300, 100);
        setResizable(true);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setBackground(Color.PINK);
        setVisible(true);
        
        lbNome = new JLabel("Weskley Bezerra");
        lbNome.setBounds(10, 30, 50, 25);
        add(lbNome);
        
        btMostrar = new JButton("Mostrar");
        btMostrar.setBounds(10, 60, 50, 25);
        add(btMostrar);
    }
    
}
