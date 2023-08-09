package ExemploLinkedList;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {        
        ExemploLinkedList ell = new ExemploLinkedList();
        
        String escolha;
        String sOUn = "";
        
        do {
            escolha = JOptionPane.showInputDialog("[1] - Exemplo LinkedList | [2] - Exercício 1");

            switch (escolha) {
                case "1":
                    ell.Exemplo();
                    sOUn = "S";
                    break;

                case "2":
                    ell.Exercicio1();
                    sOUn = "S";
                    break;

                default:
                    sOUn = "N";
                    break;
            }
        } while (sOUn.equalsIgnoreCase("S"));
    }
}
