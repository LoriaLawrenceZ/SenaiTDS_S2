import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Exercicio3 extends JPanel {
    // Criando componentes 
    //Declarando CardLayout
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel();

    // ArrayLista dos componentes a serem exibidos
    // ArrayList dos Textos
    ArrayList<JComponent> componentes = new ArrayList<JComponent>(){
        {
            add(new JTextArea("Empresa"));
            add(new JTextArea("Motivos do por que essa empresa é legal e por que vc tem qe se cadastrar ou fazer login"));
        
            //Botões
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
        cardPanel.add(login, "LOGIN");
        cardPanel.add(cadastro, "CADASTRO");
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
        int[][] posicaoComponentes = {
            {0, 0, 1, 1, 1, 1, 0, 0, 5, 5}, // Texto 1
            {0, 1, 1, 1, 1, 1, 0, 0, 5, 5}, // Texto 2
            {0, 2, 1, 1, 1, 1, 0, 0, 5, 5}, // Botão LOGIN
            {1, 2, 1, 1, 1, 1, 0, 0, 5, 5}, // Botão CADASTRO
        };

        //Configurando cada item do Painel (Exercicio 3)
        //Configurando os Componentes Visuais
        for(int i = 0; i < componentes.size(); i++){
            elemento.gridx = posicaoComponentes[i][0];
            elemento.gridy = posicaoComponentes[i][1];
            elemento.gridwidth = posicaoComponentes[i][2];
            elemento.gridheight = posicaoComponentes[i][3];
            elemento.weightx = posicaoComponentes[i][4];
            elemento.weighty = posicaoComponentes[i][5];
            elemento.insets = new Insets(posicaoComponentes[i][6], posicaoComponentes[i][7], posicaoComponentes[i][8], posicaoComponentes[i][9]);

            JComponent componente = componentes.get(i);
            //Configurando JTextArea
            if(i == 1){
                JTextArea texto = (JTextArea) componentes.get(i);
                texto.setLineWrap(true);

                elemento.fill = GridBagConstraints.HORIZONTAL;
            }
            else if(i == 2 || i == 3){
                JButton botao = (JButton) componentes.get(i);
                botao.setBackground(Color.GREEN);
            }
            
            //Adicionando ao painel depois de configurar
            tela1.add(componente, elemento);
        }

        return tela1;
    }
}




// Crie um aplicativo Java que use um CardLayout para implementar uma espécie de "navegação". Crie uma tela inicial com botões que levam a diferentes telas usando o CardLayout. Por exemplo, você pode criar uma tela de login, uma tela de registro e uma tela principal. Os botões na tela inicial devem permitir ao usuário navegar entre essas telas.
