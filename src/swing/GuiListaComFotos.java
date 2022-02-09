package swing;

import java.awt.Image;
import java.awt.ScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GuiListaComFotos extends JPanel {

    private JList liFotos;
    private JScrollPane spFotos;
    private JLabel lbFotos;
    private ImageIcon foto;
    private DefaultListModel modelo;
    
    public GuiListaComFotos() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        modelo = new DefaultListModel();
        for (int i = 1; i <= 5; i++) {
            modelo.addElement("Foto" + i);
        }
        
        liFotos = new JList(modelo);
        
        spFotos = new JScrollPane(liFotos);
        spFotos.setBounds(50, 40, 70, 150);
        add(spFotos);
        
        foto = new ImageIcon();
        
        lbFotos = new JLabel(foto);
        lbFotos.setBounds(150, 30, 180, 180);
        add(lbFotos);
    }

    private void definirEventos() {
        liFotos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String imagem = "fotos/" + liFotos.getSelectedValue() + ".png";
                foto = new ImageIcon(imagem);
                //Image image = foto.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                //image = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                foto = new ImageIcon(foto.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
                lbFotos.setIcon(foto);
            }
        });
    }
    
}
