package service;

import domain.model.AssentoSessao;
import domain.model.Filme;
import domain.model.Sala;
import domain.model.Sessao;
import repository.SessaoRepo;

import java.util.ArrayList;
import java.util.List;

public class SessaoService {

    private SessaoRepo sessaoRepo;
    private FilmeService filmeService;
    private SalaService salaService;

    public SessaoService(SessaoRepo sessaoRepo, FilmeService filmeService, SalaService salaService) {
        this.sessaoRepo = sessaoRepo;
        this.filmeService = filmeService;
        this.salaService = salaService;
    }

    public void criarSessao(int idFilme, int idSala, int horario, double precoBase) {
        if (precoBase <= 0) {
            throw new IllegalArgumentException("O preço base da sessão deve ser maior que zero");
        }
        Filme filme = filmeService.buscarFilmePorId(idFilme);
        Sala sala = salaService.buscarSalaPorId(idSala);

        Sessao sessao = new Sessao(filme, sala, horario, precoBase);
        sessaoRepo.salvarSessao(sessao);
    }

    public Sessao buscarSessaoPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID da sessao deve ser válidoo");
        }
        Sessao sessao = sessaoRepo.buscarSessao(id);
        if (sessao == null) {
            throw new IllegalArgumentException("Sessão não encontrada, com ID: " + id);
        }
        return sessao;
    }

    public List<Sessao> listarSessoes() {
        return new ArrayList<>(sessaoRepo.listarSessoes());
    }

    public void removerSessao(int id) {
        buscarSessaoPorId(id);
        sessaoRepo.RemoverSessao(id);
    }

    public AssentoSessao buscarAssentoNaSessao(int idSessao, String idAssento) {
        Sessao sessao = buscarSessaoPorId(idSessao);
        AssentoSessao assentoSessao = sessao.buscarAsssento(idAssento);
        if (assentoSessao == null) {
            throw new IllegalArgumentException("Assento "+ idAssento + " não existe nesta sala");
        }
        return assentoSessao;
    }
}
