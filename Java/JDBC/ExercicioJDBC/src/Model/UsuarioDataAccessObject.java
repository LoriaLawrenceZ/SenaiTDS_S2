package Model;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import Control.Conexao;

public class UsuarioDataAccessObject {
    // Localhost
    // Database empresa
    // Clientes: id, nome, cpf, telefone, email, endereço, senha

    //-----===| MÉTODOS |===-----//
    public void cadastrarUsuario(Usuario usuario){
        // Código SQL
        String statement = "INSERT INTO clientes(nome, cpf, telefone, email, endereco, senha) values (?, ?, ?, ?, ?, ?)";
        
        //Preparando código SQL (segurança)
        PreparedStatement psql = null;
        try {
            //Pegando conexão e em seguida preparando o statement
            psql = Conexao.getConexao().prepareStatement(statement);

            //Atribuindo valor aos '?'
            psql.setString(1, usuario.getNome());
            psql.setString(2, usuario.getCpf());
            psql.setString(3, usuario.getTelefone());
            psql.setString(4, usuario.getEmail());
            psql.setString(5, usuario.getEndereco());
            psql.setString(6, usuario.getSenha());

            psql.execute(); // Executando statement
            psql.close(); // Fechando conexão
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
