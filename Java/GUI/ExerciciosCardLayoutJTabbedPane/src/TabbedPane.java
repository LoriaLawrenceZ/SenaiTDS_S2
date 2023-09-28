import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane {
    public TabbedPane() {
        super();
        this.add("Exercício 1",new Exercicio1());
        this.add("Exercício 3",new Exercicio3());
    }
}