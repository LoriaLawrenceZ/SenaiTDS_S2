package View;

import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Home extends JPanel {
    //-----===| ATRIBUTOS |===-----//
    // Login
    JTextArea campoNome; // Campo Nome
    JTextArea campoSenha; // Campo Senha

    // Cadastro


    // Componentes a serem exibidos
    ArrayList<JComponent> componentes = new ArrayList<JComponent>(){
        {
            // Componentes da página home
            add(campoNome); // 1
            add(campoSenha); // 2
        }
    };


    //-----===| CONSTRUTOR |===-----//
    public Home() {
        super();

         // Configurando modelo de exibição
         for (int i = 0; i < 2; i++) { // Menor que 2 pois apenas os 2 primeiros itens correspondem a esta tela
            elemento.gridx = posicaoComponentes[i][0];
            elemento.gridy = posicaoComponentes[i][1];
            elemento.gridwidth = posicaoComponentes[i][2];
            elemento.gridheight = posicaoComponentes[i][3];
            elemento.weightx = posicaoComponentes[i][4];
            elemento.weighty = posicaoComponentes[i][5];
            elemento.insets = new Insets(posicaoComponentes[i][6], posicaoComponentes[i][7], posicaoComponentes[i][8], posicaoComponentes[i][9]);

            // Arrumando configuração de exibição
        }

        // Setando Layout
        this.setLayout(new GridBagLayout());
    }

    //-----===| MÉTODOS |===-----//
}
