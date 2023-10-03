import javax.swing.JTabbedPane;

public class TabbedApp extends JTabbedPane {
    Exercicio1 ex1 = new Exercicio1();
    Exercicio3 ex3 = new Exercicio3();
    Exercicio5 ex5 = new Exercicio5();

    public TabbedApp() {
        super();
        this.add("Exercício 1", ex1);
        this.add("Exercício 3", ex3);
        this.add("Exercicio 5", ex5);
    }
}