package domain.model.ingressos;

import domain.model.AssentoSessao;
import domain.model.FormasPagamento;
import domain.model.Sessao;
import domain.model.TiposIngresso;

public class IngressoMeia extends Ingresso{
    public IngressoMeia(Sessao sessao, AssentoSessao assento, double valor, FormasPagamento formaPagamento) {
        super(sessao, assento, valor, formaPagamento);
    }

    @Override
    public String adicionais() {
        return "BENEFÍCIO MEIA-ENTRADA\nApresentar carteirinha de benefício na entrada.";
    }

    @Override
    public TiposIngresso getTipoIngresso() {
        return TiposIngresso.MEIA;
    }
}
