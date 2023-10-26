package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Control.OperacoesAgendamento;
import Control.Serializacao;
import Model.Agenda;

public class Agendamentos extends JPanel {
    //-----===| ATRIBUTOS |===-----//
    //-| Comum |-//
    private int linhaSelecionada = -1; // Int pra pegar linha selecionada//
    //-| Campos |-//
    private JTextField inputData; // Campo para inserir 'data' //
    private JTextField inputHora; // Campo para inserir 'hora' //
    private JTextField inputUsuario; // Campo para inserir 'usuario' //
    private JTextField inputDescricao; // Campo para inserir 'descricao' //
    //-| Botões |-//
    JButton cadastrarButton;
    JButton atualizarButton;
    JButton apagarButton;
    JButton salvarButton;
    //-| ComboBox |-//
    private JComboBox comboBox;
    //-| Lista |-//
    private List<Agenda> agendados = new ArrayList<>(); // Lista de Agendamentos //
    //-| Tabela |-//
    private DefaultTableModel tableModel; // Contrução Lógica da tabela //
    private JTable table; // Construção visual da tabela //
    
    //-----===| CONSTRUTOR |===-----//
    public Agendamentos() {
        //---=| Tabela |=---//
        tableModel = new DefaultTableModel(); // Instanciando objeto DefaultTableModel
        tableModel.addColumn("data"); // Adicionando coluna 'Data'
        tableModel.addColumn("Hora"); // Adicionando coluna 'Hora'
        tableModel.addColumn("Usuário"); // Adicionando coluna 'Usuario'
        tableModel.addColumn("Descrição"); // Adicionando coluna 'Descricao'
        table = new JTable(tableModel); // Tabela baseada no 'tableModel' (lógica da tabela)
        JScrollPane scrollPane = new JScrollPane(table); // JScrollPanel para a 'table'

        //---=| Criar Componentes |=---//
        inputData = new JTextField(10);
        inputHora = new JTextField(5);
        inputUsuario = new JTextField(10);
        inputDescricao = new JTextField(10);
        cadastrarButton = new JButton("Cadastrar"); // Botão 'Cadastrar'
        atualizarButton = new JButton("Atualizar"); // Botão 'Atualizar'
        apagarButton = new JButton("Apagar"); // Botão 'Apagar'
        salvarButton = new JButton("Salvar"); // Botão 'Salvar'
        comboBox = new JComboBox();

        //---=| Adicionar Componentes ao Painel Principal |=---//
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Data:"));
        inputPanel.add(inputData);
        inputPanel.add(new JLabel("Hora:"));
        inputPanel.add(inputHora);
        inputPanel.add(new JLabel("Usuário:"));
        inputPanel.add(inputUsuario);
        inputPanel.add(new JLabel("Descrição:"));
        inputPanel.add(inputDescricao);
        inputPanel.add(cadastrarButton);
        inputPanel.add(atualizarButton);
        inputPanel.add(apagarButton);
        inputPanel.add(salvarButton);

        //---=| Criação do Arquivo Binário |=---//
        File arquivoAgendamentos = new File("agendamentos.txt"); // Instanciando Objeto da classe 'File'
        // Verificar se existe este arquivo
        if (arquivoAgendamentos.exists()) {
            agendados = Serializacao.deserializarAgendados("agendamentos.txt"); // Cria o arquivo
            atualizarTabela();
        }

        //---=| Tratamento de Evento |=---//
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    inputData.setText((String) table.getValueAt(linhaSelecionada, 0));
                    inputHora.setText((String) table.getValueAt(linhaSelecionada, 1));
                    inputUsuario.setText((String) table.getValueAt(linhaSelecionada, 2));
                    inputDescricao.setText((String) table.getValueAt(linhaSelecionada, 3));
                }
            }
        });

        OperacoesAgendamento operacoes = new OperacoesAgendamento(agendados, tableModel, table);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Checando se a data é válida
                if(operacoes.isValidDate(inputData.getText())){
                    operacoes.cadastrarAgendamento(inputData.getText(), inputHora.getText(), inputUsuario.getText(), inputDescricao.getText());
    
                    inputData.setText("");
                    inputHora.setText("");
                    inputUsuario.setText("");
                    inputDescricao.setText("");
                }
                else{
                    JOptionPane.showMessageDialog(null, "[DATA: DD/MM/AAAA]\n[HORA HH:II]");
                }
            }
        });
        
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.atualizarAgendamento(linhaSelecionada, inputData.getText(), inputHora.getText(), inputUsuario.getText(), inputDescricao.getText());
            }
        });

        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarAgendamento(linhaSelecionada);
            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.salvarAgendamento();
            }
        });

        //---=| Setando Layout |=---//
        this.setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    //-----===| MÉTODOS |===-----//
    //---=| Atualizar Tabela |=---//
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Voltar para a linha 0 pra adicionar corretamente (adicionar Lista dentro da Tabela)

        for (Agenda agenda : agendados) { // Adicionar itens através do loop 'For'
            tableModel.addRow(new Object[] { agenda.getData(), agenda.getHora(), agenda.getUsuario(), agenda.getDescricao() }); // Adicionando Item atual da Lista dentro da Tabela
        }
    }
}
