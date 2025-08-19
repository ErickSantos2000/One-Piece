import java.io.*; // lib de entrada e saida do java que inclui classe para manipulação de arquivos

public class SavePoint {
    private static final String jogoSalvo = "jogo.bin";

    // metodo para salvar o obj serializavel
    public static void salvar(Object obj){
        // crio uma variável temporária para gerenciar o fluxo de escrita em arquivo
        // objectOutputStream é a classe que, atraves do metodo writeObject(obj) converte os objetos Java em bytes (serialização)
        // FileOutputStream é responsável por escrever esses bytes no arquivo
        try(ObjectOutputStream outFluxo = new ObjectOutputStream(new FileOutputStream(jogoSalvo))) {
            // nesse trecho o obj é serializado, e salvo no arquivo jogo.bin
            outFluxo.writeObject(obj);
            System.out.println("Jogo salvo!");
        } catch (IOException e){
            System.out.println("Erro ao salvar" + e.getMessage());
        }
    }
}
