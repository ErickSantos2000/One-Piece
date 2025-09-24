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

    // Metodo para carregar um obj serializavel
    public static Object carregar() {
        // Objeto a ser retornado, inicializado como nulo
        Object obj = null;
        try (ObjectInputStream inFluxo = new ObjectInputStream(new FileInputStream(jogoSalvo))) {
            // Ler o objeto do arquivo e converte os bytes para o tipo Object
            obj = inFluxo.readObject();
            System.out.println("Jogo carregado com sucesso!");
        } catch (FileNotFoundException e) {
            // Excecao caso o arquivo nao exista
            System.out.println("Nenhum jogo salvo encontrado.");
            return null;
        } catch (IOException | ClassNotFoundException e) {
            // Outras excecoes, como erro de leitura ou a classe nao sendo encontrada
            System.out.println("Erro ao carregar o jogo: " + e.getMessage());
        }
        return obj;
    }

    // Metodo para deletar o arquivo do jogo salvo
    public static void deletar() {
        File arquivo = new File(jogoSalvo);
        if (arquivo.exists()) {
            if (arquivo.delete()) {
                System.out.println("Jogo salvo deletado com sucesso.");
            } else {
                System.out.println("Erro ao deletar o jogo salvo.");
            }
        } else {
            System.out.println("Nenhum jogo salvo para deletar.");
        }
    }
}
