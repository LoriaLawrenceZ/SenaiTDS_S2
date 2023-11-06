package main.view;

import javax.swing.JFrame;

public class FrameApp extends JFrame {
    public FrameApp() {
        super("Carros");

        this.add(new TabbedApp());

        //Setando janela
        this.setBounds(550, 250, 800, 500);
        this.setDefaultCloseOperation(2);
        this.setVisible(true);
    }
}
