public class Vazio extends ElementoTabuleiro {
    public void interagir(Jogador jogador) {
        jogador.atualizarPontos(0);
        jogador.setArmadilha(jogador.getArmadilha()+1);
    }
    public String simbolo() { return "⬜"; }

     public String simboloComJogador(){
        return "🧍";
    }
}


