package domain.model.ingressos;

import domain.model.AssentoSessao;
import domain.model.FormasPagamento;
import domain.model.Sessao;
import domain.model.TiposIngresso;

public class IngressoVip extends Ingresso{

    private String codigoComboVip;

    public IngressoVip (Sessao sessao, AssentoSessao assento, double valor, FormasPagamento formaPagamento) {
        super(sessao, assento, valor, formaPagamento);
        this.codigoComboVip = "VIP-" + getId();
    }

    @Override
    public String adicionais() {
        return "BENEFÍCIO VIP: "+codigoComboVip+"\nAcesso Lounge + Voucher Pipoca";
    }

    @Override
    public TiposIngresso getTipoIngresso() {
        return TiposIngresso.VIP;
    }
}