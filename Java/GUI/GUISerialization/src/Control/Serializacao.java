package Control;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import Model.Usuario;

public class Serializacao {
    //-----===| MÉTODOS |===-----//
    //---=| Serializar |=---//
    // Serializar uma lista de usuários em um arquivo binário
    public static void serializar(String arquivo, List<Usuario> usuarios) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(arquivo)) /*Tem que acontecer para 'Try' ser executado*/) { // Gravando informações
            outputStream.writeObject(usuarios); // Escreve a lista de usuários no arquivo especificado
            System.out.println("Dados serializados com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao serializar os dados: " + e.getMessage()); // Em caso de erro na serialização, imprime a mensagem de erro
        }
    }

    //---=| Deserializar |=---//
    // Deserializar uma lista de usuários a partir de um arquivo binário
    public static List<Usuario> deserializar(String arquivo) {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(arquivo)); // Abre o arquivo para leitura
            
            return (List<Usuario>) inputStream.readObject(); // Lê a lista de usuários do arquivo e a converte de volta para a lista
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao deserializar os dados: " + e.getMessage()); // Em caso de erro na deserialização, imprime a mensagem de erro
            return null; // Retorna nulo para indicar que ocorreu um erro
        }
    }
}