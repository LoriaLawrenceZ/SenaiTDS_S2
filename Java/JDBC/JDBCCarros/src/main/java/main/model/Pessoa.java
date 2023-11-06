package main.model;

public class Pessoa {
    //-----===| ATRIBUTOS |===-----//
    private Integer cpf;
    private String nome;
    private Integer telefone;
    private String rua;
    private String numero;
    private Integer cep;
    private String senha;
    private boolean funcionario;
    
    //-----===| CONSTRUTOR |===-----//
    public Pessoa() {}

    public Pessoa(Integer cpf, String nome, Integer telefone, String rua, String numero, Integer cep, String senha, boolean funcionario) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.senha = senha;
        this.funcionario = funcionario;
    }
    
    //-----===| GETTERS & SETTERS |===-----//
    public Integer getCpf() {
        return cpf;
    }
    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTelefone() {
        return telefone;
    }
    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getCep() {
        return cep;
    }
    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(boolean funcionario) {
        this.funcionario = funcionario;
    }
}
