package View;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {
    //-----===| CONSTRUTOR |===-----//
    public MainFrame() {
        JTabbedPane abas = new JTabbedPane();
        abas.add("Cadastro de Usuáarios", new CadastroUsuarios());
        abas.add("Agendamentos", new Agendamentos());
        // Adicionando abas ao JFrame
        this.add(abas);
    }

    //---=| Rodar Aplicação |=---//
    public void run(){
        //---=| Setando o Frame |=---//
        this.setTitle("Aplicação");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        this.pack();
    }
}
