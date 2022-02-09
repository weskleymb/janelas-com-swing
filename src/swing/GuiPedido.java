package swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class GuiPedido extends JPanel {

    private JLabel lbNumero, lbTotal, lbProduto;
    private JLabel lbPrecoUnitario, lbQuantidade;
    private JTextField tfNumero, tfTotal, tfProduto;
    private JTextField tfPrecoUnitario, tfQuantidade;
    private JButton btAdicionar, btRemover;
    private JScrollPane spTabela;
    private JTable tabela;
    private JPanel pnPrincipal, pnTabela;
    private DecimalFormat real = new DecimalFormat("#,###.00");
    private DecimalFormat inteiro = new DecimalFormat("000");

    public GuiPedido() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);

        pnPrincipal = new JPanel();
        pnPrincipal.setLayout(null);
        pnPrincipal.setBounds(0, 0, 500, 400);
        add(pnPrincipal);

        lbNumero = new JLabel("Numero do Pedido:");
        lbNumero.setBounds(15, 10, 120, 25);
        pnPrincipal.add(lbNumero);

        lbTotal = new JLabel("Total do Pedido:");
        lbTotal.setBounds(278, 360, 100, 25);
        pnPrincipal.add(lbTotal);

        lbProduto = new JLabel("Produto");
        lbProduto.setBounds(15, 40, 100, 25);
        pnPrincipal.add(lbProduto);

        lbPrecoUnitario = new JLabel("Preço Unitário");
        lbPrecoUnitario.setBounds(310, 40, 100, 25);
        pnPrincipal.add(lbPrecoUnitario);

        lbQuantidade = new JLabel("Quantidade");
        lbQuantidade.setBounds(225, 40, 100, 25);
        pnPrincipal.add(lbQuantidade);

        tfNumero = new JTextField();
        tfNumero.setBounds(130, 10, 50, 25);
        pnPrincipal.add(tfNumero);

        tfTotal = new JTextField();
        tfTotal.setEditable(false);
        tfTotal.setBounds(375, 360, 100, 25);
        pnPrincipal.add(tfTotal);

        tfProduto = new JTextField();
        tfProduto.setBounds(15, 65, 200, 25);
        pnPrincipal.add(tfProduto);

        tfPrecoUnitario = new JTextField();
        tfPrecoUnitario.setBounds(310, 65, 80, 25);
        pnPrincipal.add(tfPrecoUnitario);

        tfQuantidade = new JTextField();
        tfQuantidade.setBounds(225, 65, 50, 25);
        pnPrincipal.add(tfQuantidade);

        btAdicionar = new JButton("Adicionar");
        btAdicionar.setToolTipText("Adicionar item ao pedido");
        btAdicionar.setBounds(15, 100, 100, 25);
        pnPrincipal.add(btAdicionar);

        btRemover = new JButton("Remover");
        btRemover.setToolTipText("Remover item do pedido");
        btRemover.setBounds(125, 100, 100, 25);
        pnPrincipal.add(btRemover);

        pnTabela = new JPanel(new BorderLayout());
        pnTabela.setBorder(new TitledBorder("Itens do Pedido"));
        pnTabela.setBounds(10, 130, 470, 230);
        pnPrincipal.add(pnTabela);

        String[] cabecalhoTabela = {"Produto", "Qtd", "Unit", "Total"};
        DefaultTableModel modeloTabela;
        modeloTabela = new DefaultTableModel(cabecalhoTabela, 0) {
            @Override
            public boolean isCellEditable(int linha, int coluna) {
                return coluna != 3;
            }
        };

        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.CENTER);

        tabela = new JTable(modeloTabela);

        tabela.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(0).setResizable(false);
        tabela.getColumnModel().getColumn(1).setResizable(false);
        tabela.getColumnModel().getColumn(2).setResizable(false);
        tabela.getColumnModel().getColumn(3).setResizable(false);
        tabela.getColumnModel().getColumn(0).setCellRenderer(esquerda);
        tabela.getColumnModel().getColumn(1).setCellRenderer(centro);
        tabela.getColumnModel().getColumn(2).setCellRenderer(centro);
        tabela.getColumnModel().getColumn(3).setCellRenderer(direita);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        spTabela = new JScrollPane(tabela);
        pnTabela.add(spTabela);
    }

    private void definirEventos() {
        btAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String produto = tfProduto.getText();
                String qtd = tfQuantidade.getText();
                String unit = tfPrecoUnitario.getText();
                String total = String.valueOf(real.format(Integer.parseInt(qtd) * Float.parseFloat(unit)));
                DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
                dtm.addRow(new Object[]{produto, qtd, unit, total});
                calcularTotal();
                limpar();
            }
        });
        btRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] linhasSelecionadas = tabela.getSelectedRows();
                DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
                for (int i = (linhasSelecionadas.length - 1); i >= 0; i--) {
                    dtm.removeRow(i);
                }
                calcularTotal();
            }
        });
    }

    private void calcularTotal() {
        float total = 0;
        for (int linha = 0; linha < tabela.getRowCount(); linha++) {
            String valor = String.valueOf(tabela.getValueAt(linha, 3));
            valor = valor.replace(".", "").replace(",", ".").replace("R$ ", "");
            total += Float.parseFloat(valor);
        }
        tfTotal.setText(String.valueOf(total));
    }

    private void limpar() {
        tfProduto.setText("");
        tfQuantidade.setText("");
        tfPrecoUnitario.setText("");
        tfProduto.requestFocus();
    }
    
}
