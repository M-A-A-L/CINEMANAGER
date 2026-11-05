package domain.models;

public class AssentoSessao {
    private Assento assentoFisico;
    private String estado;

    public AssentoSessao(Assento assentoFisico) {
        this.assentoFisico = assentoFisico;
        estado = "Disponivel";
    }

    public Assento getAssentoFisico() {
        return assentoFisico;
    }
}