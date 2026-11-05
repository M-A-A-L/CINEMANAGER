package domain.models;

import java.time.LocalDate;

public class Filme {
    public int id;
    private String nome;
    private int ano;
    private String genero;

    public Filme(String nome, int ano, String genero) {
        this.nome = nome;
        this.ano = ano;
        this.genero = genero;
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
}
