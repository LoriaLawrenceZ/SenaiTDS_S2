import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Exercicio5 extends JPanel {
    // -----===Criação dos itens Necessários===-----//
    // Criando componentes
    private CardLayout cardLayout = new CardLayout(); // Declarando CardLayout
    private JPanel cardPanel = new JPanel(); // Declarando JPanel que vai guardar os outros paineis

    // ArrayList dos componentes a serem exibidos
    ArrayList<JComponent> componentes = new ArrayList<JComponent>() {
        {
            // Componetes da PÁGINA HOME
            add(new JTextArea("JAHOOT!")); // Nome do jogo
            add(new JTextArea("Clique em qualquer lugar para começar")); // Aviso do jogo
        }
    };

    Insets insets; // Chamando insets para estlização do GridBagLayout

    // -----===Construtor===-----//
    public Exercicio5() {
        super();

        // Setando layout do Painel (Exercicio 5)
        this.setLayout(cardLayout);
        // Setando layout do Painel que contém todas as telas
        cardPanel.setLayout(new CardLayout());
        // Adicionando Painel de telas ao painel principal
        this.add(cardPanel);

        // Criando as telas
        JPanel home = criarHome();
        JPanel questao1 = criarQ1();

        // Adicionando telas ao Painel de telas
        cardPanel.add(home, "HOME");
        cardPanel.add(questao1, "QUESTÃO 1");
    }

    // -----===Método de criação da PÁGINA HOME===-----
    private JPanel criarHome() {
        JPanel telaHome = new JPanel();

        // Setando Layout
        telaHome.setLayout(new GridBagLayout());
        // Setando Background
        telaHome.setBackground(Color.DARK_GRAY);

        // Configurando Painel 1
        GridBagConstraints elemento = new GridBagConstraints(); // variavel de controle de exibição de cada elemento

        // Declarando valores de cada item
        int[][] posicaoComponentes = {
                { 0, 0, 1, 9, 1, 1, 10, 10, 10, 10 }, // Nome do Jogo
                { 0, 10, 1, 1, 1, 1, 10, 10, 10, 10 }, // Aviso
        };

        // Configurando modelo de exibição
        for (int i = 0; i < 2; i++) { // Menor que 2 pois apenas os 2 primeiros itens correspondem a esta tela
            elemento.gridx = posicaoComponentes[i][0];
            elemento.gridy = posicaoComponentes[i][1];
            elemento.gridwidth = posicaoComponentes[i][2];
            elemento.gridheight = posicaoComponentes[i][3];
            elemento.weightx = posicaoComponentes[i][4];
            elemento.weighty = posicaoComponentes[i][5];
            elemento.insets = new Insets(posicaoComponentes[i][6], posicaoComponentes[i][7], posicaoComponentes[i][8],
                    posicaoComponentes[i][9]);

            // Arruamndo configuração de exibição
            if (i == 0) {
                JTextArea texto = (JTextArea) componentes.get(0); // Transformando em JTextArea (pra não mexer como se
                                                                  // fosse JComponent)

                // Definindo a fonte
                Font font = new Font("Arial", Font.BOLD, 56);
                texto.setFont(font); // Setando a fonte no JTextArea
                texto.setBackground(Color.DARK_GRAY);
                texto.setForeground(Color.WHITE);// Setando cor do texto
                texto.setEditable(false);
                texto.setAlignmentX(Component.CENTER_ALIGNMENT);
            } else {
                JTextArea texto = (JTextArea) componentes.get(1); // Transformando em JTextArea (pra não mexer como se
                                                                  // fosse JComponent)

                // Definindo a fonte
                Font font = new Font("Arial", Font.PLAIN, 12);
                texto.setFont(font); // Setando a fonte no JTextArea
                texto.setBackground(Color.DARK_GRAY);
                texto.setForeground(Color.WHITE);// Setando cor do texto
                texto.setEditable(false);
                texto.setAlignmentX(Component.CENTER_ALIGNMENT);
            }

            telaHome.add(componentes.get(i), elemento);
        }

        // Handler para cliques na Janela
        HomeHandler homeHandler = new HomeHandler();
        telaHome.addMouseListener(homeHandler);

        return telaHome;
    }

    // Classe interna para tratamento dos Eventos da HOME
    public class HomeHandler implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            cardLayout.show(cardPanel, "QUESTÃO 1");
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    // -----===Método de criação da Página Questão 1===-----
    private JPanel criarQ1() {
        JPanel telaQ1 = new JPanel();
        return telaQ1;
    }
}

/*
 * 
 * Exercicio 5: Jogo com CardLayout
 * 
 * Desenvolva um jogo simples usando o CardLayout. Crie diferentes painéis para
 * representar as diferentes telas do jogo, como tela de título, tela de jogo e
 * tela de pontuação. Use o CardLayout para alternar entre essas telas à medida
 * que o jogador progride no jogo.
 * 
 */