package ExemploThrow;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        boolean camposOk = true;
        boolean senhaOk = true;

        JOptionPane.showMessageDialog(null, "Welcome to SENAI!");
        
        while(camposOk){
            try {
                String dataNascimento = JOptionPane.showInputDialog("Informe vossa data de aniversário");
                if(dataNascimento.length() == 0){
                    throw new Exception("Campo não pode estar vazio!");
                }
                
                dataNascimento = dataNascimento.replace("/", "");
                
                String login = JOptionPane.showInputDialog("Informe vosso usuário:");
                if(login.length() == 0){
                    throw new Exception("Campo não pode estar vazio!");
                }

        
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

                camposOk = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "", 0);
            }
        }


    }
}
