package repository;

import domain.model.Filme;
import domain.model.Sessao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SessaoRepo {
    private List<Sessao> sessoes;
    private int id;

    public SessaoRepo() {
        sessoes = new ArrayList<>();
        id = 1;
    }

    public void salvarSessao(Sessao sessao) {
        sessao.setId(id);
        sessoes.add(sessao);
        id++;
    }

    public void atualizarSessao(int id, Sessao sessao) {
        Sessao sessaoAntiga = buscarSessao(id);
        if (sessaoAntiga != null) {
            int i = sessoes.indexOf(sessaoAntiga);
            sessoes.set(i, sessao);
        }
    }
    public Sessao buscarSessao(int id) {
        for (Sessao sessao : sessoes) {
            if (sessao.getId() == id) {
                return sessao;
            }
        }
        return null;
    }
    public List<Sessao> listarSessoes() {
        return sessoes;
    }

    public void removerSessao(int id) {
        Sessao sessaoAntiga = buscarSessao(id);
        int i = sessoes.indexOf(sessaoAntiga);
        if (sessaoAntiga != null) {
            sessoes.remove(i);
        }
    }
}
