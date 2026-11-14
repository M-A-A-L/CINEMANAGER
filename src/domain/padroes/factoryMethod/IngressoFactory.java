package domain.padroes.factoryMethod;

import domain.model.AssentoSessao;
import domain.model.Ingresso;
import domain.model.Sessao;

public abstract class IngressoFactory { 
    public abstract Ingresso criarIngresso(Sessao sessao, AssentoSessao assento);

}
