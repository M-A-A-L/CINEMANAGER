package domain;

import domain.model.FormasPagamento;

public class ProcessarPagamento {
    public boolean processarPagamento(double valor, FormasPagamento formaPagamento) {
        if (valor < 0) {
            throw new IllegalArgumentException("valor inválido");
        }
        if (formaPagamento == null) {
            throw new IllegalArgumentException("Método de pagamento não informado");
        }
        return true;
    }
    public String estornarPagamento(double valor, FormasPagamento formaPagamento) {
        return "Estorno no valor de R$ "+String.format("%2.f", valor)+" efetuado por meio de "+formaPagamento;
    }
}
