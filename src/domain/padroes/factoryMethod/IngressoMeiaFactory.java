package domain.padroes.factoryMethod;

import domain.model.AssentoSessao;
import domain.model.Ingresso;
import domain.model.Sessao;

public class IngressoMeiaFactory extends IngressoFactory{

    @Override
    public Ingresso criarIngresso(Sessao sessao, AssentoSessao assento) {
        return new Ingresso("Meia", sessao, assento);
    }
    
}
