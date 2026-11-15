package domain.padroes.state;

import domain.model.AssentoSessao;

public class Disponivel implements EstadoAssentoSessao{
    @Override
    public void reservarAssento(AssentoSessao assento) {
        assento.setDisponibilidade(new Reservado());
    };
    @Override
    public void venderAssento(AssentoSessao assento) {
        throw new IllegalStateException("O assento ainda não foi reservado para ser vendido");
    };
    @Override
    public void disponibilizarAssento(AssentoSessao assento) {
        throw new IllegalStateException("O assento já está disponivél");
    };
    @Override
    public boolean estaDisponivel() {
        return true;
    }
    @Override
    public String getDescricao() {
        return "DISPONIVEL";
    }
}
