package View;

import java.util.ArrayList;
import java.util.List;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Control.Serializacao;
import Model.Usuario;

public class CadastroUsuarios extends JFrame {
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
    JButton apagarTodosButton;
    JButton salvarButton;
    //-| Lista |-//
    private List<Usuario> usuarios = new ArrayList<>(); // Lista de Usuarios//
    //-| Tabela |-//
    private DefaultTableModel tableModel; // Contrução Lógica da tabela //
    private JTable table; // Construção visual da tabela //

    //-----===| CONTRUTOR |===-----//
    public CadastroUsuarios() {
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
        apagarTodosButton = new JButton("Apagar Todos"); // Botão 'Apagar Todos'
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
        inputPanel.add(apagarTodosButton);
        inputPanel.add(salvarButton);

        File arquivo = new File("dados.txt"); // Instanciando Objeto da classe 'File'
        // Verificar se existe este arquivo
        if (arquivo.exists()) {
            usuarios = Serializacao.deserializar("dados.txt");
            atualizarTabela();
        }

        //---=| Setando Layout |=---//
        this.setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);        
    }

    public void run(){
        //---=| Setando o Frame |=---//
        this.setVisible(true);
        this.setTitle("Cadastro de Usuários");
        this.setSize(600, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
    }
}
