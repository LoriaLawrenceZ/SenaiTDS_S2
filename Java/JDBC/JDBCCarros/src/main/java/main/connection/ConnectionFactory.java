package main.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
    // -----===| ATRIBUTOS |===-----//
    private static final String URL = "jdbc:postgresql://localhost:5432/concessionaria";
    private static final String USUARIO = "postgres"; // Administrador do banco
    private static final String SENHA = "postgres"; // Senha do administrador do banco

    // -----===| MÉTODOS |===-----//
    // Método para ABRIR conexão
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao tentar obter conexão com o Banco de Dados");
        }
    }

    // Método para FECHAR conexão Connection
    public static void closeConnection(Connection connection) {
        try {
            if (!connection.equals(null)) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para FECHAR conexão PreparedStatement
    public static void closePreparedStatement(PreparedStatement preparedStatement){
        try {
            if(!preparedStatement.equals(null)){
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
