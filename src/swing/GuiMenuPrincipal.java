package swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GuiMenuPrincipal extends JFrame {

    private Container contentPane;
    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnExemplos;
    private JMenuItem miSair, miBotao, miCaixaOpcao, miRadio;
    private JMenuItem miLabel, miLista, miListaComFotos, miCombo;
    private JMenuItem miAreaDeTexto, miBarraProgresso, miAbas; 
    private JMenuItem miDialogoMensagem, miDialogoConfirmacao, miDialogoOpcao;
    private JMenuItem miFrameInterno, miMascara, miPedido;
    
    public GuiMenuPrincipal() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setTitle("Menu Principal");
        setBounds(0, 0, 800, 600);
        contentPane = getContentPane();
        
        mnBarra = new JMenuBar();
        
        mnArquivo = new JMenu("Arquivo");
        mnArquivo.setMnemonic(KeyEvent.VK_A);
        mnExemplos = new JMenu("Exemplos");
        mnExemplos.setMnemonic(KeyEvent.VK_E);
        
        miSair = new JMenuItem("Sair");
        miBotao = new JMenuItem("Botão");
        miCaixaOpcao = new JMenuItem("Caixa de Opção");
        miRadio = new JMenuItem("Radio");
        miLabel = new JMenuItem("Label");
        miLista = new JMenuItem("Lista");
        miListaComFotos = new JMenuItem("Lista com Fotos");
        miCombo = new JMenuItem("ComboBox");
        miAreaDeTexto = new JMenuItem("Area de Texto");
        miDialogoMensagem = new JMenuItem("Dialogo Mensagem");
        miDialogoConfirmacao = new JMenuItem("Dialogo Confirmação");
        miDialogoOpcao = new JMenuItem("Dialogo Opção");
        miBarraProgresso = new JMenuItem("Barra de Progresso");
        miAbas = new JMenuItem("Abas");
        miFrameInterno = new JMenuItem("Janela Interna");
        miMascara = new JMenuItem("Máscara");
        miPedido = new JMenuItem("Pedido");
        
        mnArquivo.add(miSair);
        mnExemplos.add(miBotao);
        mnExemplos.add(miCaixaOpcao);
        mnExemplos.add(miRadio);
        mnExemplos.add(miLabel);
        mnExemplos.add(miLista);
        mnExemplos.add(miListaComFotos);
        mnExemplos.add(miCombo);
        mnExemplos.add(miAreaDeTexto);
        mnExemplos.add(miDialogoMensagem);
        mnExemplos.add(miDialogoConfirmacao);
        mnExemplos.add(miDialogoOpcao);
        mnExemplos.add(miBarraProgresso);
        mnExemplos.add(miAbas);
        mnExemplos.add(miFrameInterno);
        mnExemplos.add(miMascara);
        mnExemplos.add(miPedido);
        
        mnBarra.add(mnArquivo);
        mnBarra.add(mnExemplos);
        
        setJMenuBar(mnBarra);
    }

    private void definirEventos() {
        miSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        miBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiBotao panel = new GuiBotao();
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate();
            }
        });
        miCaixaOpcao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCaixaOpcao panel = new GuiCaixaOpcao();
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate();
            }
        });
        miRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiRadio panel = new GuiRadio();
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate();
            }
        });
        miLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLabel panel = new GuiLabel();
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate();
            }
        });
        miLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLista panel = new GuiLista();
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate();
            }
        });
        miListaComFotos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiListaComFotos panel = new GuiListaComFotos();
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate();
            }
        });
        miCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCombo panel = new GuiCombo();
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate();
            }
        });
        miAreaDeTexto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAreaDeTexto panel = new GuiAreaDeTexto();
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate();
            }
        });
        miDialogoMensagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiDialogoMensagem panel = new GuiDialogoMensagem();
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate();
            }
        });
        miDialogoConfirmacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiDialogoConfirmacao panel = new GuiDialogoConfirmacao();
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate();
            }
        });
        miDialogoOpcao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiDialogoOpcao panel = new GuiDialogoOpcao();
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate();
            }
        });
        miBarraProgresso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiBarraProgresso panel = new GuiBarraProgresso();
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate();
            }
        });
        miAbas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAbas panel = new GuiAbas();
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate();
            }
        });
        miFrameInterno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiFrameInterno panel = new GuiFrameInterno();
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate();
            }
        });
        miMascara.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiMascara panel = new GuiMascara();
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate();
            }
        });
        miPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiPedido panel = new GuiPedido();
                contentPane.removeAll();
                contentPane.add(panel);
                contentPane.validate();
            }
        });
    }
    
    public static void abrir() {
        GuiMenuPrincipal frame = new GuiMenuPrincipal();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (tela.width - frame.getSize().width) / 2;
        int y = (tela.height - frame.getSize().height) / 2;
        frame.setLocation(x, y);
        frame.setVisible(true);
    }
    
}
