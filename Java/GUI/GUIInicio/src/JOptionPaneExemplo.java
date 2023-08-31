import javax.swing.JOptionPane;

public class JOptionPaneExemplo extends JOptionPane {
    // Atributos
    String informacao = "Minha Dialog JOptionPane";

    // Métodos
    public JOptionPaneExemplo(){
        super();
        this.showMessageDialog(getComponentPopupMenu(), informacao, informacao, 1);
    }
}
