

public class Poneglyph extends ElementoTabuleiro {
    public void interagir(Pirata pirata) {
        pirata.setPoneglyph(pirata.getPoneglyph()+1);

    }
    public String simbolo() { return "📖"; }

    public String simboloComJogador(){
        return "🕋";
    }
}

