package service;

import domain.model.Sala;
import repository.SalaRepo;

import java.util.ArrayList;
import java.util.List;

public class SalaService {
    private SalaRepo salaRepo;

    public SalaService(SalaRepo salaRepo) {
        this.salaRepo = salaRepo;
    }

    public void cadastrarSala(int id, int fileiras, int colunas) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID da sala deve ser maior que zero");
        }
        if (fileiras <= 0 || colunas <= 0) {
            throw new IllegalArgumentException("Número de colunas e fileiras deve ser maior que zero");
        }
        Sala sala = new Sala(id, fileiras, colunas);
        salaRepo.salvarSala(sala);
    }

    public Sala buscarSalaPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID da sala deve ser válidoo");
        }
        Sala sala = salaRepo.buscarSala(id);
        if (sala == null) {
            throw new IllegalArgumentException("Sala não encontrada, com ID: " + id);
        }
        return sala;
    }

    public List<Sala> listarSalas() {
        return new ArrayList<>(salaRepo.listarSalas());
    }

    public void deletarSala(int id) {
        buscarSalaPorId(id);
        salaRepo.removerSala(id);
    }
}
