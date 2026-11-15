package repository;

import domain.model.Filme;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FilmeRepo {
    private Map<Integer, Filme> filmes;
    private int id;

    public FilmeRepo() {
        filmes = new HashMap<>();
        id = 1;
    }

    public void salvarFilme(Filme filme) {
        filme.setId(this.id);
        filmes.put(filme.getId(), filme);
        id++;
    }

    public void atualizarFilme(int id, Filme filme) {
        filmes.replace(id, filme);
    }
    public Filme buscarFilme(int id) {
        return filmes.get(id);
    }
    public Collection<Filme> listarFilmes() {
        return filmes.values();
    }

    public void removerFilme(int id) {
        filmes.remove(id);
    }
}
