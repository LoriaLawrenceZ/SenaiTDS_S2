package ExemploTryCatch;

import javax.swing.JOptionPane;

public class Operacoes {
    int numero;
    boolean numOk;

    public int Numero(String ordem){
        numOk = true;

        while (numOk){
            try {
                if(ordem.equalsIgnoreCase("1")){
                    numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um PRIMEIRO NÚMERO INTEIRO:"));
                }
                else{
                    numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um SEGUNDO NÚMERO INTEIRO:"));
                }
                numOk = false;
            } catch (NumberFormatException naoInteiro) {
                JOptionPane.showMessageDialog(null, "Número inserido não é INTEIRO");
            }
        }

        return numero;
    }

    public void Adicao(int n1, int n2){
        JOptionPane.showMessageDialog(null, "A soma dos números é: "+ (n1 + n2));
    }

    public void Subtracao(int n1, int n2){
        JOptionPane.showMessageDialog(null, "A subtração dos números é: "+ (n1 - n2));
    }

    public void Multiplicacao(int n1, int n2){
        JOptionPane.showMessageDialog(null, "A multiplicação dos números é: "+ (n1 * n2));
    }

    public void Divisao(int n1, int n2){
        JOptionPane.showMessageDialog(null, "A divisão dos números é: "+ (n1 / n2));
    }
}
