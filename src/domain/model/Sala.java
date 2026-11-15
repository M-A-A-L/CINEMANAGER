package domain.model;

public class Sala {
    private int numero;
    private Assento[][] assentos;

    public Sala(int id, int fileiras, int colunas) {
        this.numero = id;
        assentos = new Assento[fileiras][colunas];
        preencherAssentos(fileiras, colunas);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Assento[][] getAssentos() {
        return assentos;
    }

    public void setAssentos(Assento[][] assentos) {
        this.assentos = assentos;
    }

    private void preencherAssentos(int fileiras, int colunas) {
        for (int i=0; i < fileiras; i++){
            char letraFileira = (char)('A'+ i);
            for (int j=0; j < colunas; j++) {
                String codigo = letraFileira + String.valueOf(j+1);
                assentos[i][j] = new Assento(codigo, i, j);
            }
        }
    }
    public Assento[][] retornarassentos() {
        return assentos;
    }
}
