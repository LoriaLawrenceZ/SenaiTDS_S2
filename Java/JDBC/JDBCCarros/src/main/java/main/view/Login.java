package main.view;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame {
    //-----===| ATRIBUTOS |===-----//
    // Criando componentes
    private CardLayout cardLayout = new CardLayout(); // Declarando CardLayout
    private JPanel mainPanel = new JPanel();

    //---=| Login/Cadastro |=---//
    // Título Login
    private JLabel tituloLogin = new JLabel("LOGIN");
    // Título Cadastro
    private JLabel tituloCadastro = new JLabel("CADASTRO");

    // User CPF
    private JLabel cpfLabel = new JLabel("Insira seu CPF:");
    private JTextField cpfInput = new JTextField(20);

    // User Nome
    private JLabel nomeLabel = new JLabel("Insira seu Nome:");
    private JTextField nomeInput = new JTextField(20);

    // User Telefone
    private JLabel telefoneLabel = new JLabel("Insira seu Telefone:");
    private JTextField telefoneInput = new JTextField(20);

    // User Rua
    private JLabel ruaLabel = new JLabel("Insira sua Rua:");
    private JTextField ruaInput = new JTextField(20);

    // User Número
    private JLabel numeroLabel = new JLabel("Insira seu Número:");
    private JTextField numeroInput = new JTextField(20);

    // User CEP
    private JLabel cepLabel = new JLabel("Insira seu CEP:");
    private JTextField cepInput = new JTextField(20);

    // User Senha
    private JLabel senhaLabel = new JLabel("Insira sua Senha:");
    private JTextField senhaInput = new JTextField(20);

    // User Funcionario
    private JLabel funcionarioLabel = new JLabel("Voce é Funcionário?");
    private JCheckBox funcionarioInput = new JCheckBox();

    // Botão Fazer Cadastro/Fazer Login
    private JButton botaoTrocar = new JButton("Trocar");
    // Botão Entrar/Criar
    private JButton botaoAcessar = new JButton("Acessar");

    // ArrayList dos componentes a serem exibidos
    ArrayList<JComponent> componentes = new ArrayList<JComponent>() {
        {
            // Títulos
            add(tituloLogin); // Título da página de login
            add(tituloCadastro); // Título da página de cadastro
            // Componetes da página de login (e cadastro)
            add(cpfLabel); // label CPF
            add(cpfInput); // input CPF
            add(senhaLabel); // label Senha
            add(senhaInput); // input Senha
            // Componentes da página de cadastro
            add(nomeLabel); // label Nome
            add(nomeInput); // input Nome
            add(telefoneLabel); // label Telefone
            add(telefoneInput); // input Telefone
            add(ruaLabel); // label Rua
            add(ruaInput); // input Rua
            add(numeroLabel); // label Número
            add(numeroInput); // input Número
            add(cepLabel); // label CEP
            add(cepInput); // input CEP
            add(funcionarioLabel); // label Funcionário
            add(funcionarioInput); // input Funcionário
            // Botões que estarão na página de Login E Cadastro
            add(botaoTrocar); // Botão para trocar o meio de acesso
            add(botaoAcessar); // Botão para efetuar o login/cadastro
        }
    };
    
    Insets insets; // Chamando insets para estlização do GridBagLayout

    //-----===| CONSTRUTOR |===-----//
    public Login() {
        super();

        // Adicionando mainPanel ao JFrame
        this.add(mainPanel);
        // Setando layout
        mainPanel.setLayout(cardLayout);

        // Criando as telas
        JPanel login = criarLogin();
        JPanel cadastro = criarCadastro();

        //Adicionando telas ao Painel de telas
        mainPanel.add(login, "LOGIN");
        mainPanel.add(cadastro, "CADASTRO");
    }

    //-----===| MÉTODOS |===-----//
    //---=| Página Login |=---//
    private JPanel criarLogin(){
        JPanel telaLogin = new JPanel();
        // Setando Layout
        telaLogin.setLayout(new GridBagLayout());
        // Setando Background
        // telaLogin.setBackground(Color.DARK_GRAY);

        // Configurando Painel
        GridBagConstraints elemento = new GridBagConstraints(); // Váriavel de cntrole de exibição de cada elemento

        // Declarando os itens a serem utilizados (sua posição no ArrayList)
        int[] posicaoNoArray = {
            0, // Título
            2, // CPF
            3, // CPF
            4, // Senha
            5, // Senha
            18, 19 // Botões
        };
        // Declarando valores de cada item
        int[][] posicaoComponentes = {
            { 0, 0, 2, 1, 2, 1, 3, 3, 3, 3 }, // Título login
            { 0, 3, 2, 1, 2, 1, 3, 3, 3, 3 }, // cpf label
            { 0, 4, 2, 1, 2, 1, 3, 3, 3, 3 }, // cpf input
            { 0, 5, 2, 1, 2, 1, 3, 3, 3, 3 }, // senha label
            { 0, 6, 2, 1, 2, 1, 3, 3, 3, 3 }, // senha input
            { 0, 7, 1, 1, 1, 1, 3, 3, 3, 3 }, // botão trocar
            { 1, 7, 1, 1, 1, 1, 3, 3, 3, 3 }, // botão acessar
        };

        // Configurand modelo de exibição
        for(int i = 0; i < 7; i++){ // Menor que 7 pois 7 é a quantidade de item da janela
            elemento.gridx = posicaoComponentes[i][0];
            elemento.gridy = posicaoComponentes[i][1];
            elemento.gridwidth = posicaoComponentes[i][2];
            elemento.gridheight = posicaoComponentes[i][3];
            elemento.weightx = posicaoComponentes[i][4];
            elemento.weighty = posicaoComponentes[i][5];
            elemento.insets = new Insets(posicaoComponentes[i][6], posicaoComponentes[i][7], posicaoComponentes[i][8], posicaoComponentes[i][9]);

            telaLogin.add(componentes.get(posicaoNoArray[i]), elemento);
        }

        // Handler para cliques nos botões
        botaoTrocar.addActionListener(e -> { // Listener do botão
            cardLayout.next(mainPanel);
        });

        return telaLogin;
    }

    //---=| Página Cadastro |=---//
    private JPanel criarCadastro(){
        JPanel telaCadastro = new JPanel();
        // Setando Layout
        telaCadastro.setLayout(new GridBagLayout());
        // Setando Background
        //telaCadastro.setBackground(Color.DARK_GRAY);

        // Configurando Painel
        GridBagConstraints elemento = new GridBagConstraints(); // Váriavel de cntrole de exibição de cada elemento

        // Declarando os itens a serem utilizados (sua posição no ArrayList)
        int[] posicaoNoArray = {
            1, // Título
            2, 3, // CPF
            6, 7, // Nome
            8, 9, // Telefone
            10, 11, // Rua
            12, 13, // Número
            14, 15, // CEP
            16, 17, // Funcionário
            4, 5, // Senha
            18, 19 // Botões
        };
        // Declarando valores de cada item
        int[][] posicaoComponentes = {
            { 0, 0, 2, 3, 2, 3, 3, 3, 3, 3 }, // Título Cadastro
            { 0, 3, 1, 1, 1, 1, 3, 3, 3, 3 }, // cpf label
            { 1, 3, 1, 1, 1, 1, 3, 3, 3, 3 }, // cpf input
            { 0, 4, 1, 1, 1, 1, 3, 3, 3, 3 }, // nome label
            { 1, 4, 1, 1, 1, 1, 3, 3, 3, 3 }, // nome input
            { 0, 5, 1, 1, 1, 1, 3, 3, 3, 3 }, // telefone label
            { 1, 5, 1, 1, 1, 1, 3, 3, 3, 3 }, // telefone input
            { 0, 6, 1, 1, 1, 1, 3, 3, 3, 3 }, // rua label
            { 1, 6, 1, 1, 1, 1, 3, 3, 3, 3 }, // rua input
            { 0, 7, 1, 1, 1, 1, 3, 3, 3, 3 }, // numero label
            { 1, 7, 1, 1, 1, 1, 3, 3, 3, 3 }, // numero input
            { 0, 8, 1, 1, 1, 1, 3, 3, 3, 3 }, // cep label
            { 1, 8, 1, 1, 1, 1, 3, 3, 3, 3 }, // cep input
            { 0, 9, 1, 1, 1, 1, 3, 3, 3, 3 }, // funcionario label
            { 1, 9, 1, 1, 1, 1, 3, 3, 3, 3 }, // funcionario input
            { 0, 10, 1, 1, 1, 1, 3, 3, 3, 3 }, // senha label
            { 1, 10, 1, 1, 1, 1, 3, 3, 3, 3 }, // senha input
            { 0, 11, 1, 1, 1, 1, 3, 3, 3, 3 }, // botão trocar
            { 1, 11, 1, 1, 1, 1, 3, 3, 3, 3 }, // botão acessar
        };

        // Configurand modelo de exibição
        for(int i = 0; i < 7; i++){ // Menor que 7 pois 7 é a quantidade de item da janela
            elemento.gridx = posicaoComponentes[i][0];
            elemento.gridy = posicaoComponentes[i][1];
            elemento.gridwidth = posicaoComponentes[i][2];
            elemento.gridheight = posicaoComponentes[i][3];
            elemento.weightx = posicaoComponentes[i][4];
            elemento.weighty = posicaoComponentes[i][5];
            elemento.insets = new Insets(posicaoComponentes[i][6], posicaoComponentes[i][7], posicaoComponentes[i][8], posicaoComponentes[i][9]);

            telaCadastro.add(componentes.get(posicaoNoArray[i]), elemento);
        }

        // Handler para cliques nos botões
        botaoTrocar.addActionListener(e -> { // Listener do botão
            cardLayout.next(mainPanel);
        });

        return telaCadastro;
    }

    //---=| Rodar Aplicação |=---//
    public void run(){
        //---=| Setando o Frame |=---//
        this.setTitle("Validação");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
    }
}
