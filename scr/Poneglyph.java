

public class Poneglyph extends ElementoTabuleiro {
    public void interagir(Jogador jogador) {
        jogador.atualizarPontos(3);
        jogador.setTesouro(jogador.getTesouro()+1);

    }
    public String simbolo() { return "📖"; }

    public String simboloComJogador(){
        return "🕋";
    }
}

