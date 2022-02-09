package swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GuiAbas extends JPanel {

    private JTabbedPane tpAbas;
    private JButton[] botoes = new JButton[15];
    
    public GuiAbas() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        for (int i = 0; i < 15; i++) {
            botoes[i] = new JButton("Botao " + (i + 1)); 
        }
        
        JPanel panel1 = new JPanel(new GridLayout(5, 1));
        for (int j = 0; j < 5; j++) {
            panel1.add(botoes[j]);
        }
        
        JPanel panel2 = new JPanel(new FlowLayout());
        for (int j = 5; j < 10; j++) {
            panel2.add(botoes[j]);
        }
        
        JPanel panel3 = new JPanel(new BorderLayout());
        for (int j = 10; j < 15; j++) {
            switch(j) {
                case 10:
                    panel3.add(botoes[j], "North");
                    break;
                case 11:
                    panel3.add(botoes[j], "South");
                    break;
                case 12:    
                    panel3.add(botoes[j], "East");
                    break;
                case 13:
                    panel3.add(botoes[j], "West");
                    break;
                case 14:
                    panel3.add(botoes[j], "Center");
                    break;
            }
        }
        
        tpAbas = new JTabbedPane();
        tpAbas.setBounds(0, 0, 790, 400);
        tpAbas.addTab("GridLayout", panel1);
        tpAbas.addTab("FlowLayout", panel2);
        tpAbas.addTab("BorderLayout", panel3);
        add(tpAbas);
    }
    
}
