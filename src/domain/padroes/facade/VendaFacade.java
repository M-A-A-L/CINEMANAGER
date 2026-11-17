package domain.padroes.facade;


import service.GeradorComprovante;
import service.ProcessadorPagamento;
import domain.model.*;
import domain.model.ingressos.Ingresso;
import domain.padroes.factoryMethod.IngressoFactory;
import domain.padroes.factoryMethod.IngressoInteiraFactory;
import domain.padroes.factoryMethod.IngressoMeiaFactory;
import domain.padroes.factoryMethod.IngressoPromoFactory;
import domain.padroes.factoryMethod.IngressoVipFactory;
import repository.IngressoRepo;
import service.SessaoService;

import java.util.Map;

public class VendaFacade {
    private IngressoRepo ingressoRepo;
    private SessaoService sessaoService;
    private ProcessadorPagamento processarPagamento;
    private GeradorComprovante geradorComprovante;
    private Map<TiposIngresso, IngressoFactory> fabricas;

    public VendaFacade(IngressoRepo ingressoRepo, SessaoService sessaoService) {
        this.ingressoRepo = ingressoRepo;
        this.sessaoService = sessaoService;
        this.processarPagamento = new ProcessadorPagamento();
        this.geradorComprovante = new GeradorComprovante();
        this.fabricas = Map.of(
                TiposIngresso.INTEIRA, new IngressoInteiraFactory(),
                TiposIngresso.MEIA, new IngressoMeiaFactory(),
                TiposIngresso.VIP, new IngressoVipFactory(),
                TiposIngresso.PROMOCIONAL, new IngressoPromoFactory()
        );
    }

    public String processarVenda(TiposIngresso tipo, int idSessao, String idAssento, FormasPagamento formaPagamento) {
        if (tipo == null || !fabricas.containsKey(tipo)) {
            throw new IllegalArgumentException("Tipo de ingresso inválido ou não suportado.");
        }
        Sessao sessao = sessaoService.buscarSessaoPorId(idSessao);
        AssentoSessao assentoSessao = sessaoService.buscarAssentoNaSessao(idSessao, idAssento);
        assentoSessao.reservar();
        try {
            IngressoFactory factory = fabricas.get(tipo);
            Ingresso ingresso = factory.criarIngresso(sessao, assentoSessao, formaPagamento);
            processarPagamento.processarPagamento(ingresso.getValor(), formaPagamento);
            assentoSessao.vender();
            ingressoRepo.salvarIngresso(ingresso);
            String comprovante = geradorComprovante.emitirBilhete(ingresso);
            return comprovante;}
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
        ingressoRepo.removerIngresso(idIngresso);
    }
}
