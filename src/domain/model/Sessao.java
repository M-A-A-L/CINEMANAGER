package domain.model;

public class Sessao {
    private int id;
    private Filme filme;
    private int horario;
    private Sala sala;
    private double preco;
    private AssentoSessao[][] assentos;

    public Sessao (Filme filme, Sala sala, int horario, double preco) {
        this.id = filme.getId()+sala.getNumero();
        this.filme = filme;
        this.horario = horario;
        this.sala = sala;
        this.preco = preco;

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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public AssentoSessao[][] getAssentos() {
        return assentos;
    }

    public AssentoSessao buscarAsssento(String idAssento) {
        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j <assentos[i].length; j++) {
                AssentoSessao atual = assentos[i][j];
                if (atual != null && atual.getAssentoFisico().getId().equalsIgnoreCase(idAssento)) {
                    return atual;
                }
            }
        }
        return null;
    }
}