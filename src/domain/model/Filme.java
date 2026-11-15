package domain.model;

public class Filme {
    private int id;
    private String nome;
    private int ano;
    private String genero;
    private int duracaoMin;

    public Filme(String nome, int ano, String genero, int duracaoMin) {
        this.nome = nome;
        this.ano = ano;
        this.genero = genero;
        this.duracaoMin = duracaoMin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracaoMin() {
        return duracaoMin;
    }

    public void setDuracaoMin(int duracaoMin) {
        this.duracaoMin = duracaoMin;
    }
}
