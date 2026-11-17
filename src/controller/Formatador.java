package controller;

import domain.model.Assento;
import domain.model.AssentoSessao;
import domain.model.Filme;
import domain.model.Sala;
import domain.model.Sessao;
import domain.model.ingressos.Ingresso;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

final class Formatador {

    private Formatador() {
    }

    static String filme(Filme f) {
        return String.format("[%d] %s (%d) - %s - %d min",
                f.getId(), f.getNome(), f.getAno(), f.getGenero(), f.getDuracaoMin());
    }

    static String sala(Sala s) {
        Assento[][] assentos = s.getAssentos();
        int fileiras = assentos.length;
        int colunas = assentos[0].length;
        return String.format("Sala %d - %d fileiras x %d colunas (%d lugares)",
                s.getNumero(), fileiras, colunas, fileiras * colunas);
    }

    static String sessao(Sessao s) {
        DateTimeFormatter fmtDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");

        return String.format("Sessão %d | %s | Sala %d | %s | R$ %.2f",
                s.getId(), s.getFilme().getNome(), s.getSala().getNumero(), s.getDataHora().format(fmtDataHora), s.getPreco());
    }

    static String mapaAssentos(Sessao s) {
        AssentoSessao[][] mapa = s.getAssentos();
        StringBuilder sb = new StringBuilder();
        sb.append(sessao(s)).append("\n\n");
        for (AssentoSessao[] fileira : mapa) {
            for (AssentoSessao assento : fileira) {
                String texto = assento.estaDisponivel()
                        ? assento.getAssentoFisico().getId()
                        : "XX";
                sb.append(String.format("%-5s", texto));
            }
            sb.append("\n");
        }
        sb.append("\nXX = ocupado");
        return sb.toString();
    }
}