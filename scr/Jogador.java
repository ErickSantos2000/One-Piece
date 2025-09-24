import java.io.Serializable;

public class Jogador implements Serializable {
    private int linha, coluna;
    private int pontos;
    private int movimentos;
    private int tesouro;
    private int armadilha;

    public Jogador() {
        this.linha = 0;
        this.coluna = 0;
        this.pontos = 0;
        this.movimentos = 0;
        this.tesouro = 0;
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

    public void atualizarPontos(int valor) {
        pontos += valor;
    }


    // gets
    public int getArmadilha() {
        return armadilha;
    }

    public int getLinha() { return linha; }

    public int getColuna() { return coluna; }

    public int getPontos() { return pontos; }

    public int getMovimentos() { return movimentos; }


    public int getTesouro() {
        return tesouro;
    }

    // sets
    public void setTesouro(int tesouro) {
        this.tesouro = tesouro;
    }

    public void setArmadilha(int armadilha) {
        this.armadilha = armadilha;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setMovimentos(int movimentos) {
        this.movimentos = movimentos;
    }

}
