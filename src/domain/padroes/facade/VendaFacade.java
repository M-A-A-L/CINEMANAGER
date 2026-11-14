package domain.padroes.facade;


import domain.ProcessarPagamento;
import domain.model.*;
import domain.padroes.IngressoFactory;
import repository.IngressoRepo;
import service.SessaoService;

public class VendaFacade {
    private IngressoRepo ingressoRepo;
    private SessaoService sessaoService;
    private ProcessarPagamento processarPagamento;

    public VendaFacade(IngressoRepo ingressoRepo, SessaoService sessaoService) {
        this.ingressoRepo = ingressoRepo;
        this.sessaoService = sessaoService;
        this.processarPagamento = new ProcessarPagamento();
    }

    public void processarVenda(String tipo,int idSessao, String idAssento, FormasPagamento formaPagamento) {
        Sessao sessao = sessaoService.buscarSessaoPorId(idSessao);
        AssentoSessao assentoSessao = sessaoService.buscarAssentoNaSessao( idSessao,idAssento);
        assentoSessao.vender();
        try {
            Ingresso ingresso = IngressoFactory.criarIngresso(tipo, sessao, assentoSessao, formaPagamento);
            processarPagamento.processarPagamento(ingresso.getValor(), formaPagamento);
            ingressoRepo.salvarIngresso(ingresso);
        }
        catch (Exception e) {
            assentoSessao.disponibilizar();
            throw e;
        }
    }

    public void cancelarVenda(String idIngresso) {
        if (idIngresso == null) {
            throw new IllegalArgumentException("ID do ingresso deve ser um valor válido");
        }
        Ingresso ingresso = ingressoRepo.buscarIngresso(idIngresso);
        if (ingresso == null) {
            throw  new IllegalArgumentException("Ingresso não encontrado, com ID: "+idIngresso);
        }
        processarPagamento.estornarPagamento(ingresso.getValor(), ingresso.getFormaPagamento());
        ingresso.getAssento().disponibilizar();
        ingressoRepo.RemoverIngresso(idIngresso);
    }
}
