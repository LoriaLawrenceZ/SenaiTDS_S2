package ExemploThrow;

import java.util.Date;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        try {
            JOptionPane.showMessageDialog(null, "Welcome to SENAI!");
            
            String dataNascimento = JOptionPane.showInputDialog("Informe vossa data de aniversário");
            dataNascimento += JOptionPane.showInputDialog("Informe vosso mês de aniversário");
            dataNascimento += JOptionPane.showInputDialog("Informe vosso ano de aniversário");

            String diaMesAno = dataNascimento.replace("/", "");
            String diaMes = "";

            String[] aniversario = diaMesAno.split("");

            for (int i = 0; i < 4; i++) {
                diaMes += aniversario[i];
            }

            String login = JOptionPane.showInputDialog("Informe vosso usuário:");
            String senha = JOptionPane.showInputDialog("Informe vossa senha:");

            if (senha.length() != 6) {
                throw new Exception("Senha deve ter 6 Dígitos");            
            }
            else if(senha.contains(diaMes) | senha.contains(diaMesAno)){
                throw new Exception("Senha não pode conter data de aniversário");
            }
            else if(senha.contains(login)){
                throw new Exception("Senha não pode conter login");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
}
