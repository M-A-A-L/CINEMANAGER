package service;

import domain.model.AssentoSessao;
import domain.model.Filme;
import domain.model.Sala;
import domain.model.Sessao;
import repository.SessaoRepo;

import java.time.LocalDateTime;
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

    public void criarSessao(int idFilme, int idSala, LocalDateTime dataHora, double precoBase) {
        if (precoBase <= 0) {
            throw new IllegalArgumentException("O preço base da sessão deve ser maior que zero");
        }
        if (dataHora == null) {
            throw new IllegalArgumentException("A data e o horario da sessão não podem estar nulos");
        }
        Filme filme = filmeService.buscarFilmePorId(idFilme);
        Sala sala = salaService.buscarSalaPorId(idSala);

        Sessao sessao = new Sessao(filme, sala, dataHora, precoBase);
        for (Sessao existente : sessaoRepo.listarSessoes()) {
            if (sessao.conflitaCom(existente)) {
                throw new IllegalArgumentException("A sala "+sala.getNumero()+" já possui a sessão "+existente.getId()+" nesse período");
            }
        }
        sessaoRepo.salvarSessao(sessao);
    }

    public Sessao buscarSessaoPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID da sessao deve ser válido");
        }
        Sessao sessao = sessaoRepo.buscarSessao(id);
        if (sessao == null) {
            throw new IllegalArgumentException("Sessão não encontrada, com ID: " + id);
        }
        return sessao;
    }

    public List<Sessao> listarSessoes() {
        return sessaoRepo.listarSessoes();
    }

    public void removerSessao(int id) {
        buscarSessaoPorId(id);
        sessaoRepo.removerSessao(id);
    }

    public AssentoSessao buscarAssentoNaSessao(int idSessao, String idAssento) {
        Sessao sessao = buscarSessaoPorId(idSessao);
        AssentoSessao assentoSessao = sessao.buscarAssento(idAssento);
        if (assentoSessao == null) {
            throw new IllegalArgumentException("Assento "+ idAssento + " não existe nesta sala");
        }
        return assentoSessao;
    }

    public List<Filme> listarFilmesEmCartaz() {
        List<Filme> filmesEmCartaz = new ArrayList<>();
        for (Sessao sessao: sessaoRepo.listarSessoes()) {
            Filme filme = sessao.getFilme();
            if (!filmesEmCartaz.contains(filme)) {
                filmesEmCartaz.add(filme);
            }
        }
        return filmesEmCartaz;
    }

    public List<Sessao> listarSessoesPorFilme(int idFilme) {
        List<Sessao> sessoesDoFilme = new ArrayList<>();
        for (Sessao sessao: sessaoRepo.listarSessoes()) {
            if (sessao.getFilme().getId() == idFilme) {
                sessoesDoFilme.add(sessao);
            }
        }
        return sessoesDoFilme;
    }
}
