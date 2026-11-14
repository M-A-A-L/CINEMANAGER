package domain.model.ingressos;

import domain.model.AssentoSessao;
import domain.model.FormasPagamento;
import domain.model.Sessao;
import domain.model.TiposIngresso;

public class IngressoInteira extends Ingresso {
    public IngressoInteira(Sessao sessao, AssentoSessao assento, double valor, FormasPagamento formaPagamento) {
        super(sessao, assento, valor, formaPagamento);
    }

    @Override
    public String adicionais() {
        return null;
    }

    @Override
    public TiposIngresso getTipoIngresso() {
        return TiposIngresso.INTEIRA;
    }
}