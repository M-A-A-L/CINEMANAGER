package controller;

import domain.model.Filme;
import domain.model.FormasPagamento;
import domain.model.Sessao;
import domain.model.TiposIngresso;
import domain.model.ingressos.Ingresso;
import domain.padroes.facade.VendaFacade;
import service.SessaoService;

import java.util.List;

public class ClienteController {
    private final SessaoService sessaoService;
    private final VendaFacade facade;

    public ClienteController(SessaoService sessaoService, VendaFacade facade) {
        this.sessaoService = sessaoService;
        this.facade = facade;
    }

    //listar filmes em cartaz
    public String listarFilmesEmCartaz() {
        List<Filme> filmes = sessaoService.listarFilmesEmCartaz();
        if (filmes.isEmpty()) {
            return "Nenhum filme em cartaz no momento";
        }
        StringBuilder sb = new StringBuilder();
        for (Filme filme: filmes) {
            sb.append(Formatador.filme(filme)).append("\n");
        }
        return sb.toString().trim();
    }

    //listar sessões de um filme
    public String listarSessoesDoFilme(int idFilme) {
        List<Sessao> sessoes = sessaoService.listarSessoesPorFilme(idFilme);
        if (sessoes.isEmpty()) {
            return "Nenhuma sessão disponivel para o filme selecionado";
        }
        StringBuilder sb = new StringBuilder();
        for (Sessao sessao: sessoes) {
            sb.append(Formatador.sessao(sessao)).append("\n");
        }
        return sb.toString().trim();
    }
    //selecionar e reservar assento
    public String mostrarAssentos (int idSessao) {
        try {
            Sessao sessao = sessaoService.buscarSessaoPorId(idSessao);
            return Formatador.mapaAssentos(sessao);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Erro: " + e.getMessage();
        }
    }
    // vender ingresso
    public String finalizarCompra(TiposIngresso tipo, int idSessao, String idAssento, FormasPagamento formaPagamento) {
        try {
            String comprovante = facade.processarVenda(tipo, idSessao, idAssento, formaPagamento);
            return "Compra realizada com sucesso\n\n"+comprovante;
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Erro: "+e.getMessage();
        }
    }
    // cancelar ingreso
    public String cancelarIngresso(String idIngresso) {
        try {
            facade.cancelarVenda(idIngresso);
            return "Ingresso cancelado e valor estornado.";
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Erro: "+e.getMessage();
        }
    }

}
