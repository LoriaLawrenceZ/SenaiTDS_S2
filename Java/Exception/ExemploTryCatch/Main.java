package ExemploTryCatch;

import javax.swing.JOptionPane;

public class Main{
    public static void main(String[] args) {
        Operacoes operacoes = new Operacoes();

        int n1;
        int n2;
        String escolha = "S";
        boolean n2nao0 = true;

        do {
            escolha = JOptionPane.showInputDialog("Qual o tipo de operação que deseja realizar?\n[1] - Adição\n[2] - Subtração\n[3] - Multiplicação\n[4] - Divisão\n[S] - Sair");
            switch (escolha) {
                case "1":
                    n1 = operacoes.Numero("1");
                    n2 = operacoes.Numero("2");
                    operacoes.Adicao(n1, n2);
                    break;

                case "2":
                    n1 = operacoes.Numero("1");
                    n2 = operacoes.Numero("2");
                    operacoes.Subtracao(n1, n2);
                    break;

                case "3":
                    n1 = operacoes.Numero("1");
                    n2 = operacoes.Numero("2");
                    operacoes.Multiplicacao(n1, n2);
                    break;
                
                case "4":
                    while (n2nao0) {
                        try {
                            n1 = operacoes.Numero("1");
                            n2 = operacoes.Numero("2");
                            operacoes.Divisao(n1, n2);
                            
                            n2nao0 = false;
                        } catch (ArithmeticException dividiuPorZero) {
                            JOptionPane.showMessageDialog(null, "Não é possivel realizar a divisão com estes números!\nNão é possível dividir por ZERO");
                        }
                    }
                    break;
                
                default:
                    JOptionPane.showMessageDialog(null, "-----===SAINDO===-----");
                    escolha = "S";
                    break;
            }
        } while (!escolha.equalsIgnoreCase("S"));
    }
}