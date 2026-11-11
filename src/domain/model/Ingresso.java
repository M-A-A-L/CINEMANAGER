package domain.model;

import domain.padroes.strategy.CalcularPreco;

import java.util.UUID;

public class Ingresso {
    private String id;
    private Sessao sessao;
    private AssentoSessao assento;
    private String tipo;
    private double valor;

    public Ingresso(String tipo, Sessao sessao, AssentoSessao assento, double valor) {
        this.id = gerarId();
        this.tipo = tipo;
        this.sessao = sessao;
        this.assento = assento;
        this.valor = valor;
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
    private String gerarId() {
        String uuidAleatorio = UUID.randomUUID().toString().replace("-","").substring(0, 6).toUpperCase();
        return "CINETKT-"+uuidAleatorio;
    }
}

