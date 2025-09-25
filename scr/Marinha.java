

public class Marinha extends ElementoTabuleiro {
    public void interagir(Pirata pirata) {
        pirata.setMarinha(pirata.getMarinha()+1);
        
    }
    public String simbolo() { return "⚓"; }

    public String simboloComJogador(){
        return "💥";
    }
}

