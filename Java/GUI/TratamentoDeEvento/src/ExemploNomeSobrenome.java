import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ExemploNomeSobrenome extends JFrame {
    // Criando Componentes
    private ArrayList<JComponent> componentes = new ArrayList<JComponent>(){
        {
            // Primeira Linha (nome: )
            add(new JLabel("Nome: "));
            add(new JTextField());

            // Segunda Linha (sobrenome: )
            add(new JLabel("Sobrenome: "));
            add(new JTextField());

            // Terceira Linha (Concatenar: )
            add(new JButton("Concatenar: "));
            add(new JLabel());
        }
    };

    //Construtor
    public ExemploNomeSobrenome() {
        super("Exemplo Nome Sobrenome");
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 150);
        
        //Setando layout para o Painel Principal
        JPanel mainPanel = new JPanel(new GridLayout(3, 2));
        this.add(mainPanel); //Adicionando mainPanel ao Frame

        for (int i = 0; i < componentes.size(); i++) {
            mainPanel.add(componentes.get(i)); // Adicionando componente ao Painel Principal

            if(i == 4){
                // Chamando os componentes necessários
                // JTextField nomeTextField = (JTextField) componentes.get(1); // Campo Nome
                // JTextField sobrenomeTextField = (JTextField) componentes.get(3); // Campo Sobrenome
                JButton botao = (JButton) componentes.get(4); //Botão
                // JLabel resultado = (JLabel) componentes.get(5); //Resultado

                //-----=== 3 Formas de Tratar Eventos ===-----//
                /*
                * 1° - Callback (só funciona nos Tratamentos de Evento que contém APENAS 1 MÉTODO)
                * 
                * 2° - Chamando a Classe ["new ActionListener" -> actionPerformed(ActionEvent)]
                *
                * 3° - Handler
                */

                //---==Exemplo CALLBACK==---//
                /*
                * botao.addActionListener( e -> { //Listener
                *     //Evento
                *     resultado.setText(nomeTextField.getText() +" "+ sobrenomeTextField.getText()); //Exibindo o nome completo
                *
                *     // Limpando os campos
                *     nomeTextField.setText("");
                *     sobrenomeTextField.setText("");
                * });
                */

                //---==Exemplo 2° FORMA==---//
                /*
                * 
                * botao.addActionListener( new ActionListener(){ //Listener
                *     public void actionPerformed(ActionEvent e){
                *         //Evento
                *         resultado.setText(nomeTextField.getText() +" "+ sobrenomeTextField.getText()); //Exibindo o nome completo
                *
                *         // Limpando os campos
                *         nomeTextField.setText("");
                *         sobrenomeTextField.setText("");
                *     }
                * });
                */

                //---==Exemplo HANDLER==---//
                /*
                 * Handler handler = new Handler();
                 * botao.addActionListener(handler);
                */
                Handler handler = new Handler();
                botao.addActionListener(handler);
            }
        }
    }

    // Criando a Classe HANDLER para tratar Evento
    public class Handler implements ActionListener { // Implementa o tipo de tratamento que for necessário
        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField nomeTextField = (JTextField) componentes.get(1); // Campo Nome
            JTextField sobrenomeTextField = (JTextField) componentes.get(3); // Campo Sobrenome
            JLabel resultado = (JLabel) componentes.get(5); //Resultado

            //Evento
            resultado.setText(nomeTextField.getText() +" "+ sobrenomeTextField.getText()); //Exibindo o nome completo

            // Limpando os campos
            nomeTextField.setText("");
            sobrenomeTextField.setText("");
        }
    }
}
