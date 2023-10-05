package Exercicios;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Exercicio1 extends JPanel {
    // Criando Componentes
    private JOptionPane popUp; //Pop-Up
    private JButton botao = new JButton("Pop-Up"); //Botão para abrir Pop-Up

    // Contrutor
    public Exercicio1() {
        super();

        this.add(botao); //Adicionando Botão ao Painel

        //Abrir pop-up ao clicar no botão
        botao.addActionListener(e -> { //Listener do botão
            popUp = new JOptionPane("Olá");
        });
    }
}
