package main.view;

import javax.swing.JTabbedPane;

public class TabbedApp extends JTabbedPane {
    PainelCarros painelCarros = new PainelCarros();

    public TabbedApp() {
        super();
        this.add("Carros", painelCarros);
    }
}
