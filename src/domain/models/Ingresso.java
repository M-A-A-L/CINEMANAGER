package domain.models;

public class Ingresso {
    private int id;
    private Sessao sessao;
    private AssentoSessao assento;

    public Ingresso(int id, Sessao sessao, AssentoSessao assento) {
        this.id = id;
        this.sessao = sessao;
        this.assento = assento;
    }
}

