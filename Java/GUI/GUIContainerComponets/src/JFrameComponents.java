import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class JFrameComponents extends JFrame {
    public JFrameComponents() {
        super("Home Page");
        this.setBounds(710, 290, 500, 500); // TAMANHO E DISTANCIA

        // Setando Layout (modificou o Layout do Frame)
        FlowLayout flow = new FlowLayout();
        this.setLayout(flow);

        // Adicionar Componentes
        for(int i = 1; i < 101; i++){
            this.add(new JButton(""+ i));
        }

        // Set Frame
        this.setDefaultCloseOperation(2); // 2 = EXIT_ON_CLOSE
        this.setVisible(true);
    }
}
