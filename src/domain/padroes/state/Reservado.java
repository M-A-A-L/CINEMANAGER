package domain.padroes.state;

import domain.model.AssentoSessao;

public class Reservado implements EstadoAssentoSessao{
    @Override
    public void reservarAssento(AssentoSessao assento) {
        throw new IllegalStateException("O assento já está reservado");
    };
    @Override
    public void venderAssento(AssentoSessao assento) {
        assento.setDisponibilidade(new Vendido());
    };
    @Override
    public void disponibilizarAssento(AssentoSessao assento) {
        assento.setDisponibilidade(new Disponivel());
    };
    @Override
    public boolean estaDisponivel() {
        return false;
    }
    @Override
    public String getDescricao() {
        return "RESERVADO";
    }
}
