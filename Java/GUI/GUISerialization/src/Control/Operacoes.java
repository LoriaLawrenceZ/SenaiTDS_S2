package Control;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Usuario;

public class Operacoes {
    //-----===| ATRIBUTOS |===-----//
    private List<Usuario> usuarios;
    private DefaultTableModel tableModel;
    private JTable table;

    //-----===| CONSTRUTOR |===-----//
    public Operacoes(List<Usuario> usuarios, DefaultTableModel tableModel, JTable
    table) {
        this.usuarios = usuarios;
        this.tableModel = tableModel;
        this.table = table;
    }

    //-----===| MÉTODOS |===-----//
    //---=| Cadastrar Usuário |=---//
    public void cadastrarUsuario(String nome, String idade) {
        int idadeInt = Integer.parseInt(idade); // Idade (convertendo pra 'int')
        Usuario usuario = new Usuario(nome, idadeInt); // Instanciando objeto Usuario 'usuario'

        usuarios.add(usuario); // Adicionando objeto instanciado 'usuario' à lista 'usuarios'

        atualizarTabela(); // Atualizar tabela
    }

    //---=| Atualizar Usuário |=---//
    public void atualizarUsuario(int linhaSelecionada, String nome, String idade) {
        if (linhaSelecionada != -1) {
            int idadeInt = Integer.parseInt(idade); // Idade (convertendo pra 'int')
            Usuario usuario = new Usuario(nome, idadeInt); // Instanciando objeto Usuario 'usuario'

            usuarios.set(linhaSelecionada, usuario); // Atualiza os dados a partir do índice (usuario na linha selecionada)

            atualizarTabela(); // Atualizar tabela
        }
    }

    //---=| Apagar Usuário |=---//
    public void apagarUsuario(int linhaSelecionada) {
        if (linhaSelecionada != -1) {
            usuarios.remove(linhaSelecionada); // Remove linha selecionada

            atualizarTabela(); // Atualiza tabela
        }
    }

    //---=| Apagar Todos Usuários |=---//
    public void apagarTodosUsuarios() {
        usuarios.clear(); // Limpar lista

        atualizarTabela(); // Atualizar tabela
    }

    //---=| Serialização |=---//
    public void salvarUsuarios() {
        Serializacao.serializar("dados.txt", usuarios);
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0); // Voltar para a linha 0 pra adicionar corretamente (adicionar Lista dentro da Tabela)

        for (Usuario usuario : usuarios) { // Adicionar itens através do loop 'For'
            tableModel.addRow(new Object[] { usuario.getNome(), usuario.getIdade() }); // Adicionando Item atual da Lista dentro da Tabela
        }
    }
}
