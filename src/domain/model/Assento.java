package domain.model;

public class Assento {
    private String id;
    private int fileira;
    private int coluna;

    public Assento(String id, int fileira, int coluna) {
        this.id = id;
        this.fileira = fileira;
        this.coluna = coluna;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFileira() {
        return fileira;
    }

    public void setFileira(int fileira) {
        this.fileira = fileira;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
}
