package domain.model;

import java.time.LocalDateTime;

public class Sessao {
    private int id;
    private Filme filme;
    private LocalDateTime dataHora;
    private Sala sala;
    private double preco;
    private AssentoSessao[][] assentos;

    public Sessao (Filme filme, Sala sala, LocalDateTime dataHora, double preco) {
        this.filme = filme;
        this.dataHora = dataHora;
        this.sala = sala;
        this.preco = preco;

        Assento[][] fisicos = sala.getAssentos();
        int fileiras = fisicos.length;
        int colunas = fisicos[0].length;
        this.assentos = new AssentoSessao[fileiras][colunas];
        for (int i = 0; i < fileiras; i++) {
            for (int j = 0; j < colunas; j++) {
                this.assentos[i][j] = new AssentoSessao(fisicos[i][j]);
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public LocalDateTime getDataHora() {
        return this.dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public AssentoSessao[][] getAssentos() {
        return assentos;
    }

    public AssentoSessao buscarAssento(String idAssento) {
        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j <assentos[i].length; j++) {
                AssentoSessao atual = assentos[i][j];
                if (atual != null && atual.getAssentoFisico().getId().equalsIgnoreCase(idAssento)) {
                    return atual;
                }
            }
        }
        return null;
    }
    public LocalDateTime getFim() {
        return dataHora.plusMinutes(filme.getDuracaoMin());
    }
    public boolean conflitaCom(Sessao outra) {
        return this.sala.getNumero() == outra.sala.getNumero() && this.dataHora.isBefore(outra.getFim()) && outra.dataHora.isBefore(this.getFim());
    }
}