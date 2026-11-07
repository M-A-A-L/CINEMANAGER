package domain.model;

import java.util.UUID;

public class Ingresso {
    private String id;
    private Sessao sessao;
    private AssentoSessao assento;
    private String tipo;
    private double valor;

    public Ingresso(String tipo, Sessao sessao, AssentoSessao assento) {
        this.id = gerarId();
        this.tipo = tipo;
        this.sessao = sessao;
        this.assento = assento;
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
        String uuidAAleatorio = UUID.randomUUID().toString().replace("-","").substring(0, 6).toUpperCase();
        return "CINETKT-"+uuidAAleatorio;
    }
}

