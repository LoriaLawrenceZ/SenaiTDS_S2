package ExemploTryCatchFinally;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String frase = null;
        String fraseUpper = null;

        frase = JOptionPane.showInputDialog("Digite uma frase");
        
        if(frase.equals("")){
            frase = null;
        }

        try {
            fraseUpper = frase.toUpperCase();
        }
        catch(NullPointerException fraseNula) {
            JOptionPane.showMessageDialog(null, "ERRO - String vazia!");

            frase = "A frase estava vazia";
        }
        finally{
            fraseUpper = frase.toUpperCase();

            JOptionPane.showMessageDialog(null, fraseUpper);
        }
    }
}
