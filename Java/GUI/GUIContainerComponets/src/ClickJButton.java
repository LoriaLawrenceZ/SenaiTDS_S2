import javax.swing.*;

public class ClickJButton extends JFrame {
    public ClickJButton() {
        super("Click");

        JPanel panel1 = new JPanel();
        
        // Criar os componentes do panel1
        JButton btn1 = new JButton("Clique aqui");
        panel1.add(btn1);
        
        JLabel label1 = new JLabel("Nº de cliques: ");
        panel1.add(label1);
        
        JLabel contador = new JLabel("0");
        panel1.add(contador);
        
        //Action do btn1
        btn1.addActionListener(event -> {
            int quantidade = Integer.parseInt(contador.getText());
            quantidade++;
            contador.setText(Integer.toString(quantidade));
            quantidade--;
            panel1.add(new JButton(""+ (quantidade+1)));

            this.pack();
        });

        // Colocar o getContentPane() depois da criação do panel e seus componentes
        this.getContentPane().add(panel1); // usar getContentPane ppois é como se "adicione o painel E seus componentes"

        // Setando Frame
        this.setDefaultCloseOperation(2);
        this.pack();
        this.setVisible(true);
    }
}
