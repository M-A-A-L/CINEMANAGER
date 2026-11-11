package domain.model;

import domain.padroes.state.Disponivel;
import domain.padroes.state.EstadoAssentoSessao;

public class AssentoSessao {
    private Assento assentoFisico;
    private EstadoAssentoSessao disponibilidade;

    public AssentoSessao(Assento assentoFisico) {
        this.assentoFisico = assentoFisico;
        disponibilidade = new Disponivel();
    }

    public Assento getAssentoFisico() {
        return assentoFisico;
    }

    public void setDisponibilidade(EstadoAssentoSessao disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void disponibilizar() {
        this.disponibilidade.disponibilizarAssento(this);
    }
    public void reservar() {
        this.disponibilidade.reservarAssento(this);
    }
    public void vender() {
        this.disponibilidade.venderAssento(this);
    }
}