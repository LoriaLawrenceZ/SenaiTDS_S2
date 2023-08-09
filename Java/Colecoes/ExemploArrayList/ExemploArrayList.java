package ExemploArrayList;

// Não Funciona com valores primitivos

import java.util.*;
import javax.swing.JOptionPane;

public class ExemploArrayList {

    public void Exemplo(){
        // Creating ArrayList
        ArrayList<String> carros = new ArrayList<>();
    
        // Adding new items to the ArrayList [ .add() ]
        carros.add("Fusca");
        carros.add("Brasília");
        carros.add("Chevette");
        carros.add("Monza");
        carros.add("Monza");
        
        JOptionPane.showMessageDialog(null, carros);
    
        // Iterating over ArrayList (for)
        // Length of ArrayList [ .size() ]
        // Getting item at i index [ .get() ]
        for (int i = 0; i < carros.size(); i++) {
            JOptionPane.showMessageDialog(null, carros.get(i));   
        }
    
        // Ordening ArrayList [ .sort() ]
        Collections.sort(carros); // Crescenting/Alphabetic
        
        // Inverting ArrayList [ .reverse() ]
        Collections.reverse(carros);
        
        // Iterating over ArrayList (foreach)
        for (String i : carros) {
            JOptionPane.showMessageDialog(null, i);
        }
        
        // Clearing ArrayList [ .clear() ]
        carros.clear();
    
        JOptionPane.showMessageDialog(null, carros);
    }

    public void Exercicio1(){
        Random rd = new Random();
        // Create an ArrayList of integer numbers; Add 5 random numbers, sort them and write'em down
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            numbers.add(rd.nextInt(0, 100));
        }

        Collections.sort(numbers);

        JOptionPane.showMessageDialog(null, numbers);
    }
}
