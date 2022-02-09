package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GuiDialogoConfirmacao extends JPanel {

    private JRadioButton rb1, rb2, rb3;
    private ButtonGroup grupoRadio;
    private JButton btMostrar;
    
    public GuiDialogoConfirmacao() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        btMostrar = new JButton("Mostrar");
        btMostrar.setBounds(55, 110, 100, 20);
        add(btMostrar);
        
        rb1 = new JRadioButton("Sim e Não");
        rb1.setBounds(55, 10, 200, 35);
        add(rb1);
        
        rb2 = new JRadioButton("Sim, Não e Cancelar");
        rb2.setBounds(55, 40, 200, 35);
        add(rb2);
        
        rb3 = new JRadioButton("Ok e Cancelar");
        rb3.setBounds(55, 70, 200, 35);
        add(rb3);
        
        grupoRadio = new ButtonGroup();
        grupoRadio.add(rb1);
        grupoRadio.add(rb2);
        grupoRadio.add(rb3);
    }

    private void definirEventos() {
        btMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resposta = 0;
                if (rb1.isSelected()) {
                    resposta = JOptionPane.showConfirmDialog(
                        null,  
                        "Erro ao acessar o arquivo", //Mensagem
                        "Erro de arquivo",           //Titulo
                        JOptionPane.YES_NO_OPTION,   //Botoes
                        JOptionPane.ERROR_MESSAGE    //Icone
                    );
                }
                if (rb2.isSelected()) {
                    resposta = JOptionPane.showConfirmDialog(
                        null,  
                        "Deseja salvar as alterações?",   //Mensagem
                        "Salvar arquivo",                 //Titulo
                        JOptionPane.YES_NO_CANCEL_OPTION, //Botoes
                        JOptionPane.QUESTION_MESSAGE      //Icone
                    );
                }
                if (rb3.isSelected()) {
                    resposta = JOptionPane.showConfirmDialog(
                        null,  
                        "Deseja abrir o arquivo?",    //Mensagem
                        "Abrir arquivo",              //Titulo
                        JOptionPane.OK_CANCEL_OPTION, //Botoes
                        JOptionPane.QUESTION_MESSAGE  //Icone
                    );
                }
                JOptionPane.showMessageDialog(
                    null,
                    resposta,
                    "Resposta",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }
    
}
