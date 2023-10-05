//Classe pra guardar as tarefas

public class Task {
    //Atributos
    private String descricao;
    private boolean feito;

    //Construtor
    public Task(String descricao) {
        this.descricao = descricao;
        this.feito = false; //Nenhuma tarefa começa concluída, por isso o false
    }

    //Get & Set Descrição
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
     this.descricao = descricao;
    }

    //Get & Set Feito
    public boolean isFeito() {
        return feito;
    }
    public void setFeito(boolean feito) {
        this.feito = feito;
    }
}
