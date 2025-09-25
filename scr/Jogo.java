import java.io.Serializable;
import java.util.*;

public class GranLine implements Serializable {
    private ElementoTabuleiro[][] tabuleiro;
    private Set<String> elementosVisitados;
    private Pirata pirata;
    private transient Scanner sc;

    public GranLine() {
        tabuleiro = new ElementoTabuleiro[10][10];
        tabuleiro[0][0] = new Mar();
        elementosVisitados = new HashSet<>();
        elementosVisitados.add("0,0");
        pirata = new Pirata();
        sc = new Scanner(System.in);
    }

    private void inicializarTabuleiro() {
        Random rand = new Random();

        // preenche o restante com tesouro
        int tesourosColocados = 0;
        while (tesourosColocados < 5) {
            int i = rand.nextInt(10);
            int j = rand.nextInt(10);
            if (tabuleiro[i][j] == null) {
                tabuleiro[i][j] = new Poneglyph();
                tesourosColocados++;
            }
        }

        // preenche o restante com armadilhas
        int armadilhasColocadas = 0;
        while (armadilhasColocadas < 5) {
            int linha = rand.nextInt(10);
            int coluna = rand.nextInt(10);
            if (tabuleiro[linha][coluna] == null) {
                tabuleiro[linha][coluna] = new Marinha();
                armadilhasColocadas++;
            }
        }

        // preenche o restante com vazio
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tabuleiro[i][j] == null) {
                    tabuleiro[i][j] = new Mar();
                }
            }
        }
    }

    public void jogar() {
        GranLine granLineSalvo = (GranLine) SavePoint.carregar();

        if(granLineSalvo == null){
            inicializarTabuleiro();
        }
        else {
            this.pirata = granLineSalvo.pirata;
            this.tabuleiro = granLineSalvo.tabuleiro;
            this.elementosVisitados = granLineSalvo.elementosVisitados;
            this.sc = new Scanner(System.in);
        }

    
        System.out.println("=========ONE PIECE=========");
        System.out.println("Bem vindo a Grand Line!");
        System.out.println("Encontre 5 Poneglyphs (📖) para conquistar o One Piece.");
        System.out.println("=========ONE PIECE=========");
        while (pirata.getMovimentos() < 20 && pirata.getPoneglyph() < 5) {

            mostrarTabuleiro();

            System.out.println("=========ONE PIECE=========");
            System.out.println("Numero de movimentos: " + pirata.getMovimentos());
            System.out.println("Poneglyphs encontrados encontrados: " + pirata.getPoneglyph());
            System.out.println("=========ONE PIECE=========");

            System.out.print("Movimento \nW - cima\nS - baixo\nA - esquerda\nD - direita\n");
            char movimento = sc.next().charAt(0);

            int linhaTeste = pirata.getLinha();
            int colunaTeste = pirata.getColuna();

            switch(Character.toUpperCase(movimento)){
                case 'A': colunaTeste--; break;
                case 'W': linhaTeste--; break;
                case 'D': colunaTeste++; break;
                case 'S': linhaTeste++; break;
                default:
                    System.out.println("movimento invalido, apenas permitido usar: W, A, S ou D.");
                    continue;
            }

            if (linhaTeste < 0 || linhaTeste >= 10 || colunaTeste < 0 || colunaTeste >= 10) {
                System.out.println("Jogada invalida.");
                continue;
            }

            // pega a posição atual do tabuleiro
            String posicao = linhaTeste + "," + colunaTeste;

            // verifica se posição atual ja foi visitado
            if(elementosVisitados.contains(posicao)){
                System.out.println("Vc ja visitou essa posiçao. Jogada perdida");
                continue;
            }

            // incia o movimento
            pirata.mover(movimento);

            int linha = pirata.getLinha();
            int coluna = pirata.getColuna();

            // marca como visitado
            elementosVisitados.add(linha + "," + coluna);

            tabuleiro[linha][coluna].interagir(pirata); // POLIMORFISMO
            
            System.out.println("vc encontrou: " + tabuleiro[linha][coluna].simbolo()); // POLIMORFISMO
            // salvar jogo
            SavePoint.salvar(this);
        }

        System.out.println("=========FINAL=========");
        System.out.println("Poneglyphs encontrados: " + pirata.getPoneglyph());
        mostrarTabuleiroFinal();
        System.out.println("=======================");
        // deletar jogo
        SavePoint.deletar();
    }

    // imprimir
    private void mostrarTabuleiro() {
        System.out.println("Tabela:");
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {

                // aqui é controla onde o jogador esta
                if (i == pirata.getLinha() && j == pirata.getColuna()) {
                        System.out.print(tabuleiro[i][j].simboloComJogador()); // POLIMORFISMO
                    }
                else if (elementosVisitados.contains(i + "," + j)) {
                    System.out.print(tabuleiro[i][j].simbolo()); // POLIMORFISMO
                } 
                
                else {
                    System.out.print("\uD83C\uDF0A");
                }
                }
                System.out.println();
            }
            
        }
    
    // mostrar tabela apos o termino do jogo
    public void mostrarTabuleiroFinal() {
        System.out.println("\nTabela Final:");
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j].simbolo());
            }
            System.out.println();
        }
    }

    // gets
    public ElementoTabuleiro[][] getTabuleiro() {
        return tabuleiro;
    }

    public Set<String> getElementosVisitados() {
        return elementosVisitados;
    }

    public Pirata getJogador() {
        return pirata;
    }

    // sets
    public void setElementosVisitados(Set<String> filtro) {
        this.elementosVisitados = filtro;
    }

    public void setJogador(Pirata pirata) {
        this.pirata = pirata;
    }

    public void setTabuleiro(ElementoTabuleiro[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
}
