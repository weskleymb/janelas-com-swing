package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GuiLista extends JPanel {

    private JButton btCalcular;
    private JLabel lbValor;
    private JTextField tfValor, tfValorDesconto;
    private JList liDesconto;
    private JScrollPane spLista;
    
    public GuiLista() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        lbValor = new JLabel("Valor");
        lbValor.setBounds(35, 05, 100, 25);
        add(lbValor);
        
        tfValor = new JTextField();
        tfValor.setBounds(35, 30, 100, 25);
        add(tfValor);
        
        tfValorDesconto = new JTextField();
        tfValorDesconto.setBounds(35, 150, 100, 25);
        tfValorDesconto.setEnabled(false);
        add(tfValorDesconto);
        
        
        btCalcular = new JButton("Calcular");
        btCalcular.setBounds(35, 120, 90, 25);
        add(btCalcular);
        
        String[] liDescontoItems = {"10%", "20%", "30%"};
        liDesconto = new JList(liDescontoItems);
        liDesconto.setSelectedIndex(0);
        
        spLista = new JScrollPane(liDesconto);
        spLista.setBounds(35, 60, 100, 55);
        add(spLista);
        
        //tfValor.requestFocus();
    }

    private void definirEventos() {
        btCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float valor = 0;
                float valorDesconto = 0;
                try {
                    valor = Float.parseFloat(tfValor.getText());
                } catch(NumberFormatException error) {
                    JOptionPane.showMessageDialog(null, "Informe um número válido!");
                } finally {
                    switch (liDesconto.getSelectedIndex()) {
                        case 0:
                            valorDesconto = valor * 0.9f;
                            break;
                        case 1:
                            valorDesconto = valor * 0.8f;
                            break;
                        case 2:
                            valorDesconto = valor * 0.7f;
                            break;
                    }
                    tfValorDesconto.setText(String.valueOf(valorDesconto));
                    tfValor.requestFocus();
                }   
            }
        });
    }
    
}
