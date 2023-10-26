package Control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Agenda;

public class OperacoesAgendamento {
    //-----===| ATRIBUTOS |===-----//
    private List<Agenda> agendados;
    private DefaultTableModel tableModel;
    private JTable table;

    //-----===| CONSTRUTOR |===-----//
    public OperacoesAgendamento(List<Agenda> agendados, DefaultTableModel tableModel, JTable
    table) {
        this.agendados = agendados;
        this.tableModel = tableModel;
        this.table = table;
    }

    //-----===| MÉTODOS |===-----//
    //---=| Data Válida |=---//
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd"); // Format pra data
    public boolean isValidDate(String data){
        try {
            format.parse(data);
            return true;
        }
        catch(ParseException e){
            return false;
        }
    }

    //---=| Cadastrar Usuário |=---//
    public void cadastrarAgendamento(String data, String hora, String usuario, String descricao) {
        Agenda agenda = new Agenda(data, hora, usuario, descricao); // Instanciando objeto Usuario 'usuario'

        agendados.add(agenda); // Adicionando objeto instanciado 'usuario' à lista 'usuarios'

        atualizarTabela(); // Atualizar tabela
    }

    //---=| Atualizar Usuário |=---//
    public void atualizarAgendamento(int linhaSelecionada, String data, String hora, String usuario, String descricao) {
        if (linhaSelecionada != -1) {
            Agenda agenda = new Agenda(data, hora, usuario, descricao); // Instanciando objeto Usuario 'usuario'

            agendados.set(linhaSelecionada, agenda); // Atualiza os dados a partir do índice (usuario na linha selecionada)

            atualizarTabela(); // Atualizar tabela
        }
    }

    //---=| Apagar Usuário |=---//
    public void apagarAgendamento(int linhaSelecionada) {
        if (linhaSelecionada != -1) {
            agendados.remove(linhaSelecionada); // Remove linha selecionada

            atualizarTabela(); // Atualiza tabela
        }
    }

    //---=| Serialização |=---//
    public void salvarAgendamento() {
        Serializacao.serializarAgendados("agendamentos.txt", agendados);
    }

    //---=| Atualizar Tabela |=---//
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Voltar para a linha 0 pra adicionar corretamente (adicionar Lista dentro da Tabela)

        for (Agenda agenda : agendados) { // Adicionar itens através do loop 'For'
            tableModel.addRow(new Object[] { agenda.getData(), agenda.getHora(), agenda.getUsuario(), agenda.getDescricao() }); // Adicionando Item atual da Lista dentro da Tabela
        }
    }
}
