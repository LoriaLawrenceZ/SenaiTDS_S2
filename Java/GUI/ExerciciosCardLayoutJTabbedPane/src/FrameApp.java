import javax.swing.JFrame;

public class FrameApp extends JFrame {
    public FrameApp() {
        super("S2-POO-SA3");
        
        this.add(new TabbedPane());

        //Setando janela
        this.setBounds(550, 150, 400, 500);
        this.setDefaultCloseOperation(2);
        this.setVisible(true);
    }
}