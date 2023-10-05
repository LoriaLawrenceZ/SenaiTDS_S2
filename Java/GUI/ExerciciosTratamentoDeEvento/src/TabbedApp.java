import javax.swing.JTabbedPane;

//Importando tudo que está na pasta
import Exercicios.Exercicio1;
import Exercicios.Exercicio2;

public class TabbedApp extends JTabbedPane {
    Exercicio1 ex1 = new Exercicio1();
    Exercicio2 ex2 = new Exercicio2();

    public TabbedApp() {
        super();
        this.add("Exercício 1", ex1);
        this.add("Exercício 2", ex2);
    }
}