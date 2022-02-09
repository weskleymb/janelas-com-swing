package swing;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GuiLogin extends JFrame {

    private JLabel lbLogin, lbSenha;
    private JTextField tfLogin;
    private JPasswordField pfSenha;
    private JButton btLogar, btCancelar;

    public GuiLogin() {
        inicializarComponentes();
        definirEventos();
    }
    
    private void inicializarComponentes() {
        setTitle("Login no Sistema");
        setBounds(0, 0, 250, 200);
        setLayout(null);
        
        lbLogin = new JLabel("Login");
        lbLogin.setBounds(30, 30, 80, 25);
        add(lbLogin);
        
        tfLogin = new JTextField();
        tfLogin.setBounds(100, 30, 120, 25);
        add(tfLogin);
        
        lbSenha = new JLabel("Senha");
        lbSenha.setBounds(30, 75, 80, 25);
        add(lbSenha);
        
        pfSenha = new JPasswordField();
        pfSenha.setBounds(100, 75, 120, 25);
        add(pfSenha);
        
        btLogar = new JButton("Logar");
        btLogar.setBounds(20, 120, 100, 25);
        add(btLogar);
        
        btCancelar = new JButton("Cancelar");
        btCancelar.setBounds(125, 120, 100, 25);
        add(btCancelar);
    }
    
    private void definirEventos() {
        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btLogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logar();
            }
        });
        pfSenha.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    logar();
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {}
            
            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }
    
    private void logar() {
        String login = tfLogin.getText();
        String senha = String.valueOf(pfSenha.getPassword());
        if (login.equals("java") && senha.equals("java")) {
            this.setVisible(false);
            GuiMenuPrincipal novaTela = new GuiMenuPrincipal();
            novaTela.abrir(); 
        } else {
            JOptionPane.showMessageDialog(null, "INVALIDO!");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GuiLogin frame = new GuiLogin();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (tela.width - frame.getSize().width) / 2;
                int y = (tela.height - frame.getSize().height) / 2;
                frame.setLocation(x, y);
                frame.setVisible(true);
            }
        });
    }
    
}
