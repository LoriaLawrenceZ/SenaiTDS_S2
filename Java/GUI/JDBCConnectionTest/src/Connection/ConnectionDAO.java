package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDAO {
    // -----===| ATRIBUTOS |===-----//
    private Connection connection;

    // -----===| CONSTRUTOR |===-----//
    public ConnectionDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // -----===| MÉTODOS |===-----//
    // Método para CRIAR tabela
    public void criaTabela() {
        String sqlQuery = "CREATE TABLE IF NOT EXISTS MINHA_TABELA (ID SERIAL, NOME VARCHAR(255), EMAIL VARCHAR(255), PRIMARY KEY(ID));"; // "SERIAL"
                                                                                                                                          // ==
                                                                                                                                          // auto_increment

        // Quando passando algo como atributo no try-catch, aquilo tem que funcionar,
        // caso contrário vai pro catch
        try (Statement statement = this.connection.createStatement()) { // Criando statement no parâmetro do try-catch
            statement.execute(sqlQuery);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally { // Independente se deu certo ou não, tem que fechar a conexão
            ConnectionFactory.closeConnection(this.connection); // Fecha conexão
        }
    }

    // Método para APAGAR tabela
    public void apagaTabela() {
        String sqlQuery = "DROP TABLE MINHA_TABELA;";

        // Quando passando algo como atributo no try-catch, aquilo tem que funcionar,
        // caso contrário vai pro catch
        try (Statement statement = this.connection.createStatement()) { // Criando statement no parâmetro do try-catch
            statement.execute(sqlQuery);
            System.out.println("Tabela deletada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar a tabela: " + e.getMessage(), e);
        } finally { // Independente se deu certo ou não, tem que fechar a conexão
            ConnectionFactory.closeConnection(this.connection); // Fecha conexão
        }
    }

    // Método para inserir valores na tabela
    public void insereDados(String nome, String email) throws SQLException {
        String sqlQuery = "INSERT INTO MINHA_TABELA (nome, email) VALUES (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        try {
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();

            System.out.println("Dados inseridos com sucesso");

            ConnectionFactory.closePreparedStatement(preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar a tabela: " + e.getMessage(), e);
        } finally { // Independente se deu certo ou não, tem que fechar a conexão
            preparedStatement.close();
            ConnectionFactory.closeConnection(this.connection); // Fecha conexão
        }
    }

    // Método para buscar por id
    public void buscarPorId(int id) {
        String sql = "SELECT * FROM MINHA_TABELA WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                int idBuscado = resultSet.getInt("ID");
                String nomeBuscado = resultSet.getString("NOME");
                String emailBuscado = resultSet.getString("EMAIL");
                System.out.println("o Resultado da busca é id " + idBuscado + " nome " + nomeBuscado + " email " + emailBuscado);
            }
            
            ConnectionFactory.closeResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }
}
