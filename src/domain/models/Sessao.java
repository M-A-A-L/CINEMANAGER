package domain.models;

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
        assentos = new AssentoSessao[fisicos.length][fisicos[0].length];
        for (Assento[] fileira: fisicos) {
            for (Assento fisico : fileira) {
                assentos[fisico.getColuna()][fisico.getFileira()] = new AssentoSessao(fisico);
            }
        }
    }

    public AssentoSessao[][] getAssentos() {
        return assentos;
    }
    public void setAssentos(AssentoSessao[][] assentos) {
        this.assentos = assentos;
    }
}