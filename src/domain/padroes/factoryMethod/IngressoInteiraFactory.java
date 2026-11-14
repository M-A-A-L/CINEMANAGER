package domain.padroes.factoryMethod;

import domain.model.AssentoSessao;
import domain.model.FormasPagamento;
import domain.model.ingressos.Ingresso;
import domain.model.Sessao;
import domain.model.ingressos.IngressoInteira;
import domain.padroes.strategy.CalcularPreco;
import domain.padroes.strategy.PrecoInteira;

public class IngressoInteiraFactory extends IngressoFactory{

    @Override
    protected CalcularPreco definirEstrategiaPreco() {
        return new PrecoInteira();
    }

    @Override
    protected Ingresso instanciarIngresso(Sessao sessao, AssentoSessao assento, double valorFinal, FormasPagamento formaPagamento) {
        return new IngressoInteira(sessao, assento, valorFinal, formaPagamento);
    }
}
