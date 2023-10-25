package Model;

import java.io.Serializable; // Classe abstrata Serializable (Classe de 'marcação' - Indica pra JVM que a Classe permite serialização) //

public class Usuario implements Serializable {
    //-----===| ATRIBUTOS |===-----//
    private String nome;
    private int idade;

    //-----===| CONTRUTOR |===-----//
    public Usuario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    //-----===| GETTERS & SETTERS |===-----//
    //---=| Nome |=---//
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    //---=| Idade |=---//
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return null;
    }

    public String getTelefone() {
        return null;
    }

    public String getEmail() {
        return null;
    }

    public String getEndereco() {
        return null;
    }
}
