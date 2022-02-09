package swing;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuiDialogoMensagem extends JPanel {

    private JComboBox cbCaixas;
    private ImageIcon imagem;
    
    public GuiDialogoMensagem() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        String[] cbCaixasItens = {
            "Pergunta", 
            "Informação", 
            "Alerta", 
            "Erro", 
            "Somente Mensagem",
            "Personalizado"
        };
        cbCaixas = new JComboBox(cbCaixasItens);
        cbCaixas.setBounds(25, 40, 150, 25);
        add(cbCaixas);
        
        imagem = new ImageIcon(new ImageIcon("java.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
    }

    private void definirEventos() {
        cbCaixas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensagem = "";
                String titulo = cbCaixas.getSelectedItem().toString();
                int icone = 0;
                int indice = cbCaixas.getSelectedIndex();
                switch(indice) {
                    case 0:
                        mensagem = "Estou aprendendo Java?"; 
                        icone = JOptionPane.QUESTION_MESSAGE;
                        break;
                    case 1:
                        mensagem = "Gravação OK!";
                        icone = JOptionPane.INFORMATION_MESSAGE;
                        break;
                    case 2:
                        mensagem = "Cuidado!";
                        icone = JOptionPane.WARNING_MESSAGE;
                        break;
                    case 3:
                        mensagem = "Ocorreu um erro!";
                        icone = JOptionPane.ERROR_MESSAGE;
                        break;
                    case 4:
                        mensagem = "Caixa de mensagem simples!";
                        icone = JOptionPane.PLAIN_MESSAGE;
                        break;
                    case 5:
                        mensagem = "Usando minha imagem!";
                        icone = JOptionPane.PLAIN_MESSAGE;
                        JOptionPane.showMessageDialog(null, mensagem, titulo, icone, imagem);
                        break;
                }
                JOptionPane.showMessageDialog(null, mensagem, titulo, icone);
            }
        });
    }
    
}
