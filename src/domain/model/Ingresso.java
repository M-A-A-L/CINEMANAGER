package domain.model;

import domain.padroes.strategy.CalcularPreco;

import java.util.UUID;

public class Ingresso {
    private String id;
    private Sessao sessao;
    private AssentoSessao assento;
    private String tipo;
    private double valor;
    private FormasPagamento formaPagamento;

    public Ingresso(String tipo, Sessao sessao, AssentoSessao assento, double valor, FormasPagamento formaPagamento) {
        this.id = gerarId();
        this.tipo = tipo;
        this.sessao = sessao;
        this.assento = assento;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public String getId() {
        return id;
    }
    public Sessao getSessao() {
        return sessao;
    }
    public AssentoSessao getAssento() {
        return assento;
    }
    public FormasPagamento getFormaPagamento() {
        return formaPagamento;
    }
    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    private String gerarId() {
        String uuidAleatorio = UUID.randomUUID().toString().replace("-","").substring(0, 6).toUpperCase();
        return "CINETKT-"+uuidAleatorio;
    }
}

