package repository;

import domain.model.Filme;
import domain.model.Sala;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SalaRepo {
    private Map<Integer, Sala> salas;

    public SalaRepo() {
        salas = new HashMap<>();
    }

    public void salvarSala(Sala sala) {
        salas.put(sala.getNumero(), sala);
    }

    public void atualizarSala(int numero, Sala sala) {
        salas.replace(numero, sala);
    }
    public Sala buscarSala(int numero) {
        return salas.get(numero);
    }

    public Collection<Sala> listarSalas() {
        return salas.values();
    }

    public void removerSala(int numero) {
        salas.remove(numero);
    }
}
