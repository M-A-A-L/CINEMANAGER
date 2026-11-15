package domain.padroes.state;

import domain.model.AssentoSessao;

public class Vendido implements EstadoAssentoSessao{
    @Override
    public void reservarAssento(AssentoSessao assento) {
        throw new IllegalStateException("O assento não pode ser reservado pois já foi vendido");
    };
    @Override
    public void venderAssento(AssentoSessao assento) {
        throw new IllegalStateException("O assento já está vendido");
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
        return "VENDIDO";
    }
}