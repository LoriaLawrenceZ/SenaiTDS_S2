import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Exercicio1 extends JPanel{
    public Exercicio1() {
        super();

        // set layout - card layout
        CardLayout cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        // criando os botões
        JButton button1 = new JButton("Next");
        JButton button2 = new JButton("Next");
        JButton button3 = new JButton("Next");

        //agora vamos criar cards para adicionar ao painel principal
        JPanel card1 = new JPanel();
        card1.add(new JLabel("Card 1"));
        card1.add(button1);

        JPanel card2 = new JPanel();
        card2.add(new JLabel("Card 2"));
        card2.add(button2);

        JPanel card3 = new JPanel();
        card3.add(new JLabel("Card 3"));
        card3.add(button3);

        // adicionar os cards criados ao painel principal
        this.add(card1);
        this.add(card2);
        this.add(card3);

        // adicionando ações para o botão
        button1.addActionListener(e->{
            cardLayout.next(this);
        });
        button2.addActionListener(e->{
            cardLayout.next(this);
        });
        button3.addActionListener(e->{
            cardLayout.next(this);
        });
    }
}
