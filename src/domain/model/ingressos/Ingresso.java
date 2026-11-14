package domain.model.ingressos;

import domain.model.AssentoSessao;
import domain.model.FormasPagamento;
import domain.model.Sessao;
import domain.model.TiposIngresso;

import java.util.UUID;

public abstract class Ingresso {
    private String id;
    private Sessao sessao;
    private AssentoSessao assento;
    private double valor;
    private FormasPagamento formaPagamento;

    public Ingresso(Sessao sessao, AssentoSessao assento, double valor, FormasPagamento formaPagamento) {
        this.id = gerarId();
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
    public abstract TiposIngresso getTipoIngresso();
    public abstract String adicionais();

    private String gerarId() {
        String uuidAleatorio = UUID.randomUUID().toString().replace("-","").substring(0, 6).toUpperCase();
        return "CINETKT-"+uuidAleatorio;
    }
}

