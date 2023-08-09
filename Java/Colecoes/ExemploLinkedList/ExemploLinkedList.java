package ExemploLinkedList;

// Não Funciona com valores primitivos

import java.util.*;
import javax.swing.JOptionPane;

public class ExemploLinkedList {
    
    public void Exemplo(){
        // Creating LinkedList
        LinkedList<String> pessoas = new LinkedList<>();

        // Adding to LinkedList [ .add() ]
        pessoas.add("Pedro");
        pessoas.add("Maria");
        pessoas.add("João");
        // Getting last item in LinkedList [ .getLast() ]
        pessoas.getLast();
        // Adding to first position in LinkedList [ .addFirst() ]
        pessoas.addFirst("Cecília");
        // Removing last item in LinkedList [ .removeLast() ]
        pessoas.removeLast();

        JOptionPane.showMessageDialog(null, pessoas);
    }

    public void Exercicio1(){}
}
