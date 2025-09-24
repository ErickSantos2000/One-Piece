public class Mar extends ElementoTabuleiro {
    public void interagir(Jogador jogador) {
        jogador.atualizarPontos(0);
        jogador.setArmadilha(jogador.getArmadilha()+1);
    }
    public String simbolo() { return "\uD83C\uDF0A"; }

     public String simboloComJogador(){
        return "⛵";
    }
}


