package Exercicios;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Exercicio2 extends JPanel {
    // -----===ATRIBUTOS===-----//
    // COMPONENTES a serem EXIBIDOS
    ArrayList<JComponent> componentes = new ArrayList<JComponent>() {
        {
            add(new JLabel("Digite aqui:")); // Label para instruir o usuário
            add(new JTextField()); // Área para o usuário digitar

            add(new JLabel("Resultado esperado:")); // Label para instruir o usuário
            add(new JTextField()); // Output esperado
        }
    };

    // Construtor
    public Exercicio2() {
        super();

        // Setando Layout do Painel (Exercicio2)
        this.setLayout(new GridLayout(4, 1));

        // Inserindo componentes no Painel
        for (int i = 0; i < componentes.size(); i++) {
            this.add(componentes.get(i));

            JTextField inputUsuario = (JTextField) componentes.get(1);
            JTextField output = (JTextField) componentes.get(3);

            inputUsuario.addKeyListener(new KeyListener() { // Listener para cada tecla
                // Não vão ser utilizados
                @Override
                public void keyTyped(KeyEvent e) {}
                @Override
                public void keyPressed(KeyEvent e) {}

                @Override
                public void keyReleased(KeyEvent e) {
                    output.setText(inputUsuario.getText()); //Copiando e colando o texto
                }
            });
        }
    }
}
