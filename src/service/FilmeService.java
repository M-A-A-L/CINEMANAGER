package service;

import domain.model.Filme;
import repository.FilmeRepo;

import java.util.ArrayList;
import java.util.List;

public class FilmeService {
    private FilmeRepo filmeRepo;

    public FilmeService(FilmeRepo filmeRepo) {
        this.filmeRepo = filmeRepo;
    }

    public void salvarFilme(String nome, int ano, String genero, int duracao) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do filme é obrigatório");
        }
        if (duracao <= 0) {
            throw new IllegalArgumentException("Duração do filme deve ser maior que zero");
        }
        Filme filme = new Filme(nome, ano, genero, duracao);
        filmeRepo.salvarFilme(filme);
    }

    public Filme buscarFilmePorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID do filme deve ser maior que zero");
        }
        Filme filme = filmeRepo.buscarFilme(id);
        if (filme == null) {
            throw  new IllegalArgumentException("Filme não encontrado, com ID: "+id);
        }
        return filme;
    }

    public List<Filme> listarFilmes() {
        return new ArrayList<>(filmeRepo.listarFilmes());
    }

    public void deletarFilme(int id) {
        buscarFilmePorId(id);
        filmeRepo.removerFilme(id);
    }
}
