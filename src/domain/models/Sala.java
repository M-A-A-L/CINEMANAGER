package domain.models;

public class Sala {
    private int id;
    private Assento[][] assentos;

    public Sala(int id, int fileiras, int colunas) {
        this.id = id;
        assentos = new Assento[fileiras][colunas];
        PreencherAssentos(fileiras, colunas);
    }

    public Assento[][] getAssentos() {
        return assentos;
    }

    public void setAssentos(Assento[][] assentos) {
        this.assentos = assentos;
    }

    private void PreencherAssentos(int fileiras, int colunas) {
        for (int i=0; i < colunas; i++){
            char identificador = 'A';
            identificador += i;
            for (int j=0; j < fileiras; j++) {
                String codigo = String.valueOf(identificador) + String.valueOf(j);
                assentos[i][j] = new Assento(codigo, i, j);
            }
        }
    }
    public void listarAssentos() {
        for (Assento[] coluna : assentos) {
            for (Assento assento : coluna) {
                System.out.println(assento.getId());
            }
        }
    }
    public Assento[][] retornarassentos() {
        return assentos;
    }
}
