

public class Armadilha extends ElementoTabuleiro {
    public void interagir(Jogador jogador) {
        jogador.atualizarPontos(-2);
        jogador.setArmadilha(jogador.getArmadilha()+1);
        
    }
    public String simbolo() { return "💣"; }

    public String simboloComJogador(){
        return "💥";
    }
}

