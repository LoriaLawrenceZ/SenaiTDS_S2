package ExemploArrayList;

import javax.swing.JOptionPane;

public class Main{
    public static void main(String[] args) {        
        ExemploArrayList eal = new ExemploArrayList();
        
        String escolha;
        String sOUn = "";
        
        do {
            escolha = JOptionPane.showInputDialog("[1] - Exemplo ArrayList | [2] - Exercício 1");

            switch (escolha) {
                case "1":
                    eal.Exemplo();
                    sOUn = "S";
                    break;

                case "2":
                    eal.Exercicio1();
                    sOUn = "S";
                    break;

                default:
                    sOUn = "N";
                    break;
            }
        } while (sOUn.equalsIgnoreCase("S"));
    }
}