package app;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            Statement s; // Cria uma instância de Statement para executar comandos SQL.
            String usuario = "postgres"; // Nome de usuário do banco de dados.
            String senha = "postgres"; // Senha do banco de dados.
            String url = "jdbc:postgresql://localhost:5432/postgres"; // URL de conexão com o banco de dados PostgreSQL.

            // Estabelece a conexão com o banco de dados.
            Connection c = DriverManager.getConnection(url, usuario, senha);
            s = c.createStatement(); // Cria um objeto Statement a partir da conexão.
            // Executa uma codigo SQL de inserção na tabela "contato".
            // ser substituídos pelos valores reais a serem inseridos.
            s.execute("DELETE FROM contato WHERE id=1;");
            c.close(); // Fecha a conexão com o banco de dados após a conclusão da operação.
        } catch (Exception E) {
            System.out.println("\n" + E); // Captura e imprime qualquer exceção que ocorra durante a execução.
        }
    }
}