package Model;

//---=| Data | Hora | Usuario | Descrição |=---//

public class Agenda {
    //-----===| ATRIBUTOS |===-----//
    private String data;
    private String hora;
    private String usuario;
    private String descricao;
    
    //-----===| CONSTRUTOR |===-----//
    public Agenda() {}

    public Agenda(String data, String hora, String usuario, String descricao) {
        this.data = data;
        this.hora = hora;
        this.usuario = usuario;
        this.descricao = descricao;
    }
    
    //-----===| MÉTODOS |===-----//
    //---=| Data |=---//
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    //---=| Hora |=---//
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    //---=| Usuario |=---//
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    //---=| Descrição |=---//
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
