package domain.padroes.state;

import domain.model.AssentoSessao;

public interface EstadoAssentoSessao {
    void reservarAssento(AssentoSessao assento);
    void venderAssento(AssentoSessao assento);
    void disponibilizarAssento(AssentoSessao assento);
    boolean estaDisponivel();
    String getDescricao();
}
