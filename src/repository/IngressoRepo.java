package repository;

import domain.model.ingressos.Ingresso;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class IngressoRepo {
    private Map<String, Ingresso> ingressos;

    public IngressoRepo() {
        ingressos = new HashMap<>();
    }
    public void salvarIngresso(Ingresso ingresso) {
        ingressos.put(ingresso.getId(), ingresso);
    }

    public void AtualizarIngresso(String id, Ingresso ingresso) {
        ingressos.replace(id, ingresso);
    }
    public Ingresso buscarIngresso(String id) {
        return ingressos.get(id);
    }
    public Collection<Ingresso> listarIngressos() {
        return ingressos.values();
    }

    public void RemoverIngresso(String id) {
        ingressos.remove(id);
    }
}
