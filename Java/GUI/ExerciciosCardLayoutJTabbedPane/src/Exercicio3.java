import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Exercicio3 extends JPanel {
    // Criando componentes 
    //Declarando CardLayout
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel();

    // ArrayLista dos componentes a serem exibidos
    // ArrayList dos Textos
    ArrayList<JTextArea> componentesVisuais = new ArrayList<JTextArea>(){
        {
            add(new JTextArea("Empresa"));
            add(new JTextArea("Motivos do por que essa empresa é legal e por que vc tem qe se cadastrar ou fazer login"));
        }
    };
    // ArrayList dos botões
    ArrayList<JButton> componentesBotoes = new ArrayList<JButton>(){
        {
            add(new JButton("LOGIN"));
            add(new JButton("CADASTRO"));
        }
    };
    //Chamando classe Insets
    Insets insets;

    public Exercicio3() {
        super();

        // Setando layout do Painel (Exercicio3)
        this.setLayout(cardLayout);
        //Setando layout do Painel que contém todas as telas
        cardPanel.setLayout(new CardLayout());
        //Adicionando Painel das telas ao painel principal
        this.add(cardPanel);

        //Criando as telas
        JPanel home = criarHome();
        JPanel login = new JPanel();
        JPanel cadastro = new JPanel();

        //Adicionando telas ao painel das telas
        cardPanel.add(home, "HOME");
    }

    //Função pra criar Home
    private JPanel criarHome(){
        JPanel tela1 = new JPanel();

        //Setando Background
        tela1.setBackground(Color.DARK_GRAY);

        //Configurando Painel 1
        GridBagConstraints elemento = new GridBagConstraints(); // variavel de controle de exibição de cada elemento

        // Declarando valores de cada item
        //Valores dos Visuais
        int[][] posicaoComponentesVisuais = {
            {0, 0, 1, 2, 2, 1, 5, 5, 5, 5},
            {0, 1, 1, 4, 2, 1, 5, 5, 5, 5},
        };
        //Valores dos botões
        int[][] posicaoComponentesBotoes = {
            {0, 2, 1, 1, 1, 1, 5, 5, 5, 5},
            {1, 2, 1, 1, 1, 1, 5, 5, 5, 5}
        };

        //Configurando cada item do Painel (Exercicio 3)
        //Configurando os Componentes Visuais
        for(int i = 0; i < componentesVisuais.size(); i++){
            elemento.gridx = posicaoComponentesVisuais[i][0];
            elemento.gridy = posicaoComponentesVisuais[i][1];
            elemento.gridwidth = posicaoComponentesVisuais[i][2];
            elemento.gridheight = posicaoComponentesVisuais[i][3];
            elemento.weightx = posicaoComponentesVisuais[i][4];
            elemento.weighty = posicaoComponentesVisuais[i][5];
            elemento.insets = new Insets(posicaoComponentesVisuais[i][6], posicaoComponentesVisuais[i][7], posicaoComponentesVisuais[i][8], posicaoComponentesVisuais[i][9]);

            //Adicionando ao painel depois de configurar
            tela1.add(componentesVisuais.get(i), elemento);
        }
        //Configurando os Componentes Botoes
        for(int i = 0; i < componentesBotoes.size(); i++){
            elemento.gridx = posicaoComponentesBotoes[i][0];
            elemento.gridy = posicaoComponentesBotoes[i][1];
            elemento.gridwidth = posicaoComponentesBotoes[i][2];
            elemento.gridheight = posicaoComponentesBotoes[i][3];
            elemento.weightx = posicaoComponentesBotoes[i][4];
            elemento.weighty = posicaoComponentesBotoes[i][5];
            elemento.insets = new Insets(posicaoComponentesBotoes[i][6], posicaoComponentesBotoes[i][7], posicaoComponentesBotoes[i][8], posicaoComponentesBotoes[i][9]);

            JButton botao = componentesBotoes.get(i);
            botao.setBackground(Color.GREEN);

            //Adicionando ao painel depois de configurar
            tela1.add(componentesBotoes.get(i), elemento);
        }

        return tela1;
    }
}




// Crie um aplicativo Java que use um CardLayout para implementar uma espécie de "navegação". Crie uma tela inicial com botões que levam a diferentes telas usando o CardLayout. Por exemplo, você pode criar uma tela de login, uma tela de registro e uma tela principal. Os botões na tela inicial devem permitir ao usuário navegar entre essas telas.
