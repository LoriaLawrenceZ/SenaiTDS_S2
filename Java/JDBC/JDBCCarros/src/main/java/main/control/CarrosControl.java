package main.control;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.model.Carro;

public class CarrosControl {
    // -----===| ATRIBUTOS |===-----//
    private CarrosDAO carrosDAO = new CarrosDAO();
    private List<Carro> carros;
    private DefaultTableModel tableModel;
    private JTable table;

    // -----===| CONSTRUTOR |===-----//
    public CarrosControl(List<main.model.Carro> carros, DefaultTableModel tableModel, JTable table) {
        this.carros = carros;
        this.tableModel = tableModel;
        this.table = table;
    }

    // -----===| MÉTODOS CRUD |===-----//
    // ---=| CREATE |=---//
    public void createCarro(String placa, Short ano, String marca, String modelo, String cor, Double preco) {
        try {
            carrosDAO.create(placa, ano, marca, modelo, cor, preco);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Carro carro = new Carro(placa, ano, marca, modelo, cor, preco);
        carros.add(carro);

        atualizarTabela();
    }

    //---=| UPDATE |=---//
    public void updateCarro(int linhaSelecionada, String placa, Short ano, String marca, String modelo, String cor, Double preco) {
        if (linhaSelecionada != -1) {
            try {
                carrosDAO.update(placa, ano, marca, modelo, cor, preco);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Carro carro = new Carro(placa, ano, marca, modelo, cor, preco);
            carros.set(linhaSelecionada, carro);

            atualizarTabela();
        }
    }

    //---=| DELETE |=---//
    public void deleteCarro(int linhaSelecionada, String placa) {
        try {
            if(linhaSelecionada != 1){
                carrosDAO.delete(placa);
                carros.remove(linhaSelecionada);
                
                atualizarTabela();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //---=| Atualizar Tabela |=---//
    private void atualizarTabela() {
        tableModel.setRowCount(0);
        Object linha[] = new Object[6];

        for (int i = 0; i < carros.size(); i++) {
            linha[0] = carros.get(i).getPlaca();
            linha[1] = carros.get(i).getAno();
            linha[2] = carros.get(i).getPlaca();
            linha[3] = carros.get(i).getPlaca();
            linha[4] = carros.get(i).getCor();
            linha[5] = carros.get(i).getPreco();
        }
    }
}