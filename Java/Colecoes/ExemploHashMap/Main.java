package ExemploHashMap;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {        
        ExemploHashMap ehm = new ExemploHashMap();
        
        String escolha;
        String sOUn = "";
        
        do {
            escolha = JOptionPane.showInputDialog("[1] - Exemplo HashMap | [2] - Exercício 1");

            switch (escolha) {
                case "1":
                    ehm.Exemplo();
                    sOUn = "S";
                    break;

                case "2":
                    ehm.Exercicio1();
                    sOUn = "S";
                    break;

                default:
                    sOUn = "N";
                    break;
            }
        } while (sOUn.equalsIgnoreCase("S"));
    }   
}