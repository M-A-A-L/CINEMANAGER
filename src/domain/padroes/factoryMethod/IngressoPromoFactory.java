package domain.padroes.factoryMethod;

import domain.model.AssentoSessao;
import domain.model.FormasPagamento;
import domain.model.Sessao;
import domain.model.ingressos.Ingresso;
import domain.model.ingressos.IngressoPromocional;
import domain.padroes.strategy.CalcularPreco;
import domain.padroes.strategy.PrecoPromocional;

public class IngressoPromoFactory extends IngressoFactory{
    @Override
    protected CalcularPreco definirEstrategiaPreco() {
        return new PrecoPromocional();
    }
    @Override
    protected Ingresso instanciarIngresso(Sessao sessao, AssentoSessao assento, double valorFinal, FormasPagamento formaPagamento) {
        return new IngressoPromocional(sessao, assento, valorFinal, formaPagamento);
    }
}
