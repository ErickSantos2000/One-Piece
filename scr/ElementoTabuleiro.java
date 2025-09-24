import java.io.Serializable;

public abstract class ElementoTabuleiro implements Serializable {
    public abstract void interagir(Jogador jogador);
    public abstract String simbolo();
    public abstract String simboloComJogador();
}
