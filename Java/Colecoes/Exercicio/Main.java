package Exercicio;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ListCarros carros = new ListCarros();

        String escolha;
        String sOUn = "";
        
        do {
            escolha = JOptionPane.showInputDialog("[1] - Cadastrar Carro | [2] - Exibir Carro | [3] - Consultar Carro | [4] - Excluir Carro | [S] - Sair");

            switch (escolha) {
                case "1":
                    carros.Cadastrar();
                    sOUn = "S";
                    break;

                case "2":
                    carros.Exibir();
                    sOUn = "S";
                    break;

                case "3":
                    carros.Consultar();
                    sOUn = "S";
                    break;

                case "4":
                    carros.Excluir();
                    sOUn = "S";
                    break;

                default:
                    sOUn = "N";
                    break;
            }
        } while (sOUn.equalsIgnoreCase("S"));
    }
}

// Classe carros(marca, modelo, ano, cor)
// Cadastrar um carro; Mostrar uma lista de carros cadastrados; Consultar carro cadastrado; Excluir carro cadastrado