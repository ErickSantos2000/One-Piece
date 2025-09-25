import java.io.Serializable;

public class Pirata implements Serializable {
    private int linha, coluna;
    private int movimentos;
    private int poneglyph;
    private int marinha;

    public Pirata() {
        this.linha = 0;
        this.coluna = 0;
        this.movimentos = 0;
        this.poneglyph = 0;
    }


    public void mover(char direcao) {
        switch (Character.toUpperCase(direcao)) {
            case 'W': if (linha > 0) linha--; break;
            case 'S': if (linha < 9) linha++; break;
            case 'A': if (coluna > 0) coluna--; break;
            case 'D': if (coluna < 9) coluna++; break;
        }
        movimentos++;
    }

    // gets
    public int getMarinha() {
        return marinha;
    }

    public int getLinha() { return linha; }

    public int getColuna() { return coluna; }

    public int getMovimentos() { return movimentos; }

    public int getPoneglyph() {
        return poneglyph;
    }

    // sets
    public void setPoneglyph(int tesouro) {
        this.poneglyph = tesouro;
    }

    public void setMarinha(int armadilha) {
        this.marinha = armadilha;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setMovimentos(int movimentos) {
        this.movimentos = movimentos;
    }

}
