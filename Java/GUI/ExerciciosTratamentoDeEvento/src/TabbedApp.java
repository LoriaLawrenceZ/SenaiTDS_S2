import javax.swing.JTabbedPane;

//Importando tudo que está na pasta
import Exercicios.Exercicio1;

public class TabbedApp extends JTabbedPane {
    Exercicio1 ex1 = new Exercicio1();

    public TabbedApp() {
        super();
        this.add("Exercício 1", ex1);
    }
}