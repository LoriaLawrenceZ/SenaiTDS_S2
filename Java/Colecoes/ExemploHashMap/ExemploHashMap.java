package ExemploHashMap;

// Não Funciona com valores primitivos

import java.util.*;
import javax.swing.JOptionPane;

public class ExemploHashMap {
    public void Exemplo(){
        // Creating HashMap
        HashMap<String, String> estadoCapital = new HashMap<>();

        // Adding items to HashMap [ .put() ]
        estadoCapital.put("SP", "São Paulo");
        estadoCapital.put("RJ", "Rio de Janeiro");
        estadoCapital.put("MG", "Belo Horizonte");
        estadoCapital.put("ES", "Vitória");

        JOptionPane.showMessageDialog(null, estadoCapital);

        // Searching value by its key
        estadoCapital.get("MG");

        // Iterating over a HashMap (foreach)
        for (String estado : estadoCapital.keySet()){
            JOptionPane.showMessageDialog(null, estado +": "+ estadoCapital.get(estado));
        }
    }

    public void Exercicio1(){
        HashMap<String, Integer> pessoa = new HashMap<>();
        
        int vezes = Integer.parseInt(JOptionPane.showInputDialog("Deseja adicionar quantas pessoas?"));
        
        for (int i = 0; i < vezes; i++) {
            pessoa.put(JOptionPane.showInputDialog("Nome:"), Integer.parseInt(JOptionPane.showInputDialog("Idade:")));
        }

        JOptionPane.showMessageDialog(null, pessoa);
    }   
}