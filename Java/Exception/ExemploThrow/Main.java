package ExemploThrow;

import javax.swing.JOptionPane;

//conter letra maiuscula e minuscula

public class Main {
    public static void main(String[] args) {
        boolean senhaOk = true;

        JOptionPane.showMessageDialog(null, "Welcome to SENAI!");
        
        String dataNascimento = JOptionPane.showInputDialog("Informe vossa data de aniversário");
        
        dataNascimento = dataNascimento.replace("/", "");
        
        String login = JOptionPane.showInputDialog("Informe vosso usuário:");

        while(senhaOk){
            try {
                String senha = JOptionPane.showInputDialog("Informe vossa senha:");
    
                if (senha.length() != 6) {
                    throw new Exception("Senha deve ter 6 Dígitos");            
                }
                else if(senha.contains(dataNascimento) | senha.contains(dataNascimento.substring(0, 3))){
                    throw new Exception("Senha não pode conter data de aniversário");
                }
                else if(senha.contains(login)){
                    throw new Exception("Senha não pode conter login");
                }
                else if(!senha.matches(".*[a-z].*") | !senha.matches(".*[A-Z].*")){
                    throw new Exception("Senha deve conter letras Maiúsculas E Minúsculas");
                }

                senhaOk =  false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "senha", 0);
            }
        }

    }
}
