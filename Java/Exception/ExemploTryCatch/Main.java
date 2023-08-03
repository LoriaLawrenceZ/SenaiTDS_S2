package ExemploTryCatch;

import javax.swing.JOptionPane;

public class Main{
    public static void main(String[] args) {
        int n1;
        int n2;
        boolean calcular = true;

        while (calcular) {
            // Tratando as Exceptions
            try {
                // Recebendo dados
                n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro:"));
                n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite um segundo número inteiro:"));
                
                // Resultados
                JOptionPane.showMessageDialog(null, "A soma é"+ (n1 + n2));
                JOptionPane.showMessageDialog(null, "A subtração é"+ (n1 - n2));
                JOptionPane.showMessageDialog(null, "A multiplicação é"+ (n1 * n2));
                JOptionPane.showMessageDialog(null, "A divisão é"+ (n1 / n2));

                calcular = false;
            } catch (Exception erro1) {
                JOptionPane.showMessageDialog(null, "Número Inserido não é inteiro");
            }
        }

    }
}