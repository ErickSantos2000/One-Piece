public class Mar extends ElementoTabuleiro {
    public void interagir(Pirata pirata) {
        pirata.setMarinha(pirata.getMarinha()+1);
    }
    public String simbolo() { return "\uD83C\uDF0A"; }

     public String simboloComJogador(){
        return "⛵";
    }
}


