package domain.padroes;

import domain.model.AssentoSessao;
import domain.model.Ingresso;
import domain.model.Sessao;
import domain.padroes.strategy.*;

public class IngressoFactory {

    public static Ingresso criarIngresso(String tipo, Sessao sessao, AssentoSessao assento) {
        CalculadorDePreco calculador = new CalculadorDePreco();
        switch (tipo.toLowerCase()) {
            case "meia" -> calculador.setTipodePreco(new PrecoMeiaEntrada());
            case "promocional" -> calculador.setTipodePreco(new PrecoPromocional());
            default -> calculador.setTipodePreco(new PrecoInteira());
        }
        double precoBase = sessao.getPreco();
        double valorFinal = calculador.calcular(precoBase);
        return new Ingresso(tipo, sessao, assento, valorFinal);
    }
}