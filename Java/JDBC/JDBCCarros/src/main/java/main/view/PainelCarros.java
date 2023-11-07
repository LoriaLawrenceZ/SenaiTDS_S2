package main.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import main.control.CarrosDAO;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import main.model.Carro;

public class PainelCarros extends JPanel {
    // Atributos(componentes)
    private JButton cadastrar, apagar, editar;
    private JTextField carPlacaField, carAnoField, carMarcaField, carModeloField, carCorField, carPrecoField;
    private List<Carro> carros;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Construtor(GUI-JPanel)
    public PainelCarros() {
        super();

        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Carros"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Placa"));
        carPlacaField = new JTextField(20);
        inputPanel.add(carPlacaField);
        inputPanel.add(new JLabel("Ano"));
        carAnoField = new JTextField(20);
        inputPanel.add(carAnoField);
        inputPanel.add(new JLabel("Marca"));
        carMarcaField = new JTextField(20);
        inputPanel.add(carMarcaField);
        inputPanel.add(new JLabel("Modelo"));
        carModeloField = new JTextField(20);
        inputPanel.add(carModeloField);
        inputPanel.add(new JLabel("Cor"));
        carCorField = new JTextField(20);
        inputPanel.add(carCorField);
        inputPanel.add(new JLabel("Preço"));
        carPrecoField = new JTextField(20);
        inputPanel.add(carPrecoField);
        add(inputPanel);
        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(editar = new JButton("Editar"));
        botoes.add(apagar = new JButton("Apagar"));

        add(botoes);
        // tabela de carros
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Placa", "Ano", "Marca", "Modelo", "Cor", "Preço" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        new CarrosDAO();

        atualizarTabela();

        System.out.println("msg 8");

        // botoes de eventos
        // tratamento de Eventos
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    carPlacaField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    carAnoField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    carMarcaField.setText(table.getValueAt(linhaSelecionada, 2).toString());
                    carModeloField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    carCorField.setText(table.getValueAt(linhaSelecionada, 2).toString());
                    carPrecoField.setText(table.getValueAt(linhaSelecionada, 2).toString());
                }
            }
        });
    }

    private void atualizarTabela() {
        try {
            tableModel.setRowCount(0);
            carros = new CarrosDAO().read();
            System.out.println("msg 6");
            Object linha[] = new Object[6];
            for(int i=0;i<carros.size();i++){
                linha[0] = carros.get(i).getPlaca();
                linha[1] = carros.get(i).getAno();
                linha[2] = carros.get(i).getMarca();
                linha[3] = carros.get(i).getModelo();
                linha[4] = carros.get(i).getCor();
                linha[5] = carros.get(i).getPreco();
                tableModel.addRow(linha);
            }
            System.out.println("msg 7");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}