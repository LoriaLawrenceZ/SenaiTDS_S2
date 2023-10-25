package View;

import javax.swing.JFrame;

public class FrameApp extends JFrame {
    public FrameApp() {
        super("Login/Cadastro");
            
        this.add(new Home());

        //Setando janela
        this.setBounds(550, 150, 400, 500);
        this.setDefaultCloseOperation(2);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
