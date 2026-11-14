package domain.model.ingressos;

import domain.model.AssentoSessao;
import domain.model.FormasPagamento;
import domain.model.Sessao;
import domain.model.TiposIngresso;

public class IngressoPromocional extends Ingresso{
    public IngressoPromocional(Sessao sessao, AssentoSessao assento, double valor, FormasPagamento formaPagamento) {
        super(sessao, assento, valor, formaPagamento);
    }

    @Override
    public String adicionais() {
        return "BENEFÍCIO PROMOCIONAL";
    }

    @Override
    public TiposIngresso getTipoIngresso() {
        return TiposIngresso.PROMOCIONAL;
    }
}
