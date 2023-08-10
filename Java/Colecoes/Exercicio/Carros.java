package Exercicio;

public class Carros {
    String marca;
    String modelo;
    String ano;
    String cor;
    String all;

    public Carros(){}
    public Carros(String marca, String modelo, String ano, String cor){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAll(){
        all = "-----------------------------\nMarca: "+ marca +"\nModelo: "+ modelo +"\nAno: "+ ano +"\nCor: "+ cor;
        return all;
    }
}
