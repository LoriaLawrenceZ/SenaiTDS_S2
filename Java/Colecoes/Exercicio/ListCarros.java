package Exercicio;

import java.util.*;

import javax.swing.JOptionPane;

public class ListCarros {
    LinkedList<Carros> carros = new LinkedList<>();
    Carros carro;

    String marca;
    String modelo;
    String ano;
    String cor;
    String listar = "";

    public void Cadastrar(){
        marca = JOptionPane.showInputDialog("Qual a marca do carro?");
        modelo = JOptionPane.showInputDialog("Qual o modelo do carro?");
        ano = JOptionPane.showInputDialog("Qual o ano do carro?");
        cor = JOptionPane.showInputDialog("Qual a cor do carro?");

        carros.add(new Carros(marca, modelo, ano, cor));

        JOptionPane.showMessageDialog(null, carros.getLast().getAll());
    }

    public void Exibir(){
        for (Carros carrinho : carros) {
            listar += "\n"+ carrinho.getAll();
        }

        JOptionPane.showMessageDialog(null, listar);
        listar = "";
    }

    public void Consultar(){
        marca = JOptionPane.showInputDialog("Qual a marca do carro que deseja consultar?\n[Atente-se a escrita]");

        for (Carros carrinho : carros) {
            if(marca.equalsIgnoreCase(carrinho.getMarca())){
                listar += "\n"+ carrinho.getAll();
            }
        }

        JOptionPane.showMessageDialog(null, listar);
        listar = "";
    }

    public void Excluir(){
        marca = JOptionPane.showInputDialog("Qual a marca do carro que deseja excluir?\n[Atente-se a escrita]");

        for (int i = 0; i < carros.size(); i++) {
            if(marca.equalsIgnoreCase(carros.get(i).getMarca())){
                carros.remove(carros.get(i));
            }
        }
        for (Carros carrinho : carros) {
            listar += "\n"+ carrinho.getAll();
        }
        
        JOptionPane.showMessageDialog(null, "Carros deletados.\nLista dos carros:\n" + listar);
        listar = "";
    }
    
}
