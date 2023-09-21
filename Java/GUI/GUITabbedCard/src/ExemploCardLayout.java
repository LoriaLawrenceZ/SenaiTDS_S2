import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExemploCardLayout extends JFrame {
    //Criando os componentes
    CardLayout cardLayout = new CardLayout(); //Criando o layout CardLayout
    JPanel panel1; //Painel principal

    JComboBox<String> comboBox; //ComboBox (Layout de "Contâiners")
    JPanel cards; //Painel eu vai conter os cards

    JPanel card1; //Painel do card1
    JPanel card2; //Painel do card2

    Handler handler = new Handler(); //Criando um objeto para gerenciar as ações (tipo um actionListener)

    public ExemploCardLayout() {
        super("Exemplo CardLayout");

        panel1 = new JPanel();

        String comboBoxItens[] = {"Card 1", "Card 2"}; //Texto dos itens listados no combobox (Cada string é um item)
        comboBox = new JComboBox<String>(comboBoxItens); //Adicionando a lista (que seão itens) como parâmetro

        panel1.add(comboBox);

        // Criando CARD1
        card1 = new JPanel();
        card1.add(new JButton("Botão 1"));
        card1.add(new JButton("Botão 2"));
        card1.add(new JButton("Botão 3"));

        // Criando CARD2
        card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));

        // Adicionando ao PAINEL que vai CONTER os CARDS (card1, card2)
        cards = new JPanel(cardLayout);
        cards.add(card1, "Card 1"); //Adicionando card1
        cards.add(card2, "Card 2"); //Adicionando card2

        //Adicionando os itens ao JFRAME
        this.add(panel1);

        // Setando ação para quando ComboBox for utilizado
        comboBox.addItemListener(handler);

        // Setando o JFRAME
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);
    }

    // Arrumando Handler para suprir minhas necessidades
    // Handler é quem vai gerenciar oq acontece quando actionListener for acionado
    public class Handler implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            cardLayout.show(cards, (String) event.getItem());
        }
    }
}
