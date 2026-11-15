package service;

import domain.model.ingressos.Ingresso;

import java.time.format.DateTimeFormatter;

public class GeradorComprovante {
    public String emitirBilhete(Ingresso ingresso) {
        if (ingresso == null) {
            throw new IllegalArgumentException("Não é possível gerar comprovante para um ingresso nulo.");
        }
        DateTimeFormatter fmtDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("""
                ==================================================
                             COMPROVANTE DE INGRESSO              
                ==================================================
                ID do Bilhete : %s
                Modalidade    : %s
                Filme         : %s
                Sala          : %d
                Data/Horário  : %s
                Assento       : %s
                Pagamento     : %s
                Valor Pago    : R$ %.2f
                """,
                ingresso.getId(),
                ingresso.getTipoIngresso().name(),
                ingresso.getSessao().getFilme().getNome(),
                ingresso.getSessao().getSala().getNumero(),
                ingresso.getSessao().getDataHora().format(fmtDataHora),
                ingresso.getAssento().getAssentoFisico().getId(),
                ingresso.getFormaPagamento(),
                ingresso.getValor()));
        if (ingresso.adicionais() != null && !ingresso.adicionais().isBlank()) {
            sb.append(String.format("""
                    --------------------------------------------------
                    OBS: %s
                    """,
                    ingresso.adicionais()));
        }
        sb.append("==================================================");
        return sb.toString().trim();
    }
}
