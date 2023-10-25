package Control;


import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexao {
    // Localhost
    // Database empresa
    // Clientes: id, nome, cpf, telefone, email, endereço

    //-----===| ATRIBUTOS |===-----//
    private static final String url = "jdbc:mysql://localhost:3306/empresa"; // URL do banco de dados
    private static final String user = "root"; // Usuario do banco de dados
    private static final String password = "senaisp"; // Senha do banco de dados

    private static Connection conn; //Instanciando objeto de conexão

    //-----===| Métodos |===-----//
    // Método para conectar com o banco de dados
    public static Connection getConexao(){
        try {
            // Se a conexão não existir, cria uma
            if(conn == null){
                conn = DriverManager.getConnection(url, user, password); // Passando atributos pra conexão
                return conn; // Retorna conexão
            }

            return conn; // Retorna conexão

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
}
