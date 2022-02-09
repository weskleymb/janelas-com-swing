package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuiDialogoOpcao extends JPanel {
    
    private JLabel lbResposta;
    private JButton btAbrir;
    
    public GuiDialogoOpcao() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        lbResposta = new JLabel("");
        lbResposta.setBounds(25, 30, 200, 25);
        add(lbResposta);
        
        btAbrir = new JButton("Abrir");
        btAbrir.setBounds(25, 60, 100, 25);
        add(btAbrir);
    }

    private void definirEventos() {
        btAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] escolha = {"Masculino", "Feminino"};
                int resposta = JOptionPane.showOptionDialog(
                    null,                           //Centro
                    "Escolha o sexo:",              //Mensagem
                    "Sexo",                         //Tituto
                    JOptionPane.OK_OPTION,          //Botao
                    JOptionPane.INFORMATION_MESSAGE,    //Icone
                    null,                           //Imagem
                    escolha,                        //Lista
                    escolha[0]                      //Opcao selecionada
                );
                lbResposta.setText("Sexo escolhido: " + escolha[resposta]);
            }
        });
    }
    
}
