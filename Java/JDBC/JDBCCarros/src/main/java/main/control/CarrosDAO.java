package main.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import main.connection.ConnectionFactory;
import main.model.Carro;

public class CarrosDAO {
    //-----===| ATRIBUTOS |===-----//
    private Connection connection; // Conexão
    private List<Carro> carros; // Lista de carros

    //-----===| CONSTRUTOR |===-----//
    public CarrosDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    //-----===| MÉTODOS CRUD |===-----//
    //---=| CREATE |=---//
    public void create(String placa, Short ano, String marca, String modelo, String cor, double preco) throws SQLException {
        String query = "INSERT INTO carros (placa, ano, marca, modelo, cor, preco) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        try {
            preparedStatement.setString(1, placa);
            preparedStatement.setShort(2, ano);
            preparedStatement.setString(3, marca);
            preparedStatement.setString(4, modelo);
            preparedStatement.setString(5, cor);
            preparedStatement.setDouble(6, preco);
            preparedStatement.executeQuery();

            System.out.println("Dados inseridos com sucesso");

            ConnectionFactory.closePreparedStatement(preparedStatement);
            ConnectionFactory.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closePreparedStatement(preparedStatement);
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    //---=| READ |=---//
    public List<Carro> read() throws SQLException {
        ResultSet resultSet = null; // Objeto que armazena
        carros = new ArrayList<>();

        String query = "SELECT * FROM carros;"; // SQL Query
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        try {
            System.out.println("msg 1");
            resultSet = preparedStatement.executeQuery();
            // Loop para armazenar as informações do resultSet para a List<Carro>

            while(resultSet.next()){
                System.out.println("msg 2");
                Carro carro = new Carro(resultSet.getString("placa"), resultSet.getShort("ano"), resultSet.getString("marca"), resultSet.getString("modelo"), resultSet.getString("cor"), resultSet.getDouble("preco")); // Instanciando carro com as informações optidas pela query
                System.out.println("msg 3");

                //Adicionando objeto instanciado à lista
                carros.add(carro);
            }
            System.out.println("msg 4");
            // Fechando prepared statement 
            ConnectionFactory.closePreparedStatement(preparedStatement);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally { // Independente se deu certo ou não, tem que fechar a conexão
            ConnectionFactory.closePreparedStatement(preparedStatement);
            ConnectionFactory.closeConnection(connection);
        }

        System.out.println("msg 5");
        // Retornando lista (list<carro>)
        return carros;
    }

    //---=| UPDATE |=---//
    public void update(String placa, Short ano, String marca, String modelo, String cor, Double preco) throws SQLException {
        String query = "UPDATE carros SET ano = ?, marca = ?, modelo = ?, cor = ?, preco = ? WHERE placa = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        try {
            preparedStatement.setShort(1, ano);
            preparedStatement.setString(2, marca);
            preparedStatement.setString(3, modelo);
            preparedStatement.setString(4, cor);
            preparedStatement.setDouble(5, preco);
            preparedStatement.setString(6, placa);
            preparedStatement.executeQuery();

            System.out.println("Dados atualizados com sucesso");

            ConnectionFactory.closePreparedStatement(preparedStatement);
            ConnectionFactory.closeConnection(connection);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closePreparedStatement(preparedStatement);
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    //---=| DELETE |=---//
    public void delete(String placa) throws SQLException {
        String query = "DELETE FROM carros WHERE placa = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        try {
            preparedStatement.setString(1, placa);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

            ConnectionFactory.closePreparedStatement(preparedStatement);
            ConnectionFactory.closeConnection(connection);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closePreparedStatement(preparedStatement);
            ConnectionFactory.closeConnection(connection);
        }
    }
}
