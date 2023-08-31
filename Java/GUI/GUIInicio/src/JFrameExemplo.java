import javax.swing.JFrame;

public class JFrameExemplo extends JFrame {
    public JFrameExemplo() {
        super("Minha Primeira Janela GUI Swing");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(700, 250, 500, 500);
    }
}
