package domain.padroes.factoryMethod;

import domain.model.AssentoSessao;
import domain.model.FormasPagamento;
import domain.model.ingressos.Ingresso;
import domain.model.Sessao;
import domain.model.ingressos.IngressoMeia;
import domain.padroes.strategy.CalcularPreco;
import domain.padroes.strategy.PrecoMeiaEntrada;

public class IngressoMeiaFactory extends IngressoFactory{

    @Override
    protected CalcularPreco definirEstrategiaPreco() {
        return new PrecoMeiaEntrada();
    }
    @Override
    protected Ingresso instanciarIngresso(Sessao sessao, AssentoSessao assento, double valorFinal, FormasPagamento formaPagamento) {
        return new IngressoMeia(sessao, assento, valorFinal, formaPagamento);
    }
}
