package controller;

import domain.model.Filme;
import domain.model.Sala;
import domain.model.Sessao;
import service.FilmeService;
import service.SalaService;
import service.SessaoService;

import java.time.LocalDateTime;
import java.util.List;

public class AdminController {
    private final FilmeService filmeService;
    private final SalaService salaService;
    private final SessaoService sessaoService;

    public AdminController(FilmeService filmeService, SalaService salaService, SessaoService sessaoService) {
        this.filmeService = filmeService;
        this.salaService = salaService;
        this.sessaoService = sessaoService;
    }

    //filme
    public String cadastrarFilme(String nome, int ano, String genero, int duracaoMin) {
        try {
            filmeService.salvarFilme(nome, ano, genero,duracaoMin);
            return "Filme cadastrado";
        } catch (IllegalStateException | IllegalArgumentException e) {
            return "Erro: "+ e.getMessage();
        }

    }
    public String listarFilmes() {
        List<Filme> filmes = filmeService.listarFilmes();
        if (filmes.isEmpty()) {
            return "Nenhum filme cadastrado";
        }
        StringBuilder sb = new StringBuilder();
        for (Filme filme: filmes) {
            sb.append(Formatador.filme(filme)).append("\n");
        }
        return sb.toString().trim();
    }
    public String buscarFilme(int idFilme) {
        try {
            Filme filme = filmeService.buscarFilmePorId(idFilme);
            return Formatador.filme(filme);
        } catch (IllegalStateException | IllegalArgumentException e) {
            return "Erro: "+ e.getMessage();
        }
    }
    public String removerFilme(int idFilme) {
        try {
            filmeService.deletarFilme(idFilme);
            return "Filme deletado";
        } catch (IllegalStateException | IllegalArgumentException e) {
            return "Erro: "+ e.getMessage();
        }
    }

    //sala
    public String cadastrarSala(int id, int fileiras, int colunas) {
        try {
            salaService.cadastrarSala(id, fileiras, colunas);
            return "Sala cadastrada";
        } catch (IllegalStateException | IllegalArgumentException e) {
            return "Erro: "+ e.getMessage();
        }

    }
    public String listarSalas() {
        List<Sala> salas = salaService.listarSalas();
        if (salas.isEmpty()) {
            return "Nenhuma sala cadastrada";
        }
        StringBuilder sb = new StringBuilder();
        for (Sala sala: salas) {
            sb.append(Formatador.sala(sala)).append("\n");
        }
        return sb.toString().trim();
    }
    public String buscarSala(int idSala) {
        try {
            Sala sala = salaService.buscarSalaPorId(idSala);
            return Formatador.sala(sala);
        } catch (IllegalStateException | IllegalArgumentException e) {
            return "Erro: "+ e.getMessage();
        }
    }
    public String removerSala(int idSala) {
        try {
            salaService.deletarSala(idSala);
            return "Sala removida";
        } catch (IllegalStateException | IllegalArgumentException e) {
            return "Erro: "+ e.getMessage();
        }
    }

    //sessao
    public String criarSessao(int idFilme, int idSala, LocalDateTime dataHora, double precoBase) {
        try {
            sessaoService.criarSessao(idFilme, idSala, dataHora, precoBase);
            return "Sessão cadastrada";
        } catch (IllegalStateException | IllegalArgumentException e) {
            return "Erro: "+ e.getMessage();
        }

    }
    public String listarSessoes() {
        List<Sessao> sessoes = sessaoService.listarSessoes();
        if (sessoes.isEmpty()) {
            return "Nenhuma sessao cadastrada";
        }
        StringBuilder sb = new StringBuilder();
        for (Sessao sessao: sessoes) {
            sb.append(Formatador.sessao(sessao)).append("\n");
        }
        return sb.toString().trim();
    }
    public String buscarSessao(int idSessao) {
        try {
            Sessao sessao = sessaoService.buscarSessaoPorId(idSessao);
            return Formatador.sessao(sessao);
        } catch (IllegalStateException | IllegalArgumentException e) {
            return "Erro: "+ e.getMessage();
        }
    }
    public String deletarSessao(int idSessao) {
        try {
            sessaoService.removerSessao(idSessao);
            return "Sessao Deletada";
        } catch (IllegalStateException | IllegalArgumentException e) {
            return "Erro: "+ e.getMessage();
        }
    }
}
