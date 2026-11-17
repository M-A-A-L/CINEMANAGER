package domain.padroes.factoryMethod;

import domain.model.AssentoSessao;
import domain.model.FormasPagamento;
import domain.model.ingressos.Ingresso;
import domain.model.Sessao;
import domain.padroes.strategy.CalculadorDePreco;
import domain.padroes.strategy.CalcularPreco;

public abstract class IngressoFactory { 
    protected abstract Ingresso instanciarIngresso(Sessao sessao, AssentoSessao assento, double valor, FormasPagamento formaPagamento);
    protected abstract CalcularPreco definirEstrategiaPreco();

    public final Ingresso criarIngresso(Sessao sessao, AssentoSessao assento, FormasPagamento formaPagamento) {
        if (assento.estaDisponivel()) {
            throw new IllegalStateException("O assento ainda está disponível; reserve-o antes de criar o ingresso");
        }
        CalculadorDePreco calculador = new CalculadorDePreco();
        calculador.setTipodePreco(definirEstrategiaPreco());
        double valorFinal = calculador.calcular(sessao.getPreco());
        return instanciarIngresso(sessao, assento, valorFinal, formaPagamento);
    }
}
