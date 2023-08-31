import javax.swing.*;

public class ContainerComponentes extends JFrame{
    // Atributos
    private JPanel panel1;
    private JTextField input1;
    private JButton btn1;

    public ContainerComponentes() {
        super("Janela Principal");

        // Adicionar outro Container
        panel1 = new JPanel();
        
        // Adicionar componentes ao Painel
        panel1.add(new JLabel("Informe um número"));
        
        input1 = new JTextField(25);
        panel1.add(input1);
        
        btn1 = new JButton("Enviar");
        panel1.add(btn1);

        // Colocar o getContentPane() depois da criação do panel e seus componentes
        this.getContentPane().add(panel1); // Adicionando "painel1" (objeto da classe JPanel - container mais simples que o JFrame -) ao Frame

        //Usar um Listener para o btn1
        btn1.addActionListener(event ->{
            int quantidade = Integer.parseInt(input1.getText());

            for(int i = 0; i < quantidade; i++){
                panel1.add(new JButton(""+ (i+1)));
            }

            this.pack(); // Readequa o tamanho após o feito
        });

        // Setando Frame
        this.setDefaultCloseOperation(2);
        this.pack(); // Compacta a janela para o tamanho necessário para caber os componentes
        this.setVisible(true);
    }
}