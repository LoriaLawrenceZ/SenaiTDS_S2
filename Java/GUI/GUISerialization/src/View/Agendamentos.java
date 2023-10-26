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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Control.OperacoesUsuario;
import Control.Serializacao;
import Model.Usuario;

public class Agendamentos extends JPanel {
    //-----===| ATRIBUTOS |===-----//
    //-| Comum |-//
    private int linhaSelecionada = -1; // Int pra pegar linha selecionada//
    //-| Campos |-//
    private JTextField inputNome; // Campo para inserir 'nome' //
    private JTextField inputIdade; // Campo para inserir 'idade' //
    //-| Botões |-//
    JButton cadastrarButton;
    JButton atualizarButton;
    JButton apagarButton;
    JButton salvarButton;
    //-| Lista |-//
    private List<Usuario> usuarios = new ArrayList<>(); // Lista de //
    //-| Tabela |-//
    private DefaultTableModel tableModel; // Contrução Lógica da tabela //
    private JTable table; // Construção visual da tabela //
    
    //-----===| CONSTRUTOR |===-----//
    public Agendamentos() {
        //---=| Tabela |=---//
        tableModel = new DefaultTableModel(); // Instanciando objeto DefaultTableModel
        tableModel.addColumn("Nome"); // Adicionando coluna 'Nome'
        tableModel.addColumn("Idade"); // Adicionando coluna 'Idade'
        table = new JTable(tableModel); // Tabela baseada no 'tableModel' (lógica da tabela)
        JScrollPane scrollPane = new JScrollPane(table); // JScrollPanel para a 'table'

        //---=| Criar Componentes |=---//
        inputNome = new JTextField(20);
        inputIdade = new JTextField(5);
        cadastrarButton = new JButton("Cadastrar"); // Botão 'Cadastrar'
        atualizarButton = new JButton("Atualizar"); // Botão 'Atualizar'
        apagarButton = new JButton("Apagar"); // Botão 'Apagar'
        salvarButton = new JButton("Salvar"); // Botão 'Salvar'

        //---=| Adicionar Componentes ao Painel Principal |=---//
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(inputNome);
        inputPanel.add(new JLabel("Idade:"));
        inputPanel.add(inputIdade);
        inputPanel.add(cadastrarButton);
        inputPanel.add(atualizarButton);
        inputPanel.add(apagarButton);
        inputPanel.add(salvarButton);

        //---=| Criação do Arquivo Binário |=---//
        File arquivo = new File("dados.txt"); // Instanciando Objeto da classe 'File'
        // Verificar se existe este arquivo
        if (arquivo.exists()) {
            usuarios = Serializacao.deserializar("dados.txt"); // Cria o arquivo
            atualizarTabela();
        }

        //---=| Tratamento de Evento |=---//
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    inputNome.setText((String) table.getValueAt(linhaSelecionada, 0));
                    inputIdade.setText(table.getValueAt(linhaSelecionada, 1).toString());
                }
            }
        });

        OperacoesUsuario operacoes = new OperacoesUsuario(usuarios, tableModel, table);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.cadastrarUsuario(inputNome.getText(), inputIdade.getText());
                inputNome.setText("");
                inputIdade.setText("");
            }
        });
        
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.atualizarUsuario(linhaSelecionada, inputNome.getText(),
                inputIdade.getText());
            }
        });

        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarUsuario(linhaSelecionada);
            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.salvarUsuarios();
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

        for (Usuario usuario : usuarios) { // Adicionar itens através do loop 'For'
            tableModel.addRow(new Object[] { usuario.getNome(), usuario.getIdade() }); // Adicionando Item atual da Lista dentro da Tabela
        }
    }
}
