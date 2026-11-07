package domain.model;

public class Sessao {
    private int id;
    private Filme filme;
    private int horario;
    private Sala sala;
    private AssentoSessao[][] assentos;

    public Sessao(int id, Filme filme, int horario, Sala sala) {
        this.id = id;
        this.filme = filme;
        this.horario = horario;
        this.sala = sala;
        Assento[][] fisicos = sala.retornarassentos();
        int fileiras = fisicos.length;
        int colunas = fisicos[0].length;
        this.assentos = new AssentoSessao[fileiras][colunas];
        for (int i = 0; i < fileiras; i++) {
            for (int j = 0; j < colunas; j++) {
                this.assentos[i][j] = new AssentoSessao(fisicos[i][j]);
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public AssentoSessao[][] getAssentos() {
        return assentos;
    }
}