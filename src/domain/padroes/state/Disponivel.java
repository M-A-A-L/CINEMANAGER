package domain.padroes.state;

import domain.model.AssentoSessao;

public class Disponivel implements EstadoAssentoSessao{
    @Override
    public void reservarAssento(AssentoSessao assento) {
        assento.setDisponibilidade(new Reservado());
    };
    @Override
    public void venderAssento(AssentoSessao assento) {
        throw new IllegalArgumentException("O assento ainda não foi reservado para ser vendido");
    };
    @Override
    public void disponibilizarAssento(AssentoSessao assento) {
        throw new IllegalArgumentException("O assento já está disponivél");
    };
}
