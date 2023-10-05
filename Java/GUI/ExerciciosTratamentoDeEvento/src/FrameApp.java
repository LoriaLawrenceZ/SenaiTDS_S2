import javax.swing.JFrame;

public class FrameApp extends JFrame {
    public FrameApp() {
        super("Exercícios - Tratamento de Evento");
        
        this.add(new TabbedApp());

        //Setando janela
        this.setBounds(550, 150, 400, 500);
        this.setDefaultCloseOperation(2);
        this.setVisible(true);
    }   
}
