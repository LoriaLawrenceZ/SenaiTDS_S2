package View;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Home extends JFrame {
    //-----===| ATRIBUTOS |===-----//

    //-----===| CONSTRUTOR |===-----//
    public Home() {
        super("HOME");

        // Setando Layout
        this.setLayout(new GridBagLayout());
        
        // Painel Principal
        JPanel mainPanel = new JPanel();
        this.add(mainPanel);
    }

    //-----===| MÉTODOS |===-----//
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
