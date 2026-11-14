package domain.padroes.factoryMethod;

import domain.model.AssentoSessao;
import domain.model.FormasPagamento;
import domain.model.ingressos.Ingresso;
import domain.model.Sessao;
import domain.model.ingressos.IngressoVip;
import domain.padroes.strategy.CalcularPreco;
import domain.padroes.strategy.PrecoVip;

public class IngressoVipFactory extends IngressoFactory {

    @Override
    protected CalcularPreco definirEstrategiaPreco() {
        return new PrecoVip();
    }
    @Override
    protected Ingresso instanciarIngresso(Sessao sessao, AssentoSessao assento, double valorFinal, FormasPagamento formaPagamento) {
        return new IngressoVip(sessao, assento, valorFinal, formaPagamento);
    }
}
